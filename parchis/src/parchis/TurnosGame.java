package parchis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TurnosGame extends Thread{
	
DataInputStream input = null;
Game G1;

public TurnosGame(DataInputStream input, Game G1) {
	super();
	this.input = input;
	this.G1 = G1;

}

@Override
public void run() {
	while(true) {
		try {
			int ficha = input.readInt();
			int casilla = input.readInt();
			if(this.G1.who.contains("Yellow")){
				this.G1.amarillas[ficha].moverFicha(this.G1.casillaA[casilla]);
				
				
			}else if(this.G1.who.contains("Red")) {
				this.G1.rojas[ficha].moverFicha(this.G1.casillaR[casilla]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
}
