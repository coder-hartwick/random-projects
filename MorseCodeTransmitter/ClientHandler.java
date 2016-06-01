import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/*******************************************************************************
 * Author: Jordan Hartwick
 * Date: May 31, 2016 @ 7:15PM
 * Usage: There is no usage information for this class. See the Purpose for more
 * info.
 *
 * Purpose: When the client sends a message, it will be broadcasted to everyone
 * currently connected to the server.
 * 
 * Tested on Windows and Ubuntu.
 *******************************************************************************
 */
public class ClientHandler {
    
    // The list of currently connected clients.
	private List<Socket> clients = new ArrayList<>();  
    
    
    /** Constructor method. */
    public ClientHandler() {}
    
    
    public void addAndHandleConnection(Socket clientConnection) {
        clients.add(clientConnection);
		startClientHandlerThread(clientConnection);
    }
    
    
    private void startClientHandlerThread(Socket connection) {
    	new Thread(new Runnable() {
    		
    		@Override
    		public void run() {
    			try {
    						
    				DataInputStream in = new DataInputStream(connection.getInputStream());
    				
    				// Listen for whatever the user sends.
    				while(!connection.isClosed()) {
    					String command = in.readUTF();
						broadcastToUsers(command, connection);
    				}
    			} catch (IOException err) {
    				err.printStackTrace();
    				System.out.println("Client " + connection.getRemoteSocketAddress() + " disconnected");
    			}
    		}
    	}).start();
    }
    
 
 	/**
 	 * Send the message to all users except for the one that sent the message.
 	 */   
	private void broadcastToUsers(String command, Socket connection) throws IOException {
		for(Socket s : clients) {
			if(!s.getRemoteSocketAddress().equals(connection.getRemoteSocketAddress())) {
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				out.writeUTF(command);
				out.flush();
			}
		}
	}
}
