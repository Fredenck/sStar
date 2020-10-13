/*
 * Serious Cow Tag
===============

Farmer John's N (1 <= N <= 1000) cows (conveniently numbered 1..N)
are going to play a game of Serious Cow Tag. In Serious Cow Tag,
each cow chooses a grid point in the pasture (-7500 <= X <= 7500,
-7500 <= Y <= 7500) such that the distances between all pairs of
cows are unique.

The cows play in turn, starting with cow #1 and continuing with
cows #2, #3, and so on (as long as the cow is still in the game).
When it is a cow's turn to play, she finds the nearest cow still
playing, ambles over to that cow to tag her, and then returns to
her original location. As soon as a cow is tagged, she is out of
the game.

The game ends when only one cow remains, and she is declared the
winner.

Farmer John is taking bets with neighboring farmers as to which cow
will win, so he would like to know the winner in advance. Write a
program that will read a description of the cows' positions and
determine the winner.

PROBLEM NAME: cowtag

INPUT FORMAT:

* Line 1: A single integer N, the number of cows

* Lines 2..N+1: Line i+1 contains two space-separated integers that
        describe the location of cow i.

SAMPLE INPUT:

3
0 0
0 3
4 3

INPUT DETAILS:

Three cows at (0, 0), (0, 3) and (4, 3).

OUTPUT FORMAT:

* Line 1: The number of the winning cow.

SAMPLE OUTPUT:

3

OUTPUT DETAILS:

Cow 1 goes first and tags the nearest cow, cow 2. Cow 2 is eliminated
so she does not get a turn. Cow 3 then tags the only remaining cow,
cow 1.  She is the last cow left, so she wins.
 */
package d2;

import java.util.*;

public class Cowtag {
	//given solution
	public static int distSq(int x1, int y1, int x2, int y2){
		int xDifSq = (int) Math.pow((Math.abs(x2-x1)),2);
		int yDifSq = (int) Math.pow((Math.abs(y2-y1)),2);
		return xDifSq + yDifSq;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] xcoords = new int[n];
		int[] ycoords = new int[n];
		for (int i=0; i<n; i++){
			xcoords[i] = sc.nextInt();
			ycoords[i] = sc.nextInt();
		}
		
		int cur = 0;
		int[] dead = new int[n];
		for (int i=0; i<n-1; i++){
			int bDist = Integer.MAX_VALUE;
			int bCow = -1;
			//find next cow to tag dead
			for (int j=0; j<n; j++){
				if (j==cur || dead[j]!=0){//cow does not compare with self and dead
					continue;
				}
				int curToCowJ = distSq(xcoords[cur], ycoords[cur], xcoords[j], ycoords[j]);
				if (curToCowJ < bDist){
					bDist = curToCowJ;
					bCow = j;
				}
			}
			dead[bCow] = 1;
			do {
				cur++;//next cow is it
				if (cur>=n){//if next cow is last, it loops to first
					cur = 0;
				}
			}while (dead[cur] == 1);//if next cow is alive, stop do-while
		}
		for (int i=0; i<n; i++){//only one cow will be alive
			if (dead[i] == 0){
				System.out.println(i+1);//bc my idx started from 0
			}
		}
		sc.close();
	}

}
