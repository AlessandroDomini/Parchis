package parchis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ficha {
	
	private final int SIZE=46;
	private double y;
	private double x;
	private String nombre;
	protected String s="/Ficha_amarilla.png";
	private JLabel f1 = new JLabel("");
	
	public Ficha() {}
	
	public Ficha(int x, int y, JPanel p1) {
		this.x = x;
		this.y = y;
		f1.setBounds(x, y, SIZE, SIZE );
		f1.setIcon(new ImageIcon(Game.class.getResource(s)));
		p1.add(f1);

	}
	
	

	public void moverFicha(Casilla c) {
		
		f1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				f1.setBounds(c.getX(), c.getY(), SIZE, SIZE);	
				
			}
		});
		
		
	}
	

	public JLabel getF1() {
		return f1;
	}



	public void setF1(JLabel f1) {
		this.f1 = f1;
	}

}
