package parchis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ficha {

	private final int SIZE = 46;
	private int y;
	private int x;
	private String nombre;
	private JLabel f1 = new JLabel("");

	public Ficha() {
	}

	public Ficha(int x, int y, JPanel p1, String nombre, String s) {
		this.x = x;
		this.y = y;
		this.nombre = nombre;
		f1.setBounds(x, y, SIZE, SIZE);
		f1.setIcon(new ImageIcon(Game.class.getResource(s)));
		p1.add(f1);

	}

	public void moverFicha(Casilla c) {

		try {

			f1.setBounds(c.getX(), c.getY(), SIZE, SIZE);

		} catch (NullPointerException e) {

			JOptionPane.showMessageDialog(null, "You have to roll the dice first <3");

		}

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public JLabel getF1() {
		return f1;
	}

	public void setF1(JLabel f1) {
		this.f1 = f1;
	}

}
