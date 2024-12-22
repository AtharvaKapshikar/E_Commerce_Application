package com.group.j.main.files;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {

	private static final String DriverName = "oracle.jdbc.driver.OracleDriver";
	private static final String ConnURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String UserName = "system";
	private static final String Password = "system";
	
	public static Connection getConnection(){
		Connection con = null;
		
		try {
			
			Class.forName(DriverName);
			con= DriverManager.getConnection(ConnURL, UserName, Password);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		return con;
	}
}
