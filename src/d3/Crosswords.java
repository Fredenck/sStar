/*
 * Crosswords
==========

Like all cows, Bessie the cow likes to solve crossword puzzles.
Unfortunately, her sister Elsie has spilled milk all over her book of
crosswords, smearing the text and making it difficult for her to see
where each clue begins.  It's your job to help Bessie out and recover
the clue numbering!

An unlabeled crossword is given to you as an N by M grid (3 <= N <=
50, 3 <= M <= 50).  Some cells will be clear (typically colored white)
and some cells will be blocked (typically colored black). Given this
layout, clue numbering is a simple process which follows two logical
steps:

Step 1: We determine if a each cell begins a horizontal or vertical
clue.  If a cell begins a horizontal clue, it must be clear, its
neighboring cell to the left must be blocked or outside the crossword
grid, and the two cells on its right must be clear (that is, a
horizontal clue can only represent a word of 3 or more characters).
The rules for a cell beginning a vertical clue are analogous: the cell
above must be blocked or outside the grid, and the two cells below
must be clear.

Step 2: We assign a number to each cell that begins a clue.  Cells are
assigned numbers sequentially starting with 1 in the same order that
you would read a book; cells in the top row are assigned numbers from
left to right, then the second row, etc.  Only cells beginning a clue
are assigned numbers.

For example, consider the grid, where '.' indicates a clear cell and
'#' a blocked cell.

...
#..
...
..#
.##

Cells that can begin a horizontal or vertical clue are marked with !
below:

!!!
#..
!..
..#
.##

If we assign numbers to these cells, we get the following;

123
#..
4..
..#
.##

Note that crossword described in the input data may not satisfy
constraints typically seen in published crosswords.  For example, some
clear cells may not be part of any clue.

PROBLEM NAME: crosswords

INPUT:

The first line of input contains N and M separated by a space.

The next N lines of input each describe a row of the grid.  Each
contains M characters, which are either '.' (a clear cell) or '#' (a
blocked cell).

SAMPLE INPUT:

5 3
...
#..
...
..#
.##

OUTPUT:

On the first line of output, print the number of clues.

On the each remaining line, print the row and column giving the
position of a single clue (ordered as described above).  The top left
cell has position (1, 1).  The bottom right cell has position (N, M).

SAMPLE OUTPUT: 

4
1 1
1 2
1 3
3 1
 */
package d3;

import java.util.*;

public class Crosswords {
	
	public static boolean checkDown(char[][] mat, int r, int c){
		if ((mat[r][c]=='.') && (mat[r+1][c]=='.' && mat[r+2][c]=='.') && (mat[r-1][c]=='#')){
			return true;
		}
		return false;
	}
	
	public static boolean checkRight(char[][] mat, int r, int c){
		if ((mat[r][c]=='.') && (mat[r][c+1]=='.' && mat[r][c+2]=='.') && (mat[r][c-1]=='#')){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		char[][] crossword = new char[rows+4][cols+4];
		for (char[] row: crossword)
		    Arrays.fill(row, '#');
		for (int r=2; r<rows+2; r++){
			String row = sc.next();
			for (int c=2; c<cols+2; c++){
				crossword[r][c] = row.charAt(c-2);
			}
		}
//		System.out.println(Arrays.deepToString(crossword));
		
		int[] xStarts = new int[rows*cols];
		int[] yStarts = new int[rows*cols];
		int sCounter = 0;
		for (int r=2; r<rows+2; r++){
			for (int c=2; c<cols+2; c++){
				if (checkRight(crossword, r, c) || checkDown(crossword, r, c)){
					yStarts[sCounter] = r;
					xStarts[sCounter] = c;
					sCounter++;
				}
			}
		}
//		System.out.println(Arrays.toString(yStarts));
//		System.out.println(Arrays.toString(xStarts));
		int ct = 0;
		for (int i=0; i<xStarts.length; i++){
			if (xStarts[i]!=0){
				ct++;
			}
		}
		System.out.println(ct);
		for (int i=0; i<ct; i++){
			System.out.println((yStarts[i]-1) + " " + (xStarts[i]-1));
		}
		sc.close();
	}

}
