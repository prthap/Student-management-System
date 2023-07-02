package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	Connection con;
	Statement statement;
	public  Connection makeConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/studentProject","root","root");
			
			
		
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
}
