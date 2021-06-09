package parchis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ficha {
	
	private double y;
	private double x;
	private String nombre;
	
	
	public Ficha(double x, double y, JLabel f1, String s) {
		this.x = x;
		this.y = y;
		f1.setIcon(new ImageIcon(Game.class.getResource(s)));
	}
	
	
	

}
