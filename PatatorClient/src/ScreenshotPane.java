import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class ScreenshotPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image image;
	/**
	 * Create the panel.
	 */
	public void paintComponent(Graphics g) {
		try {
			image = ImageIO.read(new File("C:/Users/thomas/Desktop/screenshot.png"));
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
