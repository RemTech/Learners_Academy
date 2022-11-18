package org.academy.object.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
  static {
	  
	  try {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  }
	  catch(ClassNotFoundException exc) {
		  exc.getMessage(); 
		}
	  }
 public static Connection getDBConnection(){
	 Connection con=null;
	 try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sb006","root","root12345");
       }
	 catch(SQLException sql) {
		sql.getMessage();
	}
	return con;
}
 
}
