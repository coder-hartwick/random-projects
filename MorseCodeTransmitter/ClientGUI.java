import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;


/*******************************************************************************
 * Author: Jordan Hartwick
 * Date: May 31, 2016 @ 7:09 PM
 * Usage: java ClientGUI. Press Connect before typing in the text field. After,
 * you can type "s" for short beeps or "l" for long beeps and they will be
 * transmitted over the network.
 *
 * FOR TRANSMITTING OVER A NETWORK:
 * Change localhost (line 50) to the IP of the computer running Server.java. 
 *
 * Purpose: A networked Morse Code transmitter.
 *
 * Tested on Windows 7 and Ubuntu.
 *******************************************************************************
 */
public class ClientGUI extends Thread {
	
	
	// Window for the application.
	private JFrame window;
	
	// Contains the connect button and text field.
	private JPanel container;
	
	// When pressed, it will connect the client to the server.
	private JButton connect;
	
	// The IP address of the server running the Server.java application.
	private final String HOST = "localhost";
	
	// The port to connect to.
	private final int PORT = 7879;
	
	// The socket that will provide a connection to the server.
	private Socket socket;
	
	// I/O Streams to read and write from.
	private DataInputStream in;
	private DataOutputStream out;
	
	// The audio clips used to play sound.
	private Clip clip, clip2;
	
	
	/**
	 * Main method starts the client program.
	 */
	public static void main(String[] args) {
		new ClientGUI().createAndShowGUI();
	}
		

	public ClientGUI() {}
	
	
	public void createAndShowGUI() {
		window = new JFrame("Morse Code");
		container = new JPanel(new BorderLayout());
		
		connect = new JButton("Connect");
		connect.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connectToServer();	
			}
		});
		
		container.add(connect, BorderLayout.CENTER);

		// Create the JTextField.		
		JTextField textField = new JTextField(20);
		textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_L) {
					sendMessage("long");
				} else if(e.getKeyCode() == KeyEvent.VK_S) {
					sendMessage("short");
				}
			}
		});
		
		container.add(textField, BorderLayout.NORTH);	
						
		window.setContentPane(container);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(200,100);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	
	private void connectToServer() {
		try {
			setupAudioFiles();					
			socket = new Socket(HOST, PORT);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			this.start();	// Start listening for any incoming messages.
		} catch (Exception err) {
			System.out.println("Could not connect to server.");
			err.printStackTrace();
		}
	}
	
	
	private void sendMessage(String message) {
		try {
			out.writeUTF(message);
			out.flush();		
		} catch (IOException err) {
			System.out.println("Could not send message");
			err.printStackTrace();
		}

	}
	
	
	/*
		Listens for any incoming messages.
	 */
	@Override	
	public void run() {
		try {
			while(!socket.isClosed()) {
				String message = in.readUTF();
				if(message.equals("short")) {
	 				playShortBeep();				
				} else if(message.equals("long")) {
					playLongBeep();				
				}
			}		
		} catch (Exception err) {
			System.out.println("Could not read from socket.");
			err.printStackTrace();
		}

	}	
	
	
	private void setupAudioFiles() throws Exception {
		File shortBeep = new File("short.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(shortBeep);
		clip = AudioSystem.getClip();
		clip.open(ais);
		
		File longBeep = new File("long.wav");
		AudioInputStream ais2 = AudioSystem.getAudioInputStream(longBeep);
		clip2 = AudioSystem.getClip();
		clip2.open(ais2);
	}
	
	
	private void playShortBeep() throws Exception {
		clip.stop();
		clip.setFramePosition(0);
		clip.start();
	}	

	
	private void playLongBeep() throws Exception {
		clip2.stop();
		clip2.setFramePosition(0);		
		clip2.start();
	}
}	
