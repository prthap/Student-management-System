package services;

import java.util.Scanner;

public class Services {
	
	static Scanner  sc = new Scanner(System.in);
	public static int phoneNumberValidation(long number){
		long temp=number;
		int countNumber=0;
		while(temp>0){
			temp=temp/10;
			countNumber++;
		}
		//System.out.println("Count number"+c);
		return countNumber;
	}
	
	public static void  enterDetails(){
		
		System.out.print("Name : ");
		String studentName = sc.next();
		System.out.print("\nUSN : ");
		String usn = sc.next();
		System.out.print("\nMarks : ");
		int marks = sc.nextInt();
		System.out.print("\nPhone Number : ");
		long phono=sc.nextLong();
		long tempnumber = Services.phoneNumberValidation(phono);
		
	}

}
