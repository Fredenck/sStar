/*
 * Bookshelf 22
============

This problem is the same as 'Bookshelf 2' problem but this time
you need to implement it with Complete Search.

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

In this problem, you won't submit the entire code. Instead, you can
assume that the grading system has the code skeleton below and you
just need to fill inside the solve() function:

C++:                           Java:
-------------------------      ------------------
#include <iostream>            import java.util.*;
			       public class shelf22
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

PROBLEM NAME: shelf22

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
package d14;

import java.util.*;

public class Shelf22 {
	
	private static void solve(){
		Scanner sc = new Scanner(System.in);
//		StringTokenizer st = new StringTokenizer(br.readLine());
//	    int N = Integer.parseInt(st.nextToken());
//	    int B = Integer.parseInt(st.nextToken());
	    int N = sc.nextInt();
	    int B = sc.nextInt();
		
		
	    int[] cows = new int[N];
	    for (int i=0; i<N; i++){
//	    	cows[i] = Integer.parseInt(br.readLine());
	    	cows[i] = sc.nextInt();
	    }
	    
	    int minD = Integer.MAX_VALUE;
	    for (int i=1; i<(1<<N); i++){
	    	int sum = 0;
	    	for (int j=0; j<N; j++){
	    		if ((i&(1<<j)) != 0){
	    			sum += cows[N-j-1];
	    		}
	    	}
	    	if (sum>=B && (sum-B<minD)){
	    		minD = sum-B;
	    	}
	    }
	    System.out.println(minD);
	    sc.close();
	}
	public static void main(String[] args){
		solve();
	}

}
