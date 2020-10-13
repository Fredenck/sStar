/*
 * Secret Cow Code
===============

The cows are experimenting with secret codes, and have devised a 
method for creating an infinite-length string to be used as part of 
one of their codes.

Given a string s, let F(s) be s followed by s "rotated" one character 
to the right (in a right rotation, the last character of s rotates 
around and becomes the new first character). Given an initial string 
s, the cows build their infinite-length code string by repeatedly 
applying F; each step therefore doubles the length of the current 
string.

Given the initial string and an index N, please help the cows compute 
the character at the N th position within the infinite code string.

PROBLEM NAME: cowcode

INPUT FORMAT:

The input consists of a single line containing a string followed by 
N. The string consists of at most 30 uppercase characters, and N <= 
10^18.

Note that N may be too large to fit into a standard 32-bit integer, 
so you may want to use a 64-bit integer type (e.g., a "long long" in 
C/C++).

OUTPUT FORMAT:

Please output the N th character of the infinite code built from the 
initial string. The first character is N=1.

SAMPLE INPUT:

COW 8

SAMPLE OUTPUT:

C

In this example, the initial string COW expands as follows:

COW -> COWWCO -> COWWCOOCOWWC
                 12345678

Problem credits: Brian Dean 
 */
package d5;

import java.util.*;


public class Cowcode {
	public static long hLen(String s, long n){
		long a=s.length();
		while (a*2<n){
			a = a * 2;//each time str is doubled
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		long n = sc.nextLong();
		
		long l = hLen(str, n);
		/*
		 * 1    2    3 ... l-1   l
		 *   \	  \         \
		 * 	   \    \        \
		 * 	     \    \       \
		 * l+1  l+2  l+3 ...  2l
		 */
		
		while (str.length() < n){
			if (n == l+1){
				n = 1;//first of second half maps to last of first half
			}else{
				n -= l+1;//others of second half maps to first half pos-1
			}
			while (l >= n){
				l /= 2;//for next time
			}
		}
		
		System.out.println(str.charAt((int) (n-1)));
		sc.close();
	}
}
