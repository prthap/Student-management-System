package services;

public class Student {
	private String studentName;
	private String usn;
	private int marks;
	private double phono;
	
	
	public Student(String studentName, String usn, int marks, double phono) {
		super();
		this.studentName = studentName;
		this.usn = usn;
		this.marks = marks;
		this.phono = phono;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getUsn() {
		return usn;
	}


	public void setUsn(String usn) {
		this.usn = usn;
	}


	public float getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public double getPhono() {
		return phono;
	}


	public void setPhono(double phono) {
		this.phono = phono;
	}
	
	
	
	
	
	

}
