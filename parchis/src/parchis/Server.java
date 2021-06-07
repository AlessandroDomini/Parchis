package parchis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server{

    /*We keep the port in a constant*/
    private final static int PORT = 5006;

    public static void main(String[] args) {
        
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
            BufferedReader input1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            String nombre1 = input1.readLine();
            //output del cliente 1
            PrintStream output1 = new PrintStream(client1.getOutputStream());
            
            System.out.println(nombre1);
            
            
            //Client2 Socket
            Socket client2;
            System.out.println("Cliente 2");  
            client2 = server.accept();
            //setSoLinger closes the socket giving 10mS to receive the remaining data
            client2.setSoLinger (true, 10);
            //input del cliente 2
            BufferedReader input2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
            String nombre2 = input2.readLine();
            //output del cliente 2
            PrintStream output2 = new PrintStream(client2.getOutputStream());
            
            System.out.println(nombre2);
            
            //Pasar nombres al otro jugador
            output1.println(nombre2);
            output2.println(nombre1);
            
            
    
            
            //close connection
            client1.close();
            client2.close();
            server.close();
               
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
}