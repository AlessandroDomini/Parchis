package parchis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

	public Connection connect;
	public Statement statement;
	public ResultSet rs;

	public void connectDataBase() {
		try {
			// This will load the MySQL driver, each DB has its own driver
		    Class.forName("com.mysql.cj.jdbc.Driver");
		      
		    // Setup the connection with the DB
		    String url="jdbc:mysql://localhost:3306/proyecto";
		  	String user="root";
		  	String password="";
		  	connect=DriverManager.getConnection(url,user,password); 
		     

		    // Statements allow to issue SQL queries to the database
		    statement = connect.createStatement();

		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
