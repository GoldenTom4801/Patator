package Virus.socket;

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
			sk = new Socket(ip, 12347);
			out = new PrintWriter(sk.getOutputStream(), true);
			System.out.println("connexion r�usi client");
			PrintWriter out = new PrintWriter(sk.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			while (!in.ready()) {}
			mess = in.readLine();
			in.close();
			
			
			
			out.println("Pong");
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Erreur r�ception client");
		} 
	}
	public void send(String str) {
		out.println(str+"\r\n");
	}
	public String Message() {
		return mess;
	}
}
