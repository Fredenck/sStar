/*
 * Ruler
=====

You are asked to draw a special design ruler of a custom size N where 
N > 1. These are the rules for a size N ruler r_N:

      **..* (N times)
r_N = d_(N-1)
      **..* (N times)

      d_(N-1)
d_N = **..* (N times)
      d_(N-1)

d_1 = *

Here are some of the components of a size 5 ruler:

      ________ *****
     |         *
     |         **
     |         *
     |       _ ***
     |      |  *
     | d_2 <   **
     |      |_ *
d_4 <          **** ___
     |         *       |
     |         **      |
     |   d_1 < *       |
     |         ***      > d_3
     |         *       |
     |         **      |
     |________ *    ___|
               *****

PROBLEM NAME: ruler

INPUT FORMAT:

* Line 1: A single integer: N

SAMPLE INPUT:

5

SAMPLE OUTPUT:

*****
*
**
*
***
*
**
*
****
*
**
*
***
*
**
*
*****
 */
package d8;

import java.io.*;

public class Ruler {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++){
			System.out.print('*');
		}
		System.out.println();
		
		rule(N);
		
		for (int i=0; i<N; i++){
			System.out.print('*');
		}
		System.out.println();
		
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}

	private static void rule(int n) {
		if (n==1){
			return;
		}
		rule(n-1);
//		System.out.println();
		for (int i=0; i<n-1; i++){
			System.out.print('*');			
		}
		System.out.println();
		rule(n-1);
//		System.out.println();
	}
}
