/*
 * Sets - N-Digit Permutations
===========================

You are given a set of numbers and a number N. Print all N-digit permutations 
that can be formed by the numbers in the given set. The numbers must be used 
in the order as in the given set. For the following input

The number set: 4 3 8 5
N: 3

The first four numbers must be

438
435
483
485

PROBLEM NAME: setperm

INPUT FORMAT:

* Line 1: A single integer: M

* Line 2: M space-seperated integers: number set

* Line 3: A single integer: N

SAMPLE INPUT:

4
4 3 8 5
3

OUTPUT FORMAT:

* Lines 1..?: An N-digit permitation generated by the numbers in the given set

SAMPLE OUTPUT:

438
435
483
485
453
458
348
345
384
385
354
358
843
845
834
835
854
853
543
548
534
538
584
583
 */
package d8;

import java.io.*;

public class Setperm {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		String[] numSet = br.readLine().split(" ");
		int N = Integer.parseInt(br.readLine());
		int[] numSetInt = new int[M];
		for (int i=0; i<M; i++){
			numSetInt[i] = Integer.parseInt(numSet[i]);
		}
		
		int[] used = new int[M];
		int[] ans = new int[N];
		Perm(0,N,M,used,numSetInt,ans);
		
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static void Perm(int cur, int n, int m, int[] used, int[] seq, int ans[]){
		if (cur == n){
			for (int i=0; i<ans.length; i++){
				System.out.print(ans[i]);				
			}
			System.out.println();
			return;
		}
		for (int i=0; i<m; i++){
			if (!(used[i]==1)){
				ans[cur] = seq[i];
				used[i] = 1;
				Perm(cur+1, n, m, used, seq, ans);
				used[i] = 0;
			}
		}
	}
}
