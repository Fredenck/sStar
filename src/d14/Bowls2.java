/*
 * The Water Bowls II
==================

This problem is the same as 'The Water Bowls' problem but this time
you need to implement it with Complete Search.

The cows have a line of 20 water bowls from which they drink. The bowls 
can be either right-side-up (properly oriented to serve refreshing cool 
water) or upside-down (a position which holds no water). They want all 
20 water bowls to be right-side-up and thus use their wide snouts to 
flip bowls.

Their snouts, though, are so wide that they flip not only one bowl but 
also the bowls on either side of that bowl (a total of three or -- in 
the case of either end bowl -- two bowls).

Given the initial state of the bowls (1=undrinkable, 0=drinkable -- it 
even looks like a bowl), what is the minimum number of bowl flips 
necessary to turn all the bowls right-side-up?

In this problem, you won't submit the entire code. Instead, you can
assume that the grading system has the code skeleton below and you
just need to fill inside the solve() function:

C++:                           Java:
-------------------------      ------------------
#include <iostream>            import java.util.*;
			       public class bowls2
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

PROBLEM NAME: bowls2

INPUT FORMAT:

Line 1: A single line with 20 space-separated integers

SAMPLE INPUT:

0 0 1 1 1 0 0 1 1 0 1 1 0 0 0 0 0 0 0 0

OUTPUT FORMAT:

Line 1: The minimum number of bowl flips necessary to flip all the bowls 
	right-side-up (i.e., to 0). For the inputs given, it will always 
	be possible to find some combination of flips that will manipulate 
	the bowls to 20 0's.

SAMPLE OUTPUT:

3

OUTPUT DETAILS:

Flip bowls 4, 9, and 11 to make them all drinkable:
0 0 1 1 1 0 0 1 1 0 1 1 0 0 0 0 0 0 0 0 [initial state]
0 0 0 0 0 0 0 1 1 0 1 1 0 0 0 0 0 0 0 0 [after flipping bowl 4]
0 0 0 0 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 [after flipping bowl 9]
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 [after flipping bowl 11]

 */
package d14;

import java.util.*;


public class Bowls2 {
	
	private static void solve(){
		Scanner sc = new Scanner(System.in);
		
	    int[] bowls = new int[20];
	    for (int i=0; i<20; i++){
	    	bowls[i] = sc.nextInt();
	    }
	    
		int minCt = 21;
		for (int i=0; i<(1<<20); i++){
			int ct = 0;
			int[] bowlsCopy = bowls.clone();
			for (int j=0; j<20; j++){
				if ((i&(1<<j)) != 0){
					//flip
					//start, flip cur and next
					if (20-j-1==0){
						if (bowlsCopy[20-j-1]==0){
							bowlsCopy[20-j-1]=1;
						}else{
							bowlsCopy[20-j-1]=0;
						}
						if (bowlsCopy[20-j]==0){
							bowlsCopy[20-j]=1;
						}else{
							bowlsCopy[20-j]=0;
						}//end flip cur and before
					}else if (20-j-1==19){
						if (bowlsCopy[20-j-1]==0){
							bowlsCopy[20-j-1]=1;
						}else{
							bowlsCopy[20-j-1]=0;
						}
						if (bowlsCopy[20-j-2]==0){
							bowlsCopy[20-j-2]=1;
						}else{
							bowlsCopy[20-j-2]=0;
						}
					}else{
						if (bowlsCopy[20-j-1]==0){
							bowlsCopy[20-j-1]=1;
						}else{
							bowlsCopy[20-j-1]=0;
						}
						if (bowlsCopy[20-j-2]==0){
							bowlsCopy[20-j-2]=1;
						}else{
							bowlsCopy[20-j-2]=0;
						}
						if (bowlsCopy[20-j]==0){
							bowlsCopy[20-j]=1;
						}else{
							bowlsCopy[20-j]=0;
						}						
					}
					ct++;
				}
			}
			int s=0;
			for (int k:bowlsCopy){
				s+=k;
			}
			if (ct<minCt && s==0){
				minCt = ct;
			}
		}
		System.out.println(minCt);
		sc.close();
	}
	public static void main(String[] args){
		solve();
	}

}
