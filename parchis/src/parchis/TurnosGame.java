package parchis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TurnosGame extends Thread {

	DataInputStream input = null;
	DataOutputStream output = null;
	Game G1;

	public TurnosGame(DataInputStream input, DataOutputStream output, Game G1) {
		super();
		this.input = input;
		this.output = output;
		this.G1 = G1;

	}

	@Override
	public void run() {
		try {

			while (true) {

				int ficha = input.readInt();
				if (ficha == -1) {
					output.writeInt(-1);
					break;
				}
				int casilla = input.readInt();
				if (this.G1.who.contains("Yellow")) {
					this.G1.amarillas[ficha].moverFicha(this.G1.casillaA[casilla]);
					
				} else if (this.G1.who.contains("Red")) {
					this.G1.rojas[ficha].moverFicha(this.G1.casillaR[casilla]);
					

				}
				this.G1.pasarTurno(true);
				
				this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "*************************** \n");
				this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "The other player has moved, is YOUR TURN\n");
				this.G1.area_instruct.setText(this.G1.area_instruct.getText() + "\n***************************");


			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
