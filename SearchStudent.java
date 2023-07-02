package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import backend.ConnectionManager;

public class SearchStudent {
	
	
	PreparedStatement preparedStatement;
	ConnectionManager connectionManager = new ConnectionManager();
	ResultSet resultSet ;
	Connection connection = connectionManager.makeConnection();
	//Scanner sc = new Scanner(Syste)
	public String search(String usn){
		
		String query = "select * from student where usn=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,usn);
			resultSet = preparedStatement.executeQuery();
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("NAME\t| \t  USN\t\t|      MARKS \t| \tPHONE NUMBER\t| ");
			while(resultSet.next()){
				
				if(usn.equalsIgnoreCase(resultSet.getString(1))){
					
					System.out.println(resultSet.getString(1)+"\t|\t"+resultSet.getString(2)+"\t|\t"
					+resultSet.getInt(3)+" \t|\t"+resultSet.getLong(4)+"\t|");
					usn=null;
				}
			}
			System.out.println("---------------------------------------------------------------------------");
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usn!=null){
			System.out.println("Student id not found in search operation");
		}
		return usn;
		
	}
	
	public  void display() throws SQLException{
		String query = "select * from student";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.executeQuery();
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("NAME\t| \t  USN\t\t|      MARKS \t| \tPHONE NUMBER\t| ");
		while(resultSet.next()){
		
				System.out.println(resultSet.getString(1)+"\t|\t"+resultSet.getString(2)+"\t|\t"
				+resultSet.getInt(3)+" \t|\t"+resultSet.getLong(4)+"\t|");
				
			}
		System.out.println("---------------------------------------------------------------------------");
	}

}
