package parchis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {

	private JPanel contentPane;
	JLabel usr_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
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
	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 707);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				while (true) { 
				    // Se inserta la ubicacion del mouse
				    double x = e.getX();
				    double y = e.getY();
				    
				    System.out.println("Posicion x = "+x+" Posicion y = "+y);
				    
				    return;
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usr_1 = new JLabel("");
		usr_1.setHorizontalAlignment(SwingConstants.CENTER);
		usr_1.setVerticalAlignment(SwingConstants.TOP);
		usr_1.setBounds(652, 30, 200, 14);
		contentPane.add(usr_1);
		
		JLabel usr_2 = new JLabel("");
		usr_2.setBounds(694, 43, 116, 14);
		contentPane.add(usr_2);
		
		JLabel resultdado = new JLabel("");
		resultdado.setHorizontalAlignment(SwingConstants.CENTER);
		resultdado.setBounds(157, 625, 46, 23);
		contentPane.add(resultdado);
		
		JButton btnNewButton = new JButton("Tirar dado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dado d1= new Dado();
				int n= d1.tirarDado();
				String n1= String.valueOf(n);
				resultdado.setText(n1);
				
			}
		});
		btnNewButton.setBounds(36, 625, 111, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 613, 614);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Game.class.getResource("/parchis.png")));
		lblNewLabel.setBounds(10, 11, 606, 592);
		panel.add(lblNewLabel);
		
		JLabel lbl_chat = new JLabel("CHAT");
		lbl_chat.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_chat.setBounds(730, 353, 46, 14);
		contentPane.add(lbl_chat);
		
		JTextArea area_instruct = new JTextArea();
		area_instruct.setEditable(false);
		area_instruct.setBounds(652, 97, 221, 219);
		contentPane.add(area_instruct);
		
		JTextArea area_chat = new JTextArea();
		area_chat.setBounds(652, 371, 221, 243);
		contentPane.add(area_chat);
		
	
	}
}
