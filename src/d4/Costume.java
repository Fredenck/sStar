/*
 * Costume Party
=============

It's Halloween! Farmer John is taking the cows to a costume party,
but unfortunately he only has one costume. The costume fits precisely
two cows with a length of S (1 <= S <= 1,000,000). FJ has N cows
(2 <= N <= 100,000) conveniently numbered 1..N; cow i has length L_i
(1 <= L_i <= 1,000,000). Two cows can fit into the costume if the
sum of their lengths is no greater than the length of the costume.
FJ wants to know how many pairs of two distinct cows will fit into
the costume.

PROBLEM NAME: costume

INPUT FORMAT:

* Line 1: Two space-separated integers: N and S

* Lines 2..N+1: Line i+1 contains a single integer: L_i

SAMPLE INPUT:

4 6
3
5
2
1

OUTPUT FORMAT:

* Line 1: A single integer representing the number of pairs of cows FJ
        can choose. Note that the order of the two cows does not
        matter.

SAMPLE OUTPUT:

4

OUTPUT DETAILS:

The four pairs are as follows: cow 1 and cow 3; cow 1 and cow 4; cow 2 and
cow 4; and finally cow 3 and cow 4.
 */
package d4;

import java.util.*;

public class Costume {
	public static int upper_bound(int[] a, int low, int high, int element) {
	    while (low < high) {
	        int middle = low + (high - low) / 2;
	        if (a[middle] > element) {
	            high = middle;
	        } else {
	            low = middle + 1;
	        }
	    }
	    return low;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] cows = new int[N];
		
		for (int i=0; i<N; i++){
			int len = sc.nextInt();
			cows[i] = len;
		}
		int ct = 0;
		Arrays.sort(cows);
		for (int i=0; cows[i]<=(S/2); i++){
//			System.out.print(ct);
			ct += upper_bound(cows, 0, N, S-cows[i])-i-1;
//			System.out.println(ct);
		}
		System.out.println(Math.abs(ct));
		sc.close();
	}
}