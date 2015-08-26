import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ServerListener extends Thread{

	private Socket skt = null;
	public static boolean isLive = false;
	Screenshot scrnshot;
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
			else if(ClientGUI.cmd.equals("screenshot") || ClientGUI.cmd.equals("live")) {
				BufferedImage bi = ImageIO.read(skt.getInputStream());
				ImageIO.write(bi, "png", new File("screenshot.png"));
				in.read();
				if (scrnshot == null) {
					scrnshot = new Screenshot(); 
					scrnshot.setVisible(true);
				} 
				scrnshot.update();
				if (isLive == true) {
					Client.send("screenshot");
				}
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
