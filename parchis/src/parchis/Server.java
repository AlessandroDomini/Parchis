package parchis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	/* We keep the port in a constant */
	private final static int PORT = 5007;
	static ServerSocket server;
	static Socket client1;
	static Socket client2;
	static TurnosServer T1;
	static TurnosServer T2;

	public static void main(String[] args) throws InterruptedException {

		try {
			Scanner tec = new Scanner(System.in);
			// Server Socket to wait for network requests
			server = new ServerSocket(PORT);
			System.out.println("Server started");

			// Client1 Socket

			System.out.println("Cliente 1");
			client1 = server.accept();
			// setSoLinger closes the socket giving 10mS to receive the remaining data
			client1.setSoLinger(true, 10);
			// input del cliente 1
			DataInputStream input1 = new DataInputStream(client1.getInputStream());
			String nombre1 = input1.readLine();
			// output del cliente 1
			DataOutputStream output1 = new DataOutputStream(client1.getOutputStream());
			PrintStream outputC = new PrintStream(client1.getOutputStream());
			System.out.println(nombre1);

			// Client2 Socket
			System.out.println("Cliente 2");
			client2 = server.accept();
			// setSoLinger closes the socket giving 10mS to receive the remaining data
			client2.setSoLinger(true, 10);
			// input del cliente 2
			DataInputStream input2 = new DataInputStream(client2.getInputStream());
			String nombre2 = input2.readLine();
			// output del cliente 2
			DataOutputStream output2 = new DataOutputStream(client2.getOutputStream());
			PrintStream outputC2 = new PrintStream(client2.getOutputStream());
			// Mandar nombres y colores

			outputC.println("Your nick is " + nombre1 + " With Color red " + " and Player " + nombre2
					+ " with    color Yellow is online");
			outputC2.println("Your nick is " + nombre2 + " With Color  yellow " + " and Player " + nombre1
					+ " with color Red is online");

			// Threads
			T1 = new TurnosServer(input1, output2);
			T2 = new TurnosServer(input2, output1);
			T1.start();
			T2.start();

			System.out.println(nombre2);

			// close connection

		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void closeConnection() {
		try {
			client2.close();
			client1.close();
			server.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
