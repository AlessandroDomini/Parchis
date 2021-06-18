package parchis;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TurnosServer extends Thread {

	DataInputStream input = null;
	DataOutputStream output = null;

	public TurnosServer(DataInputStream input, DataOutputStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		while (true) {
			try {
				int n = input.readInt();
				if (n == -1) {
					break;
				}
				output.writeInt(n);
				System.out.println(n);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
