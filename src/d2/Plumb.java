/*
 * Plumbing the Pond
=================

Bessie's drinks water from a pond in the northwest part of the farm.
It has an interesting bottom in that it is full of little hills and
valleys. She wonders how deep it is.

She trolls across the pond in her little boat with a very old radar
set that tends to have spurious readings. She knows the deepest
part is relatively flat and has decided that she'll believe the
largest depth number only if it is verified by the fact that the
same depth appears in an adjacent reading.

The pond is modeled as an R x C (1 <= R <= 50; 1 <= C <= 50) grid
of (positive integer) depth readings D_rc (0 <= D_rc <= 1,000,000);
some readings might be 0 -- those are not part of the pond. A depth
reading of 10 means "depth of 10".

Find the greatest depth that appears in at least two 'adjacent'
readings (where 'adjacent' means in any of the potentially eight
squares that border a square on each of its sides and its diagonals).
She knows the pond has at least one pair of positive, adjacent
readings.

PROBLEM NAME: plumb

INPUT FORMAT:

* Line 1: Two space-separated integers: R and C

* Lines 2..R+1: Line i+1 contains C space-separated integers that
        represent the depth of the pond across row i: D_rc

SAMPLE INPUT:

4 3
0 1 0
1 2 0
1 5 1
2 3 4

INPUT DETAILS:

The pond has 4 rows, 3 columns.

OUTPUT FORMAT:

* Line 1: A single integer that is the depth of the pond determined by
        following Bessie's rules.

SAMPLE OUTPUT:

1

OUTPUT DETAILS:

Even though 5 is the deepest reading Bessie gets, and the number 2 occurs
twice, 1 is the largest number that occurs in two adjacent cells.
 */
package d2;

import java.util.*;

public class Plumb {
	public static boolean adj(int[][] mat, int r, int c){
		int val = mat[r][c];
		//R,U,UR,L,UL,DL,D,DR
		int[] rDirections = {1, 0, 1,-1,-1, -1, 0, 1};
		int[] cDirections = {0, 1, 1, 0, 1, -1,-1,-1};
		
		for (int i=0; i<8; i++){
			int adjVal = mat[r+rDirections[i]][c+cDirections[i]];
			if (val==adjVal){
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		//read in
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int[][] depths = new int[r+2][c+2];//surround read in matrix with 0s
		for (int row=1; row<r+1; row++){
			for (int col=1; col<c+1; col++){
				depths[row][col] = sc.nextInt();
			}
		}
//		System.out.println(Arrays.deepToString(depths));
		//
		int maxDeep = -1;
		for (int row=1; row<r+1; row++){
			for (int col=1; col<c+1; col++){
				//adj to same and deeper than maxDeep
				if (adj(depths, row, col) && depths[row][col]>maxDeep){
					maxDeep = depths[row][col];
				}
			}
		}
		System.out.println(maxDeep);
		sc.close();
	}

}
