

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	
	Socket sk;
	PrintWriter out;
	BufferedReader in;
	String mess;
	
	
	public Client(String ip) {
		try {
			sk = new Socket(ip, 12345);
			out = new PrintWriter(sk.getOutputStream(), true);
			System.out.println("connexion réusi client");
			
			ServerListener sl = new ServerListener(sk);
			sl.start();

			//while(ClientGUI.shouldRun){
				
			//}
			
			
			
			//out.println("Pong");
			//out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Erreur réception client");
		} 
	}
	public void send(String str) throws IOException {
		out.println(str);//+"\r\n");
		if(str.equals("STOP")){
			in.close();
			System.exit(0);
		}
	}
	public String Message() {
		return mess;
	}
}
