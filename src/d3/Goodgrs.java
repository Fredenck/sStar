/*
 * Good Grass
==========

Bessie believes that her favorite pasture has a patch of very special
grass that is the best grass on earth. She thinks it helps cows
produce more milk.

Each of the cows has returned to her assigned grazing spot, which
is at some point in a fully populated rectilinear grid. Consider
the example on the left below where the number of rows, NR (3 <=
NR <= 100) is 6 and the number of columns, NC (3 <= NC <= 100) is
5. The spots for cows are marked with a 'C'.

Bessie actually knows the milk production P_rc (1 <= P_rc <= 100)
of each of the cows in the grid; the cows are tagged with the
production number in the grid on the right, below.

               COLUMN                      COLUMN
           1  2  3  4  5               1  2  3  4  5
         +--------------             +--------------
        1| C  C  C  C  C            1| 5  6  7  4  6
     R  2| C  C  C  C  C         R  2| 7  7  8  6  5
     O  3| C  C  C  C  C         O  3| 9  9  8  3  5
     W  4| C  C  C  C  C         W  4| 8  8  7  6  4
        5| C  C  C  C  C            5| 4  5  2  4  5
        6| C  C  C  C  C            6| 3  4  2  3  4

Bessie wants to find the location of the special grass. She intends
to to do this by finding the 3 x 3 grid of cows whose total milk
production is the largest.

Find the 3 x 3 grid whose nine components sum to the greatest number
and report the value of its upper left corner (first the row, then
the column). In the grid above on the right, the largest sum is 71
found in the grid whose upper left corner (as depicted) is row 2,
column 1.

If two 3 x 3 grids have the same sum, output the one whose row
number is smallest. If more than one grid on that row has the same
sum, output the one with the lowest column number.

PROBLEM NAME: goodgrs

INPUT FORMAT:

* Line 1: Two space-separated integers: NR and NC

* Lines 2..NR+1: Line r+1 contains NC space-separated integers that
        represent row r of the pasture's grid.

SAMPLE INPUT:

6 5
5 6 7 4 6
7 7 8 6 5
9 9 8 3 5
8 8 7 6 4
4 5 2 4 5
3 4 2 3 4

OUTPUT FORMAT:

* Line 1: A single integer that is the greatest possible sum in a 3 x
        3 square.
* Line 2: Two space-separated integers that are respectively the row
        and column of the upper left corner of the 'best' 3 x 3 square
        grid.

SAMPLE OUTPUT:

71
2 1
 */
package d3;

import java.util.*;

public class Goodgrs {
	
	public static int surroundingMilk(int[][] mat, int r, int c){
//		int val = mat[r][c];
		//R,D,DR,L,DL,UL,U,UR
		int[] rDirections = {1, 0, 1,-1,-1, -1, 0, 1};
		int[] cDirections = {0, 1, 1, 0, 1, -1,-1,-1};
		
		int tot = mat[r][c];
		for (int i=0; i<8; i++){
			int adjVal = mat[r+rDirections[i]][c+cDirections[i]];
			tot += adjVal;
		}
		return tot;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		int[][] milks = new int[rows+2][cols+2];
		int[][] milkTots = new int[rows+2][cols+2];
		
		for (int r=1; r<rows+1; r++){
			for (int c=1; c<cols+1; c++){
				milks[r][c] = sc.nextInt();
			}
		}
		for (int r=1; r<rows+1; r++){
			for (int c=1; c<cols+1; c++){
				milkTots[r][c] = surroundingMilk(milks, r, c);
			}
		}
		//set current max as the top left, so no need to check it in the loop
		int maxMilk = milkTots[1][1];
		int maxR = 1;
		int maxC = 1;
		for (int r=2; r<rows-1; r++){//starts r-2, bc milkTots is surrounded by 0s
			for (int c=2; c<cols-1; c++){
				if (milkTots[r][c]>maxMilk){
					maxMilk = milkTots[r][c];
					maxR = r;
					maxC = c;
				}
			}
		}
		System.out.println(maxMilk);
		//because my mat is surrounded with 0s
		System.out.println((maxR-1) + " " + (maxC-1));
		sc.close();
	}

}
