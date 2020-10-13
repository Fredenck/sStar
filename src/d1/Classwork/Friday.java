/*
 * Friday the Thirteenth
=====================

Is Friday the 13th really an unusual event?

That is, does the 13th of the month land on a Friday less often than on 
any other day of the week? To answer this question, write a program that 
will compute the frequency that the 13th of each month lands on 
Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, and Saturday 
over a given period of N years. The time period to test will be from 
January 1, 1900 to December 31, 1900+N-1 for a given number of years, N. 
N is non-negative and will not exceed 400.

There are few facts you need to know before you can solve this problem:

    * January 1, 1900 was on a Monday.
    * Thirty days has September, April, June, and November, all the rest 
    have 31 except for February which has 28 except in leap years when it has 29.
    * Every year evenly divisible by 4 is a leap year 
    (1992 = 4*498 so 1992 will be a leap year, but the year 1990 is not a leap year)
    * The rule above does not hold for century years. Century years divisible 
    by 400 are leap years, all other are not. Thus, the century years 
    1700, 1800, 1900 and 2100 are not leap years, but 2000 is a leap year. 

Do not use any built-in date functions in your computer language.

Don't just precompute the answers, either, please.

PROGRAM NAME: friday

INPUT FORMAT:

One line with the integer N.

SAMPLE INPUT:

20

OUTPUT FORMAT:

Seven space separated integers on one line. These integers represent the number 
of times the 13th falls on Saturday, Sunday, Monday, Tuesday, ..., Friday.

SAMPLE OUTPUT:

36 33 34 33 35 35 34
 */
package d1.Classwork;

import java.util.*;

public class Friday {
	
	//checks if year is a leap year
	public static boolean isLeapyear(int year){
		if (year%400==0){
			return true;
		}else{
			if (year%4==0 && year%100!=0){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dayOcc = new int[7];//occurrences per each day (0->Saturday)
		int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

		int curDay = 0;
		dayOcc[curDay] += 1;//1900, 1/13 is a Saturday
		
		for (int i=0; i<N; i++){//years
			for (int j=0; j<12; j++){//months
				if (i==N-1 && j==11){//skip the last one because this counts the month after j
					break;
				}
				if (isLeapyear(1900+i)){
					daysPerMonth[1] = 29;
				}else{
					daysPerMonth[1] = 28;
				}
				curDay = (curDay + (daysPerMonth[j]%7))%7;//0(Sat) + 3(31%7)->3->Tuesday
//				System.out.println(Arrays.toString(dayOcc));
				dayOcc[curDay] ++;
			}
		}
		for (int c:dayOcc){
			System.out.print(c+ " ");
		}
		sc.close();
	}
}
