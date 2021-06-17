package parchis;

import java.io.DataInputStream;
import java.io.IOException;

public class TurnosGame extends Thread {

	DataInputStream input = null;
	Game G1;

	public TurnosGame(DataInputStream input, Game G1) {
		super();
		this.input = input;
		this.G1 = G1;

	}

	@Override
	public void run() {
		while (true) {
			try {
				int ficha = input.readInt();
				int casilla = input.readInt();
				if (this.G1.who.contains("Yellow")) {
					this.G1.amarillas[ficha].moverFicha(this.G1.casillaA[casilla]);
					this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "*************************** \n");
					this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "Yellow has moved the token "
							+ (ficha + 1) + " to the cell " + (casilla + 4) + " is YOUR TURN\n");
					this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "\n***************************");

				} else if (this.G1.who.contains("Red")) {
					this.G1.rojas[ficha].moverFicha(this.G1.casillaR[casilla]);
					this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "*************************** \n");
					this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "Red has moved the token "
							+ (ficha + 1) + "  to the cell " + (casilla + 38) + " is YOUR TURN\n");
					this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "\n***************************");

				}
				this.G1.pasarTurno(true);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
