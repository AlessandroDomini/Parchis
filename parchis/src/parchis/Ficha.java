package parchis;

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
	
	public Ficha(double x, double y, JPanel p1) {
		this.x = x;
		this.y = y;
		f1.setBounds(461, 438, SIZE, SIZE);
		f1.setIcon(new ImageIcon(Game.class.getResource(s)));
		p1.add(f1);

	}
	
	public void moverFicha() {
		
		f1.setBounds(364, 560, 46, 46);	
		
	}

}
