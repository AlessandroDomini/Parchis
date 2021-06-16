package parchis;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server{

    /*We keep the port in a constant*/
    private final static int PORT = 5010;
    
   

    public static void main(String[] args) throws InterruptedException {
        
        try {
        	Scanner tec = new Scanner(System.in);
            //Server Socket to wait for network requests
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started");    
              
            //Client1 Socket
            Socket client1;
            System.out.println("Cliente 1");  
            client1 = server.accept();
            //setSoLinger closes the socket giving 10mS to receive the remaining data
            client1.setSoLinger (true, 10);
            //input del cliente 1
            DataInputStream input1 = new DataInputStream(client1.getInputStream());
            String nombre1 = input1.readLine();
            //output del cliente 1
            DataOutputStream output1 = new DataOutputStream(client1.getOutputStream());
            PrintStream outputC = new PrintStream(client1.getOutputStream());
            String amarillo = "amarillo";
            System.out.println(nombre1);
            
            
            //Client2 Socket
            Socket client2;
            System.out.println("Cliente 2");  
            client2 = server.accept();
            //setSoLinger closes the socket giving 10mS to receive the remaining data
            client2.setSoLinger (true, 10);
            //input del cliente 2
            DataInputStream input2 = new DataInputStream(client2.getInputStream());
            String nombre2 = input2.readLine();
            //output del cliente 2
            DataOutputStream output2 = new DataOutputStream(client2.getOutputStream());
            PrintStream outputC2 = new PrintStream(client2.getOutputStream());
            String rojo = "rojo";
            //Mandar nombres y colores
            //output1.writeUTF(nombre2);
            //output1.wait(1);
            outputC.println("amarillo");
            //output2.writeUTF(nombre1);
            //output2.wait(1);
            outputC2.println("rojo");


            // Threads
            TurnosServer T1 = new TurnosServer(input1, output2);
            TurnosServer T2 = new TurnosServer(input2, output1);
            T1.start();
            T2.start();
            
            System.out.println(nombre2);
            
            
            //close connection
            
               
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
}
