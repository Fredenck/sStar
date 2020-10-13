/*
 * The Eating Puzzle
=================

Bessie is on a diet where she can eat no more than C (10 <= C <= 35,000)
calories per day. Farmer John is teasing her by putting out B (1 <= B <= 21)
buckets of feed, each with some (potentially non-unique) number of calories
(range: 1..35,000). Bessie has no self-control: once she starts on a
feed bucket, she consumes all of it.

Bessie is not so good at combinatorics. Determine the optimal combination of
feed buckets that gives Bessie as many calories without exceeding the limit C.

As an example, consider a limit of 40 calories and 6 buckets with
7, 13, 17, 19, 29, and 31 calories. Bessie could eat 7 + 31 = 38 calories
but could eat even more by consuming three buckets: 7 + 13 + 19 = 39 calories.
She can find no better combination.

PROBLEM NAME: eatpuz

INPUT FORMAT:

* Line 1: Two space-separated integers: C and B

* Line 2: B space-separated integers that respectively name the number of calories
in bucket 1, 2, etc.

SAMPLE INPUT:

40 6
7 13 17 19 29 31

OUTPUT FORMAT:

* Line 1: A single line with a single integer that is largest number of calories
Bessie can consume and still stay on her diet.

SAMPLE OUTPUT:

39
 */
package d9;

import java.io.*;
import java.util.*;

public class Eatpuz {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int C = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] buckets = new int[B];
		for (int i=0; i<B; i++){
			buckets[i] = Integer.parseInt(st.nextToken());
		}
		

		int[] ans = new int[B];
		int[] used = new int[B];
		ArrayList<Integer> sumList = new ArrayList<Integer>();
		ArrayList<Integer> arr = Comb(0,B,C,ans,used,buckets,sumList);
		
		int max = Integer.MIN_VALUE;
		for (int i=0; i<arr.size(); i++){
			if (arr.get(i)>max){
				max = arr.get(i);
			}
		}
		System.out.println(max);

		
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static ArrayList<Integer> Comb(int e, int b, int c, int[] ans, int[] used, int[] numSetInt, ArrayList<Integer> sumList){
		if (e == b){
			int sum = 0;
			for (int i=0; i<b; i++){
				if (used[i]==1){
					sum += numSetInt[i];					
				}
			}
			if (sum<=c){
				sumList.add(sum);
			}
			return sumList;
		}		
	
		used[e] = 1;
		Comb(e+1, b, c, ans, used, numSetInt, sumList);
		used[e] = 0;
		Comb(e+1, b, c, ans, used, numSetInt, sumList);
		return sumList;
	}
}
