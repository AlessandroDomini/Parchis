package parchis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Game extends JFrame {

	private JPanel contentPane;
	JLabel usr_1;
	int ant1, ant2, ant3, ant4;
	protected Casilla casilla[]=new Casilla[68];
	protected Ficha amarillas[]=new Ficha[4];
	
	

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
		

	
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 613, 614);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
			}
		});
		btnNewButton_1.setBounds(442, 434, 46, 46);
		panel.add(btnNewButton_1);*/
		
		
		/*casilla[0] = new Casilla(350, 563);
		casilla[1] = new Casilla(350, 533);
		casilla[2] = new Casilla(350, 503);
		casilla[3] = new Casilla(350, 475);*/
		casilla[0] = new Casilla(350, 447);
		casilla[1] = new Casilla(350, 419);
		casilla[2] = new Casilla(350, 392);
		casilla[3] = new Casilla(350, 364);
		casilla[4] = new Casilla(350, 365);
		casilla[5] = new Casilla(375, 345);
		casilla[6] = new Casilla(405, 345);
		casilla[7] = new Casilla(430, 345);
		casilla[8] = new Casilla(460, 345);
		casilla[9] = new Casilla(488, 345);
		casilla[10] = new Casilla(515, 345);
		casilla[11] = new Casilla(545, 345);
		casilla[12] = new Casilla(575, 345);
		casilla[13] = new Casilla(575, 290);
		casilla[14] = new Casilla(575, 220);
		casilla[15] = new Casilla(545, 220);
		casilla[16] = new Casilla(515, 220);
		casilla[17] = new Casilla(488, 220);
		casilla[18] = new Casilla(460, 220);
		casilla[19] = new Casilla(430, 220);
		casilla[20] = new Casilla(405, 220);
		casilla[21] = new Casilla(350, 220);
		casilla[22] = new Casilla(350, 200);
		casilla[23] = new Casilla(350, 170);
		casilla[24] = new Casilla(350, 145);
		casilla[25] = new Casilla(350, 117);
		casilla[26] = new Casilla(350, 90);
		casilla[27] = new Casilla(350, 60);
		casilla[28] = new Casilla(350, 35);
		casilla[29] = new Casilla(350, 5);
		casilla[30] = new Casilla(300, 5);
		casilla[31] = new Casilla(230, 5);
		casilla[32] = new Casilla(230, 35);
		casilla[33] = new Casilla(230, 60);
		casilla[34] = new Casilla(230, 90);
		casilla[35] = new Casilla(230, 117);
		casilla[36] = new Casilla(230, 145);
		casilla[37] = new Casilla(230, 170);
		casilla[38] = new Casilla(230, 200);
		casilla[39] = new Casilla(210, 220);
		casilla[40] = new Casilla(185, 220);
		casilla[41] = new Casilla(155, 220);
		casilla[42] = new Casilla(130, 220);
		casilla[43] = new Casilla(100, 220);
		casilla[44] = new Casilla(70, 220);
		casilla[45] = new Casilla(45, 220);
		casilla[46] = new Casilla(15, 220);
		casilla[47] = new Casilla(15, 290);
		casilla[48] = new Casilla(15, 345);
		casilla[49] = new Casilla(45, 345);
		casilla[50] = new Casilla(70, 345);
		casilla[51] = new Casilla(100, 345);
		casilla[52] = new Casilla(130, 345);
		casilla[53] = new Casilla(155, 345);
		casilla[54] = new Casilla(185, 345);
		casilla[55] = new Casilla(210, 345);
		casilla[56] = new Casilla(230, 364);
		casilla[57] = new Casilla(230, 392);
		casilla[58] = new Casilla(230, 419);
		casilla[59] = new Casilla(230, 447);
		casilla[60] = new Casilla(230, 475);
		casilla[61] = new Casilla(230, 503);
		casilla[62] = new Casilla(230, 533);
		casilla[63] = new Casilla(230, 563);
		casilla[64] = new Casilla(300, 563);
		
		
		amarillas[0] = new Ficha(442, 434, panel);
		amarillas[1] = new Ficha(540, 434, panel);
		amarillas[2] = new Ficha(442 , 500, panel);
		amarillas[3] = new Ficha(540 , 500, panel);
		

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
				
				if(true) {
					amarillas[0].moverFicha(casilla[ant1+n-1]);
					ant1=ant1+n;
				}
				else if(true) {
					amarillas[1].moverFicha(casilla[ant2+n-1]);
					ant2=ant2+n;
				}
				else if(true) {
					amarillas[2].moverFicha(casilla[ant3+n-1]);
					ant3=ant3+n;
				}
				else if(true) {
					amarillas[3].moverFicha(casilla[ant4+n-1]);
					ant4=ant4+n;
				}
				System.out.println(ant1+" "+ant2+" "+ ant3+" "+ant4);

			}
		});
		
		btnNewButton.setBounds(36, 625, 111, 23);
		contentPane.add(btnNewButton);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usr_1 = new JLabel("");
		usr_1.setHorizontalAlignment(SwingConstants.CENTER);
		usr_1.setVerticalAlignment(SwingConstants.TOP);
		usr_1.setBounds(633, 30, 253, 27);
		contentPane.add(usr_1);
		
		JLabel usr_2 = new JLabel("");
		usr_2.setBounds(694, 43, 116, 14);
		contentPane.add(usr_2);
		
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
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Game.class.getResource("/parchis.png")));
		lblNewLabel.setBounds(10, 11, 606, 592);
		panel.add(lblNewLabel);
		
		
		
	
		
		

	}
}
