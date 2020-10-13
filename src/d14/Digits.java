/*
 * Awkward Digits
==============

Bessie the cow is just learning how to convert numbers between different
bases, but she keeps making errors since she cannot easily hold a pen
between her two front hooves.

Whenever Bessie converts a number to a new base and writes down the result,
she always writes one of the digits wrong.  For example, if she converts
the number 14 into binary (i.e., base 2), the correct result should be
"1110", but she might instead write down "0110" or "1111".  Bessie never
accidentally adds or deletes digits, so she might write down a number with
a leading digit of "0" if this is the digit she gets wrong.

Given Bessie's output when converting a number N into base 2 and base 3,
please determine the correct original value of N (in base 10). You can
assume N is at most 1 billion, and that there is a unique solution for N.

Please feel welcome to consult any on-line reference you wish regarding
base-2 and base-3 numbers, if these concepts are new to you.

PROBLEM NAME: digits

INPUT FORMAT:

* Line 1: The base-2 representation of N, with one digit written
        incorrectly.

* Line 2: The base-3 representation of N, with one digit written
        incorrectly.

SAMPLE INPUT:

1010
212

INPUT DETAILS:

When Bessie incorrectly converts N into base 2, she writes down
"1010".  When she incorrectly converts N into base 3, she writes down "212".

OUTPUT FORMAT:

* Line 1: The correct value of N.

SAMPLE OUTPUT:

14

OUTPUT DETAILS:

The correct value of N is 14 ("1110" in base 2, "112" in base 3).
 */
package d14;

import java.io.*;
import java.util.*;

public class Digits {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b2 = br.readLine();
		String b3 = br.readLine();
		
		ArrayList<Integer> pos2B10 = new ArrayList<Integer>();
		ArrayList<Integer> pos3B10 = new ArrayList<Integer>();
		
		for (int i=0; i<b2.length(); i++){//digit positions
			for (int j=0; j<2; j++){//possible digits
				if (Character.getNumericValue(b2.charAt(i))==j){
					continue;
				}
				pos2B10.add(b2b10(b2.substring(0, i)+j+b2.substring(i+1)));
			}
		}
//		System.out.println(Arrays.toString(pos2B10.toArray()));
		for (int i=0; i<b3.length(); i++){//digit positions
			for (int j=0; j<3; j++){//possible digits
				if (Character.getNumericValue(b3.charAt(i))==j){
					continue;
				}
				pos3B10.add(b3b10(b3.substring(0, i)+j+b3.substring(i+1)));
			}
		}
//		System.out.println(Arrays.toString(pos3B10.toArray()));
		
		outerloop:
		for (int i:pos2B10){
			for (int j:pos3B10){
				if (i==j){
					System.out.println(i);
					break outerloop;
				}
			}
		}
		br.close();
	}
	public static int b2b10(String b2){
		return Integer.parseInt(b2, 2);
	}
	public static int b3b10(String b2){
		return Integer.parseInt(b2, 3);
	}
}
