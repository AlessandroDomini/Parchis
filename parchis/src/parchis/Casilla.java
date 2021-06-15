package parchis;

public class Casilla {
	
	private int y;
	private int x;
	protected int tipo;
	

	public Casilla(int x, int y) {
		this.x = x;
		this.y = y;
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

}
