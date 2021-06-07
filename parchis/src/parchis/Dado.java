package parchis;

import java.util.Random;

public class Dado {
	
	Random r=new Random();
	
	public Dado(){
		
	}
	
	public int tirarDado() {
		
		return r.nextInt(6)+1;
		
	}

}
