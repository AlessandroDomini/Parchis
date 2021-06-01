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
    private final static int PORT = 5000;

    public static void main(String[] args) {
        
        try {
        	Scanner tec = new Scanner(System.in);
            //Server Socket to wait for network requests
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started");    
              
            //Client Socket
            Socket client;
            System.out.println("Server waiting for a client...");  
            client = server.accept();
            //setSoLinger closes the socket giving 10mS to receive the remaining data
            client.setSoLinger (true, 10);
            //an input reader to read from the socket
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //to print data out
            PrintStream output = new PrintStream(client.getOutputStream());
           
            
            
    
            
            //close connection
            client.close();
            server.close();
               
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
}
