/*
 * Why Did the Cow Cross the Road 
==============================

Farmer John's cows are trying to learn to cross the road effectively. 
Remembering the old "why did the chicken cross the road?" joke, they 
figure the chickens must be experts on crossing the road, and go off 
in search of chickens to help them.

As it turns out, chickens are very busy creatures and have limited 
time to help the cows. There are C chickens on the farm (1 <= C <=
20,000), conveniently numbered 1...C, and each chicken i is only 
willing to help a cow at precisely time T_i. The cows, never in a 
hurry, have more flexibility in their schedules. There are N cows 
on the farm (1 <= N <= 20,000), conveniently numbered 1...N, where 
cow j is able to cross the road between time A_j and time B_j. 
Figuring the "buddy system" is the best way to proceed, each cow j 
would ideally like to find a chicken i to help her cross the road; 
in order for their schedules to be compatible, i and j must satisfy 
A_j <= T_i <= B_j.

If each cow can be paired with at most one chicken and each chicken 
with at most one cow, please help compute the maximum number of 
cow-chicken pairs that can be constructed.

PROBLEM NAME: helpcross

INPUT FORMAT:

The first line of input contains C and N. The next C lines contain 
T_1...T_C, and the next N lines contain A_j and B_j (A_j <= B_j) for 
j=1...N. The A's, B's, and T's are all non-negative integers (not 
necessarily distinct) of size at most 1,000,000,000.

OUTPUT FORMAT:

Please compute the maximum possible number of cow-chicken pairs.

SAMPLE INPUT:

5 4
7
8
6
2
9
2 5
4 9
0 3
8 13

SAMPLE OUTPUT:

3
 */
package d7;

import java.io.*;
import java.util.*;

public class Helpcross {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File file = new File("helpcross.in");
		BufferedReader br = new BufferedReader(new FileReader(file));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		String[] cn = br.readLine().split(" ");
		int C = Integer.parseInt(cn[0]);
		int N = Integer.parseInt(cn[1]);
		
		ArrayList<Integer> chicks = new ArrayList<Integer>();
		for (int i=0; i<C; i++){
			chicks.add(Integer.parseInt(br.readLine()));
		}
		
		Cowtime[] cows = new Cowtime[N];
		for (int i=0; i<N; i++){
			String[] se = br.readLine().split(" ");
			int s = Integer.parseInt(se[0]);
			int e = Integer.parseInt(se[1]);
			cows[i] = new Cowtime(s,e);
		}
		
		Arrays.sort(cows, new Comparator<Cowtime>() {
		   	@Override  
			public int compare(Cowtime o1, Cowtime o2) {
			 //   if (o1.e + o2.s == o1.s + o2.e){
			 //       return o1.e - o2.e;
			 //   }
		   		return (o1.e-o1.s)-(o2.e-o2.s);
			 //   if (o1.e==o2.e){
			 //   	return o2.s-o1.s;
			 //   }
			 //   return o1.e-o2.e;
			}
		});
		
		Collections.sort(chicks);
		
		int ans = 0;
		for (int i=0; i<N; i++){
			int lb = lowerBound(chicks, 0, chicks.size(), cows[i].s);
			if ((lb<chicks.size()) && chicks.get(lb)<=cows[i].e){
//			if (lb!=chicks.size()-1 && chicks.get(lb)<=cows[i].e){
				ans++;
				chicks.remove(lb);
			}
		}
		
//		System.out.println(ans);
//		out.write(ans);
		out.println(ans);
		out.close();
// 		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static class Cowtime{
		int s, e;
		public Cowtime(int start, int end){
			s = start;
			e = end;
		}
	}
	public static int lowerBound(ArrayList<Integer> chicks, int low, int high, int element) {
	    while (low < high) {
	        int middle = low + (high - low) / 2;
	        if (element > chicks.get(middle)) {
	            low = middle + 1;
	        } else {
	            high = middle;
	        }
	    }
	    return low;
	}
}
