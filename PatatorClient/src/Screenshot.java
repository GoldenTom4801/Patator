import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Screenshot extends JFrame {

	private ScreenshotPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screenshot frame = new Screenshot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screenshot() {
		ImageIcon image = new ImageIcon("screenshot.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new ScreenshotPane();
		setBounds(100, 100, image.getIconWidth()/2,image.getIconHeight()/2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void update() {
		ImageIcon image = new ImageIcon("screenshot.png");
		setBounds(100, 100, image.getIconWidth()/2,image.getIconHeight()/2);
		contentPane.repaint();
	}

}
