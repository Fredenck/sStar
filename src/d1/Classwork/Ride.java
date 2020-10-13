/*
 * Your Ride Is Here
=================

It is a well-known fact that behind every good comet is a UFO. These 
UFOs often come to collect loyal supporters from here on Earth. 
Unfortunately, they only have room to pick up one group of followers 
on each trip. They do, however, let the groups know ahead of time 
which will be picked up for each comet by a clever scheme: they pick 
a name for the comet which, along with the name of the group, can be 
used to determine if it is a particular group's turn to go (who do you 
think names the comets?). The details of the matching scheme are given 
below; your job is to write a program which takes the names of a group 
and a comet and then determines whether the group should go with the 
UFO behind that comet.

Both the name of the group and the name of the comet are converted into 
a number in the following manner: the final number is just the product 
of all the letters in the name, where "A" is 1 and "Z" is 26. 
For instance, the group "USACO" would be 21 * 19 * 1 * 3 * 15 = 17955. 
If the group's number mod 47 is the same as the comet's number mod 47, 
then you need to tell the group to get ready! (Remember that "a mod b" 
is the remainder left over after dividing a by b; 34 mod 10 is 4.)

Write a program which reads in the name of the comet and the name of the 
group and figures out whether according to the above scheme the names are 
a match, printing "GO" if they match and "STAY" if not. The names of the 
groups and the comets will be a string of capital letters with no spaces 
or punctuation, up to 6 characters long.

Examples:

Input 		Output
------		------
COMETQ		GO
HVNGAT

------		------
ABSTAR		STAY
USACO 

PROGRAM NAME: ride

INPUT FORMAT:

* Line 1: An upper case character string of length 1..6 that is the name of the comet.
* Line 2: An upper case character string of length 1..6 that is the name of the group.

SAMPLE INPUT:

COMETQ
HVNGAT

OUTPUT FORMAT:

* Line 1: A single line containing either the word "GO" or the word "STAY".

SAMPLE OUTPUT:

GO
 */
package d1.Classwork;

import java.util.*;

public class Ride {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String comet = sc.nextLine();
		String group = sc.nextLine();
		
		int prod1 = 1;
		int prod2 = 1;
		for (int i=0; i<comet.length(); i++){
			char c1 = comet.charAt(i);
			prod1 *= (c1-64);
		}
		for (int i=0; i<group.length(); i++){
			char c2 = group.charAt(i);
			prod2 *= (c2-64);
		}
// 		System.out.println(prod1%47);
// 		System.out.println(prod2%47);
// 		System.out.println((prod1%47)==(prod2%47));
        if ((prod1%47)==(prod2%47)){
            System.out.println("GO");
        }else{
            System.out.println("STAY");
        }
        sc.close();
	}

}
