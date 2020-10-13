/*
 * Look Up
=======

Farmer John's N (1 <= N <= 100,000) cows, conveniently numbered
1..N, are once again standing in a row. Cow i has height H_i (1 <=
H_i <= 1,000,000).

Each cow is looking to her left toward those with higher index
numbers. We say that cow i 'looks up' to cow j if i < j and H_i <
H_j. For each cow i, FJ would like to know the index of the first
cow in line looked up to by cow i.

Note: about 50% of the test data will have N <= 1,000.

PROBLEM NAME: lookup

INPUT FORMAT:

* Line 1: A single integer: N

* Lines 2..N+1: Line i+1 contains the single integer: H_i

SAMPLE INPUT:

6
3
2
6
1
1
2

INPUT DETAILS:

FJ has six cows of heights 3, 2, 6, 1, 1, and 2.

OUTPUT FORMAT:

* Lines 1..N: Line i contains a single integer representing the
        smallest index of a cow up to which cow i looks. If no such
        cow exists, print 0.

SAMPLE OUTPUT:

3
3
0
6
6
0

OUTPUT DETAILS:

Cows 1 and 2 both look up to cow 3; cows 4 and 5 both look up to cow 6; and
cows 3 and 6 do not look up to any cow.
 */
package d6;
//1 for-loop inside while 
//~20 lines
//stack
//
import java.io.*;
import java.util.*;

public class Lookup {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N];//stores cow heights
		int[] ans = new int[N];
		Stack<Integer> unused = new Stack<Integer>();
		
		for (int i=0; i<N; i++){
			int l = Integer.parseInt(br.readLine());
			cows[i] = l;
		}
		
		for (int i=0; i<N; i++){
			int cow = cows[i];
			while (!unused.isEmpty()){
				int top = unused.peek();
				if (cows[top] >= cow){
					break;
				}else{
					ans[top] = i+1;
					unused.pop();
				}
			}
			unused.push(i);
		}
		
		for (int i=0; i<ans.length; i++){
			System.out.println(ans[i]);
		}
		
//		System.out.println("Took "+(System.nanoTime() - startTime) + " ns");
		br.close();
	}
}