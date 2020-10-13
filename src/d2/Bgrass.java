/*
 * Best Grass
==========

Bessie is planning her day of munching tender spring grass and is gazing
out upon the pasture which Farmer John has so lovingly partitioned into a
grid with R (1 <= R <= 100) rows and C (1 <= C <= 100) columns. She wishes
to count the number of grass clumps in the pasture.

Each grass clump is shown on a map as either a single '#' symbol or perhaps
two '#' symbols side-by-side (but not on a diagonal). Given a map of the
pasture, tell Bessie how many grass clumps there are.

By way of example, consider this pasture map where R=5 and C=6:

.#....
..#...
..#..#
...##.
.#....

This pasture has a total of 5 clumps: one on the first row, one that spans
the second and third row in column 2, one by itself on the third row, one
that spans columns 4 and 5 in row 4, and one more in row 5.

PROBLEM NAME: bgrass

INPUT FORMAT:

* Line 1: Two space-separated integers: R and C

* Lines 2..R+1: Line i+1 describes row i of the field with C
        characters, each of which is a '#' or a '.'

SAMPLE INPUT:

5 6
.#....
..#...
..#..#
...##.
.#....

OUTPUT FORMAT:

* Line 1: A single integer that is the number of grass clumps Bessie
        can munch

SAMPLE OUTPUT:

5
 */
package d2;

import java.util.*;

public class Bgrass {
//also solution is to just check above and right if is #
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] pasture = new int[R][C];
		//rfeed[0] and cfeed[0] are the coords of the pasture where '#' is
		int[] rfeed = new int[R*C];
		int[] cfeed = new int[R*C];
		int p=0;
		int feeds = 0;
		
		for (int row=0; row<R; row++){
			String line = sc.next();
			for (int col=0; col<C; col++){
				char c = line.charAt(col);
				if (c == '.'){
					pasture[row][col] = 0;
				}else if (c == '#'){
					rfeed[p] = row;
					cfeed[p] = col;
					p++;
					pasture[row][col] = 1;
				}
			}
		}
		
		for (int i=0; i<p; i++){
//			System.out.print(rfeed[i]);
//			System.out.println(cfeed[i]);
			for (int j=0; j<p; j++){
				int rchange = Math.abs(rfeed[i]-rfeed[j]);
				int cchange = Math.abs(cfeed[i]-cfeed[j]);
				if (i==p-1){
				}
				if (rchange+cchange == 1){//next to each other, but not diagonal
					feeds++;
				}
				
			}
		}
		System.out.println(p-(feeds/2));
		sc.close();
		
	}

}
