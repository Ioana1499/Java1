package com.assignment.mypackage;

import java.util.ArrayList;

public class Administration {

private ArrayList<Employee> employees;
    
	/**
	 * Constructor for the Administration class
	 * Initializes the variable employee to an empty ArrayList
	 */
    public Administration()
    {
        employees = new ArrayList<>();
    }
    
    /**
     * Adds an employee to the list
     * @param name String, the name of the employee
     * @param dob String, the date of birth in format ddmmyyyy
     * @param doj String, the date of joining the company in format ddmmyyyy
     * @param payroll String, a 4 digits number, with the first digit representing the number of the department
     */
    public void addEmployee(String name, String dob, String doj, String payroll)
    {
        employees.add(new Employee(name, dob, doj, payroll));
    }
    
    /**
     * Prints the employee list
     */
    public void printEmployeeList()
    {
        employees.stream()
            .forEach(employee -> employee.printDetails());
    }
    
    /**
     * Prints the total number of holiday days within the company
     */
    public void getTotalHolidayDays()
    {        
        int total = employees.stream().map(e -> e.holidayDays()).reduce(0, (sum, elem) -> sum + elem);
        System.out.println("The total number of holiday days is " + total);
    }
    
    /**
     * Calculates the highest age of an employee
     * @return The highest age
     */
    private long yearsOldestEmployee()
    {
        return employees.stream()
            .map(employee -> employee.getAge())
            .reduce(Integer::max).get();
    }
    
    /**
     * Prints the details of the employee with the highest age
     */
    public void printDetailsOldestEmployee()
    {
        System.out.println("Details of the company's oldest employee: ");
        long years = yearsOldestEmployee();
        employees.stream()
            .filter(employee -> employee.getAge() == years)
            .forEach(employee -> employee.printDetails());
    }
    
    /**
     * Prints the average number of service years
     */
    public void getAvgServiceYears()
    {
        float average =  employees.stream()
            .map(e->e.getServiceYears())
            .reduce(0, (total,years) -> total + years) / employees.size();
        System.out.println("The average number of service years is " + average);   
    }
    
    /**
     * Prints the details of a certain employee
     * @param name - The name of the employee
     */
    public void printDetailsEmployee(String name)
    {
    	boolean found = employees.stream().anyMatch(e -> e.getName().equals(name));
    	if(found == true)
    	{
    		employees.stream().filter(e -> e.getName().equals(name)).forEach(e -> System.out.println(e.toString()));
    	}
    	else
    	{
    		System.out.println("There is no employee with this name!");
    	}
    }
}
