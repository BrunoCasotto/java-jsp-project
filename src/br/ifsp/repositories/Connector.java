package br.ifsp.repositories;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class Connector {
	String dbURL = "jdbc:mysql://localhost:3306/sampledb";
	String username = "root";
	String password = "secret";
	
	public Connector() {
		try {			 
			java.sql.Connection conn = DriverManager.getConnection(dbURL, username, password);
		    if (conn != null) {
		    	System.out.println("Connected");
		    }
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
