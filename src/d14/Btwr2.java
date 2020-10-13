/*
 * The Bale Tower II
=================

This problem is the same as 'The Bale Tower' problem but this time
you need to implement it with Complete Search.

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

C++:                           Java:
-------------------------      ------------------
#include <iostream>            import java.util.*;
#include <algorithm>
			       public class btwr2
using namespace std;           {
                                   private static void solve()
void solve()                       {
{				       // JUST WRITE THIS CODE
    // JUST WRITE THIS CODE        }
}
                                   public static void main(String[] args)
int main()                         {
{                                      solve();
    solve();                       }
}			       }
-------------------------------------------------------------------------

PROBLEM NAME: btwr2

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
package d14;

import java.util.*;


public class Btwr2 {
	
	private static void solve(){
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();		
		
	    int[][] haybales = new int[N][2];
	    for (int i=0; i<N; i++){
	    	haybales[i][0] = sc.nextInt();
	    	haybales[i][1] = sc.nextInt();
	    }
	    
		Arrays.sort(haybales, new Comparator<int[]>() {
		   	@Override  
			public int compare(int[] o1, int[] o2) {
		   		if (o1[0]==o2[0]){
		   			return o1[1]-o2[1];
		   		}
			    return o1[0]-o2[0];
			}
		});	
	    
		int sum = 0;
		int ans = 0;
		for (int i=0; i<(1<<N); i++){
			sum = 0;
			int prev = -1;
			for (int j=0; j<N; j++){
				if ((i&(1<<j)) != 0){
					if (haybales[j][1]>=prev){
						prev = haybales[j][1];
						sum++;
					}else{
						break;
					}
				}
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
		sc.close();
	}
	public static void main(String[] args){
		solve();
	}

}
