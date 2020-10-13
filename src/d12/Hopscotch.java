/*
 * Cow Hopscotch
=============

Just like humans enjoy playing the game of Hopscotch, Farmer John's 
cows have invented a variant of the game for themselves to play. 
Being played by clumsy animals weighing nearly a ton, Cow Hopscotch 
almost always ends in disaster, but this has surprisingly not 
deterred the cows from attempting to play nearly every afternoon.

The game is played on an R by C grid (2 <= R <= 15, 2 <= C <= 15), 
where each square is colored either red or blue. Cows start in the 
top-left square and move to the bottom-right square by a sequence 
of jumps, where a jump is valid if and only if

1) You are jumping to a square of a different color,

2) The square that you are jumping to is at least one row below the 
current square that you are on, and

3) The square that you are jumping to is at least one column to the 
right of the current square that you are on.

Please help the cows compute the number of different possible 
sequences of valid jumps that will take them from the top-left 
square to the bottom-right square.

PROBLEM NAME: hopscotch

INPUT FORMAT:

The first line contains the two integers R and C. The next R lines 
will each contain C characters. Each character is either 'R' or a 
'B', indicating a red square or a blue square.

OUTPUT FORMAT:

Output the number of different ways one can jump from the top-left 
square to the bottom-right square.

SAMPLE INPUT:

4 4
RRRR
RRBR
RBBR
RRRR

SAMPLE OUTPUT:

3
 */
package d12;

import java.io.*;
import java.util.*;

public class Hopscotch {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] hopPad = new char[R][C];
		for (int r=0; r<R; r++){
			String line = br.readLine();
			for (int c=0; c<C; c++){
				hopPad[r][c] = line.charAt(c);
			}
		}
		
		rec(hopPad,0,0,hopPad[0][0],0,0);
		
		System.out.println(Global.totCt);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static void rec(char[][] hopPad, int row, int col, char color, int ct, int totCt){
		if (row==hopPad.length-1 && col==hopPad[0].length-1){
			ct++;
			Global.totCt+=ct;
//			System.out.println(Global.totCt);
			return;
		}
		for (int r=row+1; r<hopPad.length; r++){
			for (int c=col+1; c<hopPad[0].length; c++){
				ct=0;
				if (hopPad[r][c] != color){
					rec(hopPad, r, c, hopPad[r][c], ct, totCt);
					Global.totCt+=ct;
				}
			}
		}
		if (row==0 && col==0){
			return;
		}
		return;
	}
	public static class Global{
		public static int totCt = 0;
	}
}
