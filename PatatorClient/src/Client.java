

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	
	Socket sk;
	static PrintWriter out;
	String mess;
	
	
	public Client(String ip) {
		try {
			sk = new Socket(ip, 12345);
			out = new PrintWriter(sk.getOutputStream(), true);
			System.out.println("connexion r�usi client");
			
			ServerListener sl = new ServerListener(sk);
			sl.start();

			//while(ClientGUI.shouldRun){
				
			//}
			
			
			
			//out.println("Pong");
			//out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Erreur r�ception client");
		} 
	}
	public static void send(String str) throws IOException {
		if (str.equals("live")) {
			out.println("screenshot"+"\r\n");
			ServerListener.isLive = true;
		}
		else if (str.equals("live stop")) {
			ServerListener.isLive = false;
		}
		else {
			out.println(str+"\r\n");//+"\r\n");
		}
		if(str.equals("STOP")){
			System.exit(0);
		}
	}
	public String Message() {
		return mess;
	}
}
