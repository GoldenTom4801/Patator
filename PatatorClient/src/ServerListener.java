import java.io.BufferedReader;
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
			ClientGUI.recv = in.readLine();
			
			Thread.sleep(10);
			}
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
