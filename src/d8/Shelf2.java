/*
 * Bookshelf 2
===========

Farmer John recently bought another bookshelf for the cow library,
but the shelf is getting filled up quite quickly, and now the only
available space is at the top.

FJ has N cows (1 <= N <= 20) each with some height of H_i (1 <= H_i
<= 1,000,000 - these are very tall cows). The bookshelf has a height
of B (1 <= B <= S, where S is the sum of the heights of all cows).

To reach the top of the bookshelf, one or more of the cows can stand
on top of each other in a stack, so that their total height is the
sum of each of their individual heights. This total height must be
no less than the height of the bookshelf in order for the cows to
reach the top.

Since a taller stack of cows than necessary can be dangerous, your
job is to find the set of cows that produces a stack of the smallest
height possible such that the stack can reach the bookshelf. Your
program should print the minimal 'excess' height between the optimal
stack of cows and the bookshelf.

PROBLEM NAME: shelf2

INPUT FORMAT:

* Line 1: Two space-separated integers: N and B

* Lines 2..N+1: Line i+1 contains a single integer: H_i

SAMPLE INPUT:

5 16
3
1
3
5
6

OUTPUT FORMAT:

* Line 1: A single integer representing the (non-negative) difference
        between the total height of the optimal set of cows and the
        height of the shelf.

SAMPLE OUTPUT:

1

OUTPUT DETAILS:

Here we use cows 1, 3, 4, and 5, for a total height of 3 + 3 + 5 + 6 = 17.
It is not possible to obtain a total height of 16, so the answer is 1.
 */
package d8;

import java.io.*;
import java.util.*;

public class Shelf2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nb = br.readLine().split(" ");
		int N = Integer.parseInt(nb[0]);
		int B = Integer.parseInt(nb[1]);
		
		int[] cows = new int[N];
		for (int i=0; i<N; i++){
			cows[i] = Integer.parseInt(br.readLine());
		}
		
		int[] ans = new int[N];
		int[] used = new int[N];
		ArrayList<Integer> sumList = new ArrayList<Integer>();
		ArrayList<Integer> arr = Comb(0,N,B,ans,used,cows,sumList);
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<arr.size(); i++){
			int dif = Math.abs(sumList.get(i)-B);
			if (dif<min){
				min = dif;
			}
		}
		System.out.println(min);

		
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static ArrayList<Integer> Comb(int e, int n, int b, int[] ans, int[] used, int[] numSetInt, ArrayList<Integer> sumList){
		if (e == n){
			int sum = 0;
			for (int i=0; i<n; i++){
				if (used[i]==1){
					sum += numSetInt[i];					
				}
			}
			if (sum>=b){
				sumList.add(sum);
			}
			return sumList;
		}		
	
		used[e] = 1;
		Comb(e+1, n, b, ans, used, numSetInt, sumList);
		used[e] = 0;
		Comb(e+1, n, b, ans, used, numSetInt, sumList);
		return sumList;
	}
}
