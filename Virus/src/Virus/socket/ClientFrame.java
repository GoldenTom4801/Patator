package Virus.socket;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ClientFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-298,399
	 */
	private final JTextField textField = new JTextField();
	private JTextField textField_1;
	private Client clt;
	private JTextField textField_2;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 81, 124, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton sendButton = new JButton("Send");
		sendButton.setBounds(472, 80, 89, 23);
		contentPane.add(sendButton);
		sendButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				clt.send(textField_1.getText());
				
			}
		});
		
		label = new JLabel("");
		label.setBounds(44, 149, 547, 288);
		contentPane.add(label);
		
		
		/*NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);*/
		textField_2 = new JTextField();
		textField_2.setBounds(115, 34, 124, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(472, 33, 89, 23);
		contentPane.add(btnConnect);
		btnConnect.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clt = new Client(textField_2.getText().toString());
				label.setText(clt.Message());
			}
		});
	}
}
