package services;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
	
public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		StudentDBMSImplementation sms = new StudentDBMSImplementation();
		System.out.println(".....................WELCOME.......................\n");
		while(true){
			System.out.println("1.ADD STUDENT\n2.DISPLAY All STUDENT DETAILS\n3.DELETE STUDENT\n4.SORT STUDENT DETAILS\n5.Update Student Details\n6.DISPLAY STUDENT DETAILS \n7.EXIT\n ");
			int choice = sc.nextInt();
			switch (choice){
			
			case 1:
				
				sms.addStudent();
				break;
			case 2:
				sms.displayAllStudentDetails();
				break;
				
			case 3:
				sms.deleteStudent();
				break;
				
			case 4:
				sms.sortStudent();
				break;
				
			case 5:
				sms.updateStudent();
				break;
			case 6:
				sms.displayStudent();
				break;
			case 7:
				System.out.print("Execution Terminated");
				System.exit(0);
			default:
				System.out.println("Invalid choise");
				break;
			}
			
		}
		
	}


}
