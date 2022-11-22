package org.academy.object.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	static Connection con;
/*  static {
  
	  	  try {
	  Class.forName("com.mysql.jdbc.Driver");
	  }
	  catch(ClassNotFoundException exc) {
		  exc.getMessage(); 
		}
		
	  } */
 public static Connection getDBConnection() throws SQLException{
	 try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/academy","root","root12345");
		  }
		  catch(ClassNotFoundException exc) {
			  exc.getMessage(); 
			}
		 return con;
	}
	
}
 

