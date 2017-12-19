import java.util.Scanner;	
public class Calendar
{
	

	public static void main(String[] args) {
		
	// These are all of the variables
		int month = 0;
		int year = 0;
		int day = 0;
		int weekDayNum = 0;
		int i = 0;
		int j = 1;
		int date = 1;
		boolean startTabs = false;

		Scanner input = new Scanner ( System.in );
		System.out.println( "\n");
		System.out.print( "Enter Month's Number (example: 3 for March) ");
		month = input.nextInt();
		System.out.print( "Enter Year ");
		year = input.nextInt();
	
		System.out.println("\n");
	// This prints the entire calendar
		printMonthCalendar(month, year);
		System.out.println("\n");
		
	}

	

	public static void printMonthCalendar (int m, int y)
	{
	// This prints the header and body
		printMonthHeader(m, y);
		printMonthBody(m, y);	
		
	}

	public static void printMonthHeader(int m, int y)
	{
	// This prints the month name, year, day of the week names and the separater
		String MonthName = getMonthName(m);
		System.out.println("\t\t\t      " + MonthName + " " + y);
		System.out.println("\tSun\tMon\tTue\tWed\tThu\tFri\tSat ");
		System.out.println("\t----------------------------------------------------");
	}

	public static void printMonthBody(int m, int y)
	{
		
		int weekDayNum = 0;
		int j = 1;
		int day = 0;
		int i = 0;
		
	// The start day is always 1
		weekDayNum = getStartDay(m, 1, y);
		day = getNumDaysInMonth(m, y);
		if ((weekDayNum >= 1) && (weekDayNum < 7))
		{			
	// This is for the number of tabs to put before the first number
			for(j = 1; j <= weekDayNum; j++)
			{
				System.out.print("\t");	
			}
		}		
		
	// This is for all the days after the tabs
		for(i = weekDayNum; i < (day + weekDayNum); i++)
		{
			System.out.print("\t");
			System.out.printf("%d ", (i - weekDayNum + 1));
			
			if((i + 1) % 7 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();	
	}

	public static int getStartDay( int m, int d, int y )
  	{
    	// Adjust month number & year to fit Zeller's numbering system
    		if ( m < 3 ) 
    		{
     			 m = m + 12;
      			 y = y - 1;
    		}
    
   		int k = y % 100;      // Calculate year within century
    		int j = y / 100;      // Calculate century term
    		int h = 0;            // Day number of first day in month 'm'
    	
    		h = ( d + ( (13 * ( m + 1 )) / 5 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 * j ) ) % 7;
    
   	 // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
    		int dayNum = ( ( h + 5 ) % 7 ) + 1;     
    
    		return dayNum;
  	}

	public static int getNumDaysInMonth (int m, int y)
	{
		boolean isLpYr = false;
		int d = 0;
	
		isLpYr = isLeapYear(y);
		
		if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12)){
			d = 31; 
		} else if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
			d = 30;
		}
		if ((m == 2) && (isLpYr = true)) {
			d = 29;
		} else if ((m == 2) && (isLpYr = false)) {
			d = 28;
		}
	
		return d;
	}
	
	public static String getMonthName (int m)
	{
		String month = "";
		if (m == 1)
			return month = "January";
		else if (m == 2)
			return month = "February";
		else if (m == 3)  
			return month = "March";
		else if (m == 4)
			return month = "April";
		else if (m == 5)
			return month = "May";
		else if (m == 6)
			return month = "June";
		else if (m == 7)
			return month = "July";
		else if (m == 8)
			return month = "August";
		else if (m == 9)
			return month = "September";
		else if (m == 10)
			return month = "October";
		else if (m == 11)
			return month = "November";
		else if (m == 12)
			return month = "December";
		return month;
	}

	public static boolean isLeapYear(int y)
	{
		boolean isLpYr;

	// divisible by 4
		isLpYr = (y % 4 == 0);

        // divisible by 4 and not 100
       	 	isLpYr = isLpYr && (y % 100 != 0);

        // divisible by 4 and not 100 unless divisible by 400
        	isLpYr = isLpYr || (y % 400 == 0);

		return isLpYr;
	}
		
}

