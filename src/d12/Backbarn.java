/*
 * Back to the Barn
================

As every cow does occasionally, Bessie has lost herself in the
woods! She desperately needs to get back to the barn but has no
idea where to go.

The woods can be thought of as an R x C grid (1 <= R <= 5; 1 <= C
<= 5). Bessie is located in the lower left corner at row 1, column
1; the barn is located in the upper right corner at in row R, column
C.  Each square in the grid is either empty (denoted by '.') or
blocked by a tree (denoted by 'T'). Bessie's square and the barn
will always be empty.

From a given square, Bessie may move to any adjacent square (one
that shares a long edge with Bessie's current square) as long as
it is empty. As Bessie is quite a smart cow, she never visits a
square twice on the way back to the barn.

Determine the number of different ways Bessie can take that lead
her from her initial position back to the barn while visiting at
most K different squares (1 <= K <= R * C).

By way of example, consider this forest:

        ....
        .T..
        ....

Bessie has a number of ways to get to the upper right corner, here
are all seven of them and their path lengths (the number of squares
visited):

         cdef  ...f  ..ef  ..gh  cdeh  cdej  ...f  
         bT..  .T.e  .Td.  .Tfe  bTfg  bTfi  .Tde  
         a...  abcd  abc.  abcd  a...  a.gh  abc.  

Length:    6     6     6     8     8    10    6

PROBLEM NAME: backbarn

INPUT FORMAT:

* Line 1: Three space-separated integers: R, C, and K

* Lines 2..R+1: Line i+1 contains the C characters representing row
        R+1-i of the forest (with no spaces)

SAMPLE INPUT:

3 4 6
....
.T..
....

INPUT DETAILS:

The forest is a 3 x 4 grid. A single tree sits almost in the middle,
as shown. No more than six steps can be taken.

OUTPUT FORMAT:

* Line 1: A single integer that is the number of different paths,
        visiting at most K squares, that Bessie can take to get back
        to the barn. Note that this number will always fit into a
        signed 32-bit integer.

SAMPLE OUTPUT:

4

OUTPUT DETAILS:

Of the several evenays to complete the traversal, only four of them touch
no more than six squares along the route.
 */
package d12;

import java.io.*;
import java.util.*;


public class Backbarn {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Global.R = Integer.parseInt(st.nextToken());
		Global.C = Integer.parseInt(st.nextToken());
		Global.K = Integer.parseInt(st.nextToken());
		
		char[][] forest = new char[Global.R][Global.C];
		for (int r=0; r<Global.R; r++){
			String line = br.readLine();
			for (int c=0; c<Global.C; c++){
				forest[r][c] = line.charAt(c);
			}
		}
		
		Global.used = new int[Global.R][Global.C];
		recur(forest,Global.R-1,1);
		
		System.out.println(Global.ct);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	private static void recur(char[][] forest, int r, int c) {
		if (Global.steps>Global.K){
			Global.steps--;
			return;
		}
		if (r==0 && c==Global.C-1){//reached end
			Global.ct++;
			Global.used[r][c]=0;
			Global.steps--;
			return;
		}
		//D,R,L,U
		int[] rDirections = {1, 0,-1, 0};
		int[] cDirections = {0, 1, 0,-1};
//		char[] eng = {'D','R','U','L'};
		
		Global.used[r][c] = 1;
		for (int i=0; i<4; i++){
			//out of range
			if (r+rDirections[i]<0 || r+rDirections[i]>forest.length-1 || c+cDirections[i]<0 || c+cDirections[i]>forest[0].length-1){
				 continue;
			}
			//do not go to past
			if (Global.used[r+rDirections[i]][c+cDirections[i]]==1){
				continue;
			}
			//no trees
			if (forest[r+rDirections[i]][c+cDirections[i]]=='T'){
				continue;
			}
			Global.steps++;
			recur(forest,r+rDirections[i], c+cDirections[i]);
		}
		Global.used[r][c] = 0;
		Global.steps--;
		return;
	}
	public static class Global{
		public static int R;
		public static int C;
		public static int K;
		public static int[][] used;
		public static int ct;
		public static int steps;
	}
}
