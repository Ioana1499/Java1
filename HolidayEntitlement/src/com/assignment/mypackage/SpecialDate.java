package com.assignment.mypackage;

import java.time.*;
import java.text.*;
import java.util.Date;

public class SpecialDate {

	   private int day;
	   private int month;
	   private int year;
	   
	   /**
	    * Constructor for the class SpecialDate
	    * @param day - the day of birth
	    * @param month - the month of birth
	    * @param year - the year of birth
	    */
	   public SpecialDate(int day, int month, int year)
	   {
	       this.day = day;
	       this.month = month;
	       this.year = year;
	   }
	   
	   /**
	    * Constructor for the class SpecialDate
	    * @param date - the date of birth in ddmmyyyy format
	    */
	   public SpecialDate(String date)
	   {
		   this.day = getDay(date);
		   this.month = getMonth(date);
		   this.year = getYear(date);
	   }
	   
	   /**
	    * Formats a date to "<em>dd/mm/yyyy</em>"
	    */
	   public String toDateFormat()
	   {
	       //return date.substring(0,2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 8);
	       if(day >= 10 && month >= 10)
	       {
	           return day + "/" + month + "/" + year;
	       }
	       else
	       if(day >=10 && month < 10)
	       {
	           return day + "/0" + month + "/" + year; 
	       }
	       else
	       if(day< 10 && month >= 10)
	       {
	           return "0" + day + "/" + month + "/" + year;
	       }
	       else
	       {
	           return "0" + day + "/0" + month + "/" + year;
	       }
	   }
	   
	   /**
	    * Exctracts the day from the given string
	    * @param date - the day in the format <em>ddmmyyyy</em>
	    * @return The day of the month 
	    */
	   public int getDay(String date)
	   {
	       if(date.substring(0,1) == "0" )
	       {
	           return Integer.parseInt(date.substring(1,2));
	       }
	       else
	       {
	           return Integer.parseInt(date.substring(0,2));
	       }
	   }
	   
	   /**
	    * Extracts the month from the given string
	    * @param date - a date in the <em>ddmmyyyy</em> format
	    * @return the day of the month
	    */
	    public int getMonth(String date)
	   {
	       if(date.substring(2,3) == "0" )
	       {
	           return Integer.parseInt(date.substring(3,4));
	       }
	       else
	       {
	           return Integer.parseInt(date.substring(2,4));
	       }
	   }
	   
	    /**
	     * Extracts the year from the given string
	     * @param date - a date in the format <em>ddmmyyyy</em>
	     * @return The year
	     */
	    public int getYear(String date)
	   {
	       return Integer.parseInt(date.substring(4, 8));
	   }
	   
	    /**
	     * Return the difference in years between the given date object and the current date
	     * @return The difference in years between the given date object and the current date
	     */
	   public int getAge()
	   {
	        LocalDate birthDate = LocalDate.of(year, month, day);
	        LocalDate currentDate = LocalDate.of(2019, 2, 21);
	        return Period.between(birthDate, currentDate).getYears();
	   }
	   
	   /**
	     * Return the difference in years between the given date object and the current date
	     * @return The difference in years between the given date object and the current date
	     */
	   public int getServiceYears()
	   {
	        LocalDate joinDate = LocalDate.of(year, month, day);
	        LocalDate currentDate = LocalDate.of(2019, 2, 21);
	        return Period.between(joinDate, currentDate).getYears();
	   }
	   
	   /**
	    * Checks if a given date is a valid date
	    * @return true, if the date is valid or false if it isn't valid.
	    */
	   public boolean isValidDate()
	   {
	       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	       sdf.setLenient(false);
	       String date = toDateFormat();
	       try
	       {
	           Date newDate = sdf.parse(date);
	       }
	       catch (ParseException e)
	       {
	           return false;
	       }
	       return true;
	  }
}
