package com.assignment.mypackage;

import java.util.Scanner;

public class TestAdministration {

	private static Administration administration = new Administration();
	
	public static void main(String[] args) {
		
		administration.addEmployee("John", "14091999", "13072015", "1001");
		administration.addEmployee("Mary", "02031989", "15062013", "2005");
		administration.addEmployee("Andrew", "05011986", "23042008", "1005");
		administration.addEmployee("Betty", "28081960", "01122010", "3034");
		administration.addEmployee("Lerry", "02031963", "13072001", "1002");
		
		welcomeMessage();
	}
	
	public static void welcomeMessage()
	{
		System.out.println("*************************LifeFood Administration System*************************");
		System.out.println();
		System.out.println("Please type in the number corresponding to the wanted command:");
		System.out.println("1: Add a new employee;");
		System.out.println("2: Print the employee list;");
		System.out.println("3: Print the details of a certain employee;");
		System.out.println("4: Show the total holiday days of the company's employees;");
		System.out.println("5: Show the details of the oldest employee;");
		System.out.println("6: Show the average service years;");
		System.out.println("7: Exit.");
		Scanner scan = new Scanner(System.in);
		action(scan.nextInt());
		scan.close();
	}
	
	public static void action(int i)
	{
		Scanner scan = new Scanner(System.in);
		switch(i)
		{
			case 1: 
			{
				System.out.println("The name of the employee:");
				String name = scan.next();
				System.out.println("The date of birth in \"ddmmyyyy\" format:");
				String dob = scan.next();
				System.out.println("The date of joining the company in \"ddmmyyyy\"  format:");
				String doj = scan.next();
				System.out.println("The payroll number:");
				administration.addEmployee(name, dob, doj, scan.next());
				scan.close();
				System.out.println(name + " was successfully added!");
				administration.printDetailsEmployee(name);
				break;
			}
			case 2:
			{
				System.out.println("A list with the company's employees:");
				administration.printEmployeeList();
				break;
			}
			case 3:
			{
				System.out.println("Introduce the name of the employee:");
				administration.printDetailsEmployee(scan.nextLine());
				scan.close();
				break;
			}
			case 4:
			{
				administration.getTotalHolidayDays();
				break;
			}
			case 5:
			{
				administration.printDetailsOldestEmployee();
				break;
			}
			case 6:
			{
				administration.getAvgServiceYears();
				break;
			}
			case 7:
			{
				System.out.println("Goodbye!");
				break;
			}
			default:
			{
				System.out.println("This is not a known command. Try again!");
				action(scan.nextInt());
				break;
			}
			
		}
	}

}
