/*
 * Cow Pals
========

Bessie and all the other cows have an RFID serial number tag in
their ear so FJ can mechanically tally them. Many cows have a
'cowpal' whose serial number is equal to the sum of the divisors
(that are not the number itself) of their own serial number. Some
cows don't have a cowpal because no cow's serial number matches
their divisor sum.

Some cows have a superpal. Cows are superpals when their serial
numbers make each of them a pal of the other. Cows that are superpals
of themselves are shunned; do not consider them!

Given a serial number S (6 <= S <= 18,000), find the first cow with
serial number at least S who has a super pal.

By way of example, consider serial number 220 whose divisors are 1, 2, 4,
5, 10, 11, 20, 22, 44, 55, and 110. Their sum is 284. Similarly, the
divisors of 284 are 1, 2, 4, 71, and 142. Their sum is 220.

PROBLEM NAME: cowpals

INPUT FORMAT:

* Line 1: A single integer: S

SAMPLE INPUT:

206

OUTPUT FORMAT:

* Line 1: A single line with two space-separated integers that are the
        serial number of the first superpal whose serial number is no
        smaller than S and the serial number of her pal.

SAMPLE OUTPUT:

220 284
 */
package d1.PlacementTest;

import java.util.*;

public class CowPals {
	public static int divisorsSum(int n){
		int sum = 0;
		for(int i=1; i<n; i++){
			if (n%i == 0){
//				if (n==220){
//					System.out.println(i);
//				}
				sum += i;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = Integer.valueOf(sc.nextLine());
		boolean flag = true;
		int c = s;
		int cpal = 0;
//		System.out.println(divisorsSum(496));
		while(flag){
			cpal = divisorsSum(c);
			if (c==divisorsSum(cpal) && c!=cpal){
				System.out.println(c + " " + cpal);
				flag = false;
			}
			c++;
		}
		sc.close();
		
		
		
		
	}

}
