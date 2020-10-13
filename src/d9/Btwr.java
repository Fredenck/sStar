/*
 * The Bale Tower
==============

Always bored with cud-chewing, the cows have invented a new game.
One cow retrieves a set of N (3 <= N <= 20) hay bales from the shed
each of which is one unit high. Each bale also has some unique width
and unique breadth.

A second cow tries to choose a set of bales to make the tallest
stack of bales in which each bale can be placed only on a bale whose
own width and breadth are smaller than the width and breadth of the
bale below. Bales can not be rotated to interchange the width and
breadth.

Help the cows determine the highest achievable tower that can be
legally built form a set of bales.

PROBLEM NAME: btwr

INPUT FORMAT:

* Line 1: A single integer, N

* Lines 2..N+1: Each line describes a bale with two space-separated
        integers,respectively the width and breadth

SAMPLE INPUT:

6
6 9
10 12
9 11
8 10
7 8
5 3


INPUT DETAILS:

Six bales of various widths and breadths

OUTPUT FORMAT:

* Line 1: The height of the tallest possible tower that can legally be
        built from the bales.

SAMPLE OUTPUT:

5

OUTPUT DETAILS:

These bales can be stacked for a total height of 5:
10 12
9 11
8 10
6 9
5 3
[another stacking exists, too]
 */
package d9;

import java.io.*;
import java.util.*;

public class Btwr {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Haybale[] haybales = new Haybale[N];
		for (int i=0; i<N; i++){
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			haybales[i] = new Haybale(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(haybales, new Comparator<Haybale>() {
		   	@Override  
			public int compare(Haybale o1, Haybale o2) {
		   		if (o1.w==o2.w){
		   			return o1.b-o2.b;
		   		}
			    return o1.w-o2.w;
			}
		});		
		System.out.println(countHeight(N, haybales));
		
		
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static class Haybale{
		int w;
		int b;
		public Haybale(int width, int breadth){
			w = width;
			b = breadth;
		}
	}
	public static int countHeight(int N, Haybale[] haybales){
		int sum = 0;
		int ans = 0;
		
		for (int i=0; i<(1<<N); i++){
			sum = 0;
			int prev = -1;
			for (int j=0; j<N; j++){
				if ((i&(1<<j)) != 0){
					if (haybales[j].b>=prev){
						prev = haybales[j].b;
						sum++;
					}else{
						break;
					}
				}
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}
	
}
