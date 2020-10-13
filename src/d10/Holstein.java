/*
 * Healthy Holsteins
=================

Farmer John prides himself on having the healthiest dairy cows 
in the world. He knows the vitamin content for one scoop of 
each feed type and the minimum daily vitamin requirement for 
the cows. Help Farmer John feed his cows so they stay healthy 
while minimizing the number of scoops that a cow is fed.

Given the daily requirements of each kind of vitamin that a 
cow needs, identify the smallest combination of scoops of feed 
a cow can be fed in order to meet at least the minimum vitamin 
requirements.

Vitamins are measured in integer units. Cows can be fed at most 
one scoop of any feed type. It is guaranteed that a solution 
exists for all contest input data.

PROGRAM NAME: holstein

INPUT FORMAT:

* Line 1: integer V (1 <= V <= 25), the number of types of 
          vitamins

* Line 2: V integers (1 <= each one <= 1000), the minimum 
          requirement for each of the V vitamins that a cow 
          requires each day
          
* Line 3: integer G (1 <= G <= 15), the number of types of feeds 
          available
          
* Lines 4..G+3: V integers (0 <= each one <= 1000), the amount of 
          each vitamin that one scoop of this feed contains. The 
          first line of these G lines describes feed #1; the second 
          line describes feed #2; and so on.
          
SAMPLE INPUT:

4
100 200 300 400
3
50   50  50  50
200 300 200 300
900 150 389 399

OUTPUT FORMAT:

The output is a single line of output that contains:

* the minimum number of scoops a cow must eat, followed by:
* a SORTED list (from smallest to largest) of the feed types the 
cow is given 

If more than one set of feedtypes yield a minimum of scoops, 
choose the set with the smallest feedtype numbers.

SAMPLE OUTPUT:

2 1 3
 */
package d10;

import java.io.*;
import java.util.*;

public class Holstein {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] target = new int[V];
		for (int i=0; i<V; i++){
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		int G = Integer.parseInt(br.readLine());
		
		int[][] feeds = new int[G][V];
		for (int i=0; i<G; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<V; j++){
				feeds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] tot = new int[V];
		int scoops = G;
		int scoopIdx = (1<<G)-1;
		for (int i=1; i<(1<<G)+1; i++){
			tot = new int[V];
			boolean works = true;
			//go through all possible feeds
			for (int j=0; j<G; j++){
				if ((i&(1<<j))!=0){
					for (int k=0; k<feeds[j].length; k++){
						tot[k] += feeds[j][k];
					}
				}
			}
			//if this comb of feeds does not work
			for (int l=0; l<V; l++){
				if (tot[l]<target[l]){
					works = false;
					break;
				}
			}
			if (works){
				int ones = count1(Integer.toBinaryString(i));
				if (ones<scoops){
					scoopIdx = i;
					scoops = ones;
				}
			}
		}
		System.out.print(scoops);
		for (int i=0; i<G; i++){
			if (((1<<i)&scoopIdx) != 0){
				System.out.print(" "+(i+1));
			}
		}
		
		
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static int count1(String str) {
		int ones = 0;
		for (int i=0; i<str.length(); i++){
			if (str.charAt(i) == '1'){
				ones++;
			}
		}
		return ones;
	}
}
