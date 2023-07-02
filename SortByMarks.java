package sortingTechnics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.ConnectionManager;

public class SortByMarks {
	
	ConnectionManager connectionManager = new ConnectionManager();
	Connection connection = connectionManager.makeConnection();
	ResultSet resultSet;
	PreparedStatement preparedStatement;
	
	public void sortByMarks() throws SQLException{
		String query = "select * from student order by marks";
		preparedStatement = connection.prepareStatement(query);
		resultSet =  preparedStatement.executeQuery();
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("NAME\t| \tUSN\t|      MARKS \t| \tPHONE NUMBER\t| ");
		while(resultSet.next()){
			
			System.out.println(resultSet.getString(1)+"\t|\t"+resultSet.getString(2)+"\t|\t"
			+resultSet.getInt(3)+" \t|\t"+resultSet.getLong(4)+"\t|");
		}
		System.out.println("---------------------------------------------------------------------------");
		
	}

}
