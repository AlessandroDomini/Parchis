package parchis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import parchis.TurnosServer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.Font;

public class Game extends JFrame {

	private JPanel contentPane;
	int anta1, anta2, anta3, anta4, antr1, antr2, antr3, antr4;
	protected String imagenA="/Ficha_amarilla.png";
	protected String imagenR="/Ficha_roja.png";
	protected Casilla casillaA[]=new Casilla[76];
	protected Casilla casillaR[]=new Casilla[76];
	protected Ficha amarillas[]=new Ficha[4];
	protected Ficha rojas[]=new Ficha[4];
	boolean turno=false;
	JTextArea area_usr;
	JButton btn_dado;
	JTextArea area_instruct;
	int n=0;
	DataInputStream input = null;
	DataOutputStream output = null;
	String who;
	TurnosGame leer;


	/**
	 * Create the frame.
	 */
	public Game(Socket socket) {
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
		
		
		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		leer = new TurnosGame(input, this);
		leer.start();
		
		
	
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 613, 614);
		contentPane.add(panel);
		panel.setLayout(null);
		
	
		casillaA[1] = new Casilla(345, 447);			casillaR[1] = new Casilla(220, 117);
		casillaA[2] = new Casilla(345, 419);			casillaR[2] = new Casilla(220, 145);
		casillaA[3] = new Casilla(345, 392);			casillaR[3] = new Casilla(220, 170);
		casillaA[4] = new Casilla(345, 365);			casillaR[4] = new Casilla(220, 200);
		casillaA[5] = new Casilla(375, 328);			casillaR[5] = new Casilla(210, 210);
		casillaA[6] = new Casilla(405, 328);			casillaR[6] = new Casilla(185, 210);
		casillaA[7] = new Casilla(430, 328);			casillaR[7] = new Casilla(155, 210);
		casillaA[8] = new Casilla(460, 328);			casillaR[8] = new Casilla(130, 210);
		casillaA[9] = new Casilla(488, 328);			casillaR[9] = new Casilla(100, 210);
		casillaA[10] = new Casilla(515, 328);			casillaR[10] = new Casilla(70, 210);
		casillaA[11] = new Casilla(545, 328);			casillaR[11] = new Casilla(45, 210);
		casillaA[12] = new Casilla(575, 328);			casillaR[12] = new Casilla(15, 210);
		casillaA[13] = new Casilla(575, 270);			casillaR[13] = new Casilla(15, 270);
		casillaA[14] = new Casilla(575, 200);			casillaR[14] = new Casilla(15, 325);
		casillaA[15] = new Casilla(545, 200);			casillaR[15] = new Casilla(45, 325);
		casillaA[16] = new Casilla(515, 200);			casillaR[16] = new Casilla(70, 325);
		casillaA[17] = new Casilla(488, 200);			casillaR[17] = new Casilla(100, 325);
		casillaA[18] = new Casilla(460, 200);			casillaR[18] = new Casilla(130, 325);
		casillaA[19] = new Casilla(430, 200);			casillaR[19] = new Casilla(155, 325);
		casillaA[20] = new Casilla(405, 200);			casillaR[20] = new Casilla(185, 325);
		casillaA[21] = new Casilla(380, 200);			casillaR[21] = new Casilla(210, 325);
		casillaA[22] = new Casilla(345, 200);			casillaR[22] = new Casilla(250, 364);
		casillaA[23] = new Casilla(375, 170);			casillaR[23] = new Casilla(250, 392);
		casillaA[24] = new Casilla(375, 145);			casillaR[24] = new Casilla(250, 419);
		casillaA[25] = new Casilla(375, 117);			casillaR[25] = new Casilla(250, 447);
		casillaA[26] = new Casilla(375, 90);			casillaR[26] = new Casilla(250, 475);
		casillaA[27] = new Casilla(375, 60);			casillaR[27] = new Casilla(250, 503);
		casillaA[28] = new Casilla(375, 35);			casillaR[28] = new Casilla(250, 533);
		casillaA[29] = new Casilla(375, 5);				casillaR[29] = new Casilla(250, 563);
		casillaA[30] = new Casilla(320, 5);				casillaR[30] = new Casilla(320, 563);
		casillaA[31] = new Casilla(230, 5);				casillaR[31] = new Casilla(375, 563);
		casillaA[32] = new Casilla(230, 35);			casillaR[32] = new Casilla(375, 533);
		casillaA[33] = new Casilla(230, 60);			casillaR[33] = new Casilla(375, 503);
		casillaA[34] = new Casilla(230, 90);			casillaR[34] = new Casilla(375, 475);
		casillaA[35] = new Casilla(250, 117);			casillaR[35] = new Casilla(375, 447);
		casillaA[36] = new Casilla(250, 145);			casillaR[36] = new Casilla(375, 419);
		casillaA[37] = new Casilla(250, 170);			casillaR[37] = new Casilla(375, 392);
		casillaA[38] = new Casilla(250, 200);			casillaR[38] = new Casilla(375, 365);
		casillaA[39] = new Casilla(210, 240);			casillaR[39] = new Casilla(375, 345);
		casillaA[40] = new Casilla(185, 240);			casillaR[40] = new Casilla(405, 360);
		casillaA[41] = new Casilla(155, 240);			casillaR[41] = new Casilla(430, 360);
		casillaA[42] = new Casilla(130, 240);			casillaR[42] = new Casilla(460, 360);
		casillaA[43] = new Casilla(100, 240);			casillaR[43] = new Casilla(488, 360);	
		casillaA[44] = new Casilla(70, 240);			casillaR[44] = new Casilla(515, 360);
		casillaA[45] = new Casilla(45, 240);			casillaR[45] = new Casilla(545, 360);
		casillaA[46] = new Casilla(15, 240);			casillaR[46] = new Casilla(575, 360);
		casillaA[47] = new Casilla(15, 300);			casillaR[47] = new Casilla(575, 305);
		casillaA[48] = new Casilla(15, 355);			casillaR[48] = new Casilla(575, 235);
		casillaA[49] = new Casilla(45, 355);			casillaR[49] = new Casilla(545, 235);
		casillaA[50] = new Casilla(70, 355);			casillaR[50] = new Casilla(515, 235);
		casillaA[51] = new Casilla(100, 355);			casillaR[51] = new Casilla(488, 235);
		casillaA[52] = new Casilla(130, 355);			casillaR[52] = new Casilla(460, 235);
		casillaA[53] = new Casilla(155, 355);			casillaR[53] = new Casilla(430, 235);
		casillaA[54] = new Casilla(185, 355);			casillaR[54] = new Casilla(405, 235);
		casillaA[55] = new Casilla(210, 355);			casillaR[55] = new Casilla(380, 235);
		casillaA[56] = new Casilla(230, 364);			casillaR[56] = new Casilla(360, 200);
		casillaA[57] = new Casilla(210, 392);			casillaR[57] = new Casilla(350, 170);
		casillaA[58] = new Casilla(210, 419);			casillaR[58] = new Casilla(350, 145);
		casillaA[59] = new Casilla(210, 447);			casillaR[59] = new Casilla(350, 117);
		casillaA[60] = new Casilla(210, 475);			casillaR[60] = new Casilla(350, 90);
		casillaA[61] = new Casilla(210, 503);			casillaR[61] = new Casilla(350, 60);
		casillaA[62] = new Casilla(210, 533);			casillaR[62] = new Casilla(350, 35);
		casillaA[63] = new Casilla(210, 563);			casillaR[63] = new Casilla(350, 5);	
		casillaA[64] = new Casilla(280, 563);			casillaR[64] = new Casilla(285, 5);
		casillaA[65] = new Casilla(280, 533);			casillaR[65] = new Casilla(285, 25);
		casillaA[66] = new Casilla(280, 503);			casillaR[66] = new Casilla(285, 55);
		casillaA[67] = new Casilla(280, 475);			casillaR[67] = new Casilla(285, 85);
		casillaA[68] = new Casilla(280, 447);			casillaR[68] = new Casilla(285, 115);
		casillaA[69] = new Casilla(280, 419);			casillaR[69] = new Casilla(285, 140);
		casillaA[70] = new Casilla(280, 392);			casillaR[70] = new Casilla(285, 170);
		casillaA[71] = new Casilla(280, 364);			casillaR[71] = new Casilla(285, 200);
		casillaA[72] = new Casilla(280, 335);			casillaR[72] = new Casilla(285, 235);
		
	
		
		
		amarillas[0] = new Ficha(442, 434, panel,"am1", imagenA);		
		amarillas[1] = new Ficha(540, 434, panel,"am2", imagenA);
		amarillas[2] = new Ficha(442 , 500, panel,"am3", imagenA);
		amarillas[3] = new Ficha(540 , 500, panel,"am4", imagenA);
		
		rojas[0] = new Ficha(150, 60, panel,"r1", imagenR);		
		rojas[1] = new Ficha(50, 60, panel,"r2", imagenR);
		rojas[2] = new Ficha(150 , 130, panel,"r3", imagenR);
		rojas[3] = new Ficha(50 , 130, panel,"r4", imagenR);

		

		JLabel resultdado = new JLabel("");
		resultdado.setHorizontalAlignment(SwingConstants.CENTER);
		resultdado.setBounds(157, 625, 46, 23);
		contentPane.add(resultdado);
		
		
		btn_dado = new JButton("Roll Dice");
		btn_dado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dado d1= new Dado();
				n= d1.tirarDado();
				String n1= String.valueOf(n);
				resultdado.setText(n1);
				
				btn_dado.setEnabled(false);
				
			}
		});
		
		btn_dado.setBounds(36, 625, 111, 23);
		contentPane.add(btn_dado);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		area_usr = new JTextArea();
		area_usr.setEnabled(false);
		area_usr.setEditable(false);
		area_usr.setLineWrap(true);
		area_usr.setBounds(633, 24, 263, 84);
		contentPane.add(area_usr);
		
		area_instruct = new JTextArea();
		area_instruct.setFont(new Font("Monospaced", Font.PLAIN, 16));
		area_instruct.setForeground(Color.MAGENTA);
		area_instruct.setEnabled(false);
		area_instruct.setLineWrap(true);
		area_instruct.setEditable(false);
		area_instruct.setBounds(633, 144, 263, 470);
		contentPane.add(area_instruct);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Game.class.getResource("/parchis.png")));
		lblNewLabel.setBounds(10, 11, 606, 592);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JOptionPane.showMessageDialog(null, "You have left the game, see you soon");
				
				leer.stop();
				Server.closeConnection();
				
			}
		});
		btnNewButton.setBounds(534, 625, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		MouseListener m1 = new MouseListener(){

				
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				if(arg0.getSource().equals(amarillas[0].getF1())) {
					amarillas[0].moverFicha(casillaA[anta1+n]);
					anta1=anta1+n;
					MoverTurno(0,anta1);

				}
				else if(arg0.getSource().equals(amarillas[1].getF1())) {
					amarillas[1].moverFicha(casillaA[anta2+n]);
					anta2=anta2+n;
					MoverTurno(1,anta2);
				}
				else if(arg0.getSource().equals(amarillas[2].getF1())) {
					amarillas[2].moverFicha(casillaA[anta3+n]);
					anta3=anta3+n;
					MoverTurno(2,anta3);
				}
				else if(arg0.getSource().equals(amarillas[3].getF1())) {
					amarillas[3].moverFicha(casillaA[anta4+n]);
					anta4=anta4+n;
					MoverTurno(3,anta4);
				}
				
				else if(arg0.getSource().equals(rojas[0].getF1())) {
					rojas[0].moverFicha(casillaR[antr1+n]);
					antr1=antr1+n;
					MoverTurno(0,antr1);
				}
				else if(arg0.getSource().equals(rojas[1].getF1())) {
					rojas[1].moverFicha(casillaR[antr2+n]);
					antr2=antr2+n;
					MoverTurno(1,antr2);
				}
				else if(arg0.getSource().equals(rojas[2].getF1())) {
					rojas[2].moverFicha(casillaR[antr3+n]);
					antr3=antr3+n;
					MoverTurno(2,antr3);
				}
				
				else if(arg0.getSource().equals(rojas[3].getF1())) {
					rojas[3].moverFicha(casillaR[antr4+n]);
					antr4=antr4+n;
					MoverTurno(3,antr4);
				}
				
				if(amarillas[0].getF1().getX()==280 && amarillas[0].getF1().getY()==335
				   && amarillas[1].getF1().getX()==280 && amarillas[1].getF1().getY()==335
				   && amarillas[2].getF1().getX()==280 && amarillas[2].getF1().getY()==335
				   && amarillas[3].getF1().getX()==280 && amarillas[3].getF1().getY()==335) {
							
							JOptionPane.showMessageDialog(contentPane, "YELLOW WINS!!!");

					}
				
				 if(rojas[0].getF1().getX()==285 && rojas[0].getF1().getY()==235
						   && rojas[1].getF1().getX()==285 && rojas[1].getF1().getY()==235
						   && rojas[2].getF1().getX()==285 && rojas[2].getF1().getY()==235
						   && rojas[3].getF1().getX()==285 && rojas[3].getF1().getY()==235) {
									
									JOptionPane.showMessageDialog(contentPane, "RED WINS!!!");

				}

			}
			
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}};
		
			amarillas[0].getF1().addMouseListener(m1);
			amarillas[1].getF1().addMouseListener(m1);
			amarillas[2].getF1().addMouseListener(m1);
			amarillas[3].getF1().addMouseListener(m1);
			rojas[0].getF1().addMouseListener(m1);
			rojas[1].getF1().addMouseListener(m1);
			rojas[2].getF1().addMouseListener(m1);
			rojas[3].getF1().addMouseListener(m1);
			

	}
	
	public void MoverTurno(int ficha, int casilla) {
		try {
			output.writeInt(ficha);
			output.writeInt(casilla);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pasarTurno(boolean t) {
		this.turno=t;
		if(!turno) {
			btn_dado.setEnabled(false);
		}
		
		else {
			btn_dado.setEnabled(true);
		}
	}
	
	
	public void SetWho(String who) {
		this.who = who;
		}
}

