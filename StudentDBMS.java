package services;

import java.sql.SQLException;

public interface StudentDBMS {
	void addStudent() throws SQLException;
	void displayStudent();
	void deleteStudent();
	void updateStudent();
	void sortStudent() throws SQLException;
	void displayAllStudentDetails();
	

}
