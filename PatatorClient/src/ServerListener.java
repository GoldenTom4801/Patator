import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerListener extends Thread{

	private Socket skt = null;
	
	public ServerListener(Socket skt){
		this.skt = skt;
	}
	
	@Override
	public void run(){
		BufferedReader in;
		try {
			
			while(true){
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			while (!in.ready()) {}
			if (ClientGUI.cmd.split(" ")[0].equals("download")) { 
				BufferedOutputStream buo = new BufferedOutputStream(new FileOutputStream(new File("file.txt")));
				buo.write(in.read());
			}
			else {
			ClientGUI.setMess(in.readLine()); }
			
			Thread.sleep(10);
			}
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
