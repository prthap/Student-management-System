package services;

import java.sql.Connection;
import sortingTechnics.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import backend.*;
import sortingTechnics.SortByID;
public class StudentDBMSImplementation  implements StudentDBMS {

	ConnectionManager connectionManager = new ConnectionManager();
	Statement statement;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Connection connection = connectionManager.makeConnection();
	
	Scanner sc = new Scanner(System.in);
	
	
	
	@Override
	public  void addStudent() {
		 //TODO Auto-generated method stub
		
		//To enter student details
		Services.enterDetails();
		
//		Student student = new Student(studentName, usn, marks, phono);
		
		try {
			String query = "insert into student values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,usn);
			preparedStatement.setString(2,studentName);
			preparedStatement.setLong(3,marks);
			if(tempnumber<=10){
				preparedStatement.setDouble(4,phono);
			}
			else{
				System.out.println("Please eneter valid mobile number");
			}
			
		preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void displayAllStudentDetails() {
		// TODO Auto-generated method stub	
		try {
			String query = "select * from student";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("NAME\t| \tUSN\t|      MARKS \t| \tPHONE NUMBER\t| ");
			while(resultSet.next()){
				
				System.out.println(resultSet.getString(1)+"\t|\t"+resultSet.getString(2)+"\t|\t"
				+resultSet.getInt(3)+" \t|\t"+resultSet.getLong(4)+"\t|");
			}
			System.out.println("---------------------------------------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public  void displayStudent(){
		
		System.out.println("Enter student ID to display");
		String usn = sc.next().toUpperCase();
		
		try {
			String query = "select * from student where usn=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,usn);
			resultSet = preparedStatement.executeQuery();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("\tNAME\t| \t  USN\t\t|      MARKS \t| \tPHONE NUMBER\t| ");
			while(resultSet.next()){
				
				if(usn.equalsIgnoreCase(resultSet.getString(1))){
					System.out.println("\t"+resultSet.getString(1)+"\t|\t"+resultSet.getString(2)+"\t|\t"+resultSet.getInt(3)+" \t|\t"+resultSet.getLong(4)+"\t|");
					usn=null;
				}
			}
			System.out.println("---------------------------------------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(usn!=null){
			System.out.println("Student id not found");
		}
		
	}
	

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter student id to be delete");
		String deleteUsn = sc.next().toUpperCase();
		String query = "delete from student where usn=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,deleteUsn);
			preparedStatement.execute();
						
			System.out.println(" USN : "+deleteUsn+" Deleted  successfully.....");
			deleteUsn= null;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(deleteUsn!=null){
			System.out.println("Student id not found");
		}
	}


	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter student id to be update ");
		String updateUsn=sc.next();
		SearchStudent searchStudent = new SearchStudent();
		System.out.println(searchStudent.search(updateUsn));
		System.out.println("1.Update Name \n2.Update Marks\n3.Update Phone number\n4.Go Back");
		UpdateDetails updateDetails = new UpdateDetails();
		int choise=sc.nextInt();
		
		switch(choise){ 
		case 1:
			updateDetails.updateName( updateUsn);
			searchStudent.search(updateUsn);
			break;
		case 2:
			updateDetails.updateMarks(updateUsn);
			searchStudent.search(updateUsn);
			break;
		case 3:
			updateDetails.updatePhono(updateUsn);
			searchStudent.search(updateUsn);
			break;
		case 4:
			System.exit(0);
			System.out.close();
			default:System.out.println("Invalid choise");
			
		}
	}

	@Override
	public void sortStudent() throws SQLException{
		// TODO Auto-generated method stub
		
		System.out.println("1.Sort by USN\n2.Sort by Name\n3.Sort by Marks");
		int choise=sc.nextInt();
		
		switch(choise){ 
		case 1:
			 SortByID id = new SortByID();
			 id.sortByUsn();
			 
			break;
		case 2:
			SortByName name = new SortByName();
			 name.sortByName();
			break;
		case 3:
			SortByMarks marks = new SortByMarks();
			 marks.sortByMarks();
			break;
		case 4:
			System.exit(0);
			System.out.close();
			default:System.out.println("Invalid choise");
			
		}
		
	}

	
	
	
}
