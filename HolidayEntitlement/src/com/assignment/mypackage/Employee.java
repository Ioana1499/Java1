package com.assignment.mypackage;

public class Employee {

	private String name;
	   // In the format ddmmyyyy
	   private SpecialDate dateOfBirth;
	   private SpecialDate dateOfJoin;
	   private String payroll;
	   private int holidayDays;

	   /**
	    * Constructor for the Employee class
	    * @param name - The name of the employee
	    * @param dob - The date of birth of the employee in the "<em>ddmmyyyy</em>" format
	    * @param doj - The date of joining the company of the employee in the "<em>ddmmyyyy</em>" format
	    * @param payroll - A 4 digits number where the first digit represents the department number of the employee
	    */
	   public Employee(String name, String dob, String doj, String payroll)
	   {   
	       if(dob.length() > 8 || doj.length() > 8)
	       {
	           System.out.println("Invalid length of date input");
	       }
	       else
	       if(payroll.length() > 4)
	       {
	           System.out.println("Invalid length of payroll number");
	       }
	       else
	       {
	           this.name = name;
	           dateOfBirth = new SpecialDate(dob);
	           dateOfJoin = new SpecialDate(doj);
	           this.payroll = payroll;
	           holidayDays();
	           if(!dateOfBirth.isValidDate() || !dateOfJoin.isValidDate())
	           {
	               System.out.println("The birth date or join date is not valid! Please change it.");
	           }
	       }
	   }

	   /**
	    * Returns the name of the employee
	    * @return The name of the employee
	    */
	   public String getName()
	   {
	       return name;
	   }
	   
	   /**
	    * Returns the date of birth in "<em>ddmmyyyy</em>" format
	    * @return The date of birth
	    */
	   public String getDateOfBirth()
	   {
	       return dateOfBirth.toDateFormat();
	   }
	   
	   /**
	    * Returns the date of join in "<em>ddmmyyyy</em>" format
	    * @return The date of join 
	    */
	   public String getDateOfJoin()
	   {
	       return dateOfJoin.toDateFormat();
	   }
	   
	   /**
	    * Returns the payroll number
	    * @return The payroll number
	    */
	   public String getPayroll()
	   {
	       return payroll;
	   }
	   
	   /**
	    * Returns the department number
	    * @return The department number
	    */
	   public int getDepartment()
	   {
	       return Integer.parseInt(payroll.substring(0,1));
	   }
	   
	   /**
	    * Returns the age of an employee
	    * @return The age of the employee
	    */
	   public int getAge()
	   {
	       return dateOfBirth.getAge();
	   }
	   
	   /**
	    * Returns the number of service years of an employee
	    * @return The number of service years
	    */
	   public int getServiceYears()
	   {
	       return dateOfJoin.getServiceYears();
	   }
	   
	   /**
	    * Calculates the number of holiday days for an employee
	    * @return The number of holiday days
	    */
	   public int holidayDays()
	   {
	       if (getDepartment() == 1)
	       {
	           holidayDays = 24;
	       }
	       else
	       {
	           holidayDays = 20;
	       }
	       
	       if (dateOfBirth.getAge() >= 55)
	       {
	           holidayDays += 5;
	       }
	       
	       if(dateOfJoin.getServiceYears() >= 10)
	       {
	           holidayDays += 3;
	       }
	       
	       return holidayDays;
	   }
	   
	   /**
	    * Sets a new value for the date of birth
	    * @param newDateOfBirth - The new date of birth
	    */
	   public void changeDateOfBirth(String newDateOfBirth)
	   {
	       dateOfBirth = new SpecialDate(newDateOfBirth);
	   }
	   
	   /**
	    * Sets a new value for the date of join variable
	    * @param newDateOfJoin - The new date of join
	    */
	   public void changeDateOfJoin(String newDateOfJoin)
	   {
	       dateOfJoin = new SpecialDate(newDateOfJoin);
	   }
	   
	   /**
	    * Prints the details of the employee
	    */
	   public void printDetails()
	   {
		   System.out.println(toString());
	   }
	   
	   @Override
	   /**
	    * Overrides the toString() method of Object class
	    * @return A string with the details of the employee
	    */
	   public String toString()
	   {
		   return String.format("Name: %s, Joined on: %s, Department: %d, Payroll: %s, Total holiday days: %d, Service years: %d.", name, getDateOfJoin(), getDepartment(), payroll, holidayDays, getServiceYears());
	   }
}
