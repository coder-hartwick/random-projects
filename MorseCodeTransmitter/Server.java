import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;


/*******************************************************************************
 * Author: Jordan Hartwick
 * Date: May 31, 2016 @ 7:23PM
 * Usage: java Server
 *
 * Purpose: To accept connections.
 * 
 * Tested on Windows and Ubuntu.
 *******************************************************************************
 */
public class Server extends Thread {
    
    
    private ServerSocket serverSocket;


	public static void main(String[] args) {
		new Server(7879).start();
	}
	

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
    
 
 	/*
 		Accept connections and display who has connected.
 	 */   
    @Override
    public void run() {
		ClientHandler clientHandler = new ClientHandler();
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("Server is active");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Waiting for connections!!!");
        while(serverSocket.isBound()) {
            try {
                Socket clientConnection = serverSocket.accept();
		        System.out.println("Client connected from: "+clientConnection.getRemoteSocketAddress());
                clientHandler.addAndHandleConnection(clientConnection);
            } catch (IOException err) {
                err.printStackTrace();
            }
        }                  
    }
}
