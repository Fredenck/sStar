/*
 * Bessie's Secret Pasture
=======================

Farmer John has cut an almost unlimited number of square pieces of
sod (grass sections) of all integer side-lengths from the pasture
(sometimes FJ doesn't engage the blade properly and even makes a
0-sided sod squares). He has placed them in nicely organized piles
that Bessie spotted one afternoon.

Bessie, always hoping to put delicious grass in her secret pasture,
decided to carry precisely four of these sod sections over to her
pasture and carve them into 1x1 sections in order to tile its N (1
<= N <= 10,000) unit-square sections.

Bessie is interested in knowing how many different ways she can
choose four sod sections to tile her secret pasture. If she had a
pasture of size 4, she might haul sod squares in these five different
ways: (1,1,1,1), (2,0,0,0), (0,2,0,0), (0,0,2,0), (0,0,0,2).  Order
counts: (4,3,2,1) is a different way of choosing than (1,2,3,4).

PROBLEM NAME: secpas

INPUT FORMAT:

* Line 1: A single integer: N

SAMPLE INPUT:

4

OUTPUT FORMAT:

* Line 1: A single integer that is the number of different ways Bessie
        can choose four sod sections for her pasture

SAMPLE OUTPUT:

5
 */
package d2;

import java.util.*;

public class Secpas {
    //3 for-loops, (10^2)^3 = 10^6
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ct = 0;
		for (int a=0; a<=Math.sqrt(n); a++){
			for (int b=0; b<=Math.sqrt(n); b++){
				for (int c=0; c<=Math.sqrt(n); c++){
					//d = sqrt(N-a^2-b^2-c^2)
					//since you want a^2+b^2+c^2+d^2 = n
					double d = Math.sqrt(n-a*a-b*b-c*c);
					if (d == (int) d)
					{
					   ct++;// Number is integer
						
					}
				}
			}
		}
		System.out.println(ct);
		sc.close();
	}
/* 4 for-loops (10^2)^4 = 10^8
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ct = 0;
		for (int i=0; i<=Math.sqrt(n); i++){
			for (int j=0; j<=Math.sqrt(n); j++){
				for (int k=0; k<=Math.sqrt(n); k++){
					for (int l=0; l<=Math.sqrt(n); l++){
						if (i*i+j*j+k*k+l*l==n){
//							System.out.println(i);
//							System.out.println(j);
//							System.out.println(k);
//							System.out.println(l);
							ct++;
						}
					}
				}
			}
		}
		System.out.println(ct);

	}*/

}
