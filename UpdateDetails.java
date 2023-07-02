package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import backend.ConnectionManager;



public class UpdateDetails   {
	
	PreparedStatement preparedStatement = null;
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = connectionManager.makeConnection();
	
	Scanner sc = new Scanner(System.in);
	
	public void updateName(String usn){
		
		System.out.println("Enter new name");
		String name=sc.next();
		
		try {
			String query="update student set name=? where usn=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,usn);
			
			preparedStatement.execute();
			System.out.println("Updated Succefully...");
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateMarks(String usn){
		
		System.out.println("Enter new marks");
		int marks = sc.nextInt();
		String query = "update student set marks=? where usn=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, marks);
			preparedStatement.setString(2,usn);
			preparedStatement.execute();
			System.out.println("Updated marks succefully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void updatePhono(String usn){
		
		System.out.println("Enter new phone number");
		long phono = sc.nextLong();
		String query = "update student set phono=? where usn=?";
		
		try {
			preparedStatement =	connection.prepareStatement(query);
			preparedStatement.setLong(1,phono);
			preparedStatement.setString(2,usn);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
