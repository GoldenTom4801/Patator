package patator.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServeurListener extends Thread{

	private Socket skt = null;
	
	public ServeurListener(Socket skt){
		this.skt = skt;
		System.out.println("server: listener started");
	}
	
	@Override
	public void run(){
		BufferedReader in;
		try {
			
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.println("Server: listener running !");
			while(!Serveur.recv.equals("STOP")){
			
			while (!in.ready()) {}
			//if (in.readLine().equals("tree"));
				//out.println("tree accept"+"\r\n");
			Serveur.recv= in.readLine();
			System.out.println(":"+in.readLine());
			
			
			Thread.sleep(10);
			}
			in.close();
			
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
