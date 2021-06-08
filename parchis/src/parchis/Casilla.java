package parchis;

public class Casilla {
	
	private double y;
	private double x;
	protected int tipo;
	private static final int ALTOHORIZONTAL;
	
	public Casilla(double x, double y, int tipo) {
		this.x = x;
		this.y = y;
		this.tipo=tipo;
	}

}
