/*
 * Mirror Field
============

Farmer John has left some old mirrors sitting outside his house, and his
cows, feeling mischievous as always, have stolen them!  

The cows have set up the mirrors in a rectangular field measuring N by M
squares (1 <= N, M <= 1,000).  In each square, they have placed a double
sided mirror between two of its opposite corners.  These two possible
configurations are represented by the '/' character (a mirror connecting
the lower-left corner to the upper-right corner) and the '\' character (a
mirror connecting the upper-left corner to the lower-right corner).

One evening, Bessie the cow brings a laser pointer out to the mirror field.
Standing outside the field, she shines the beam of light either
horizontally or vertically along either a row or column of the field,
causing it to bounce on mirrors. Since the mirrors are all diagonally
oriented, a horizontal beam of light that reflects off a mirror will end 
up traveling vertically, and vice versa. Bessie wonders what is the maximum
number of bounces on mirrors on which her beam of light can be reflected
at the same time. Given the layout of the mirror field, please help Bessie
compute this number.

PROBLEM NAME: mirror

INPUT FORMAT:

* Line 1: The integers N and M, separated by a space.

* Lines 2..1+N: Each line will contain M '/' or '\' characters,
        describing a row of the mirror field.

SAMPLE INPUT:

3 3
/\\
\\\
/\/

OUTPUT FORMAT:

* Line 1: A single integer indicating the maximum number of times a
        horizontal or vertical beam originating outside the mirror
        field could be reflected. Please output -1 if it could be
        reflected indefinitely.

SAMPLE OUTPUT:

3

OUTPUT DETAILS:

Bessie can shine the beam downwards above the middle column of her
field to have it reflected 3 times.
 */
package d11;

import java.io.*;
import java.util.*;

public class Mirror {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] pasture = new char[R][C];
		for (int r=0; r<R; r++){
			String line = br.readLine();
			for (int c=0; c<C; c++){
				pasture[r][c] = line.charAt(c);
			}
		}
		long startTime = System.nanoTime();
		
		//horizontal
		int res = 1;
		for (int i=0; i<R; i++) {
			res = Math.max(res, sim(pasture, i, -1, 0, 1));
			res = Math.max(res, sim(pasture, i, C, 0, -1));
		}

		//vert
		for (int i=0; i<C; i++) {
			res = Math.max(res, sim(pasture, -1, i, 1, 0));
			res = Math.max(res, sim(pasture, R, i, -1, 0));
		}
		
		System.out.println(res);
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static int sim(char[][] mat, int r, int c, int dx, int dy){
		int ct=0;
		
		while (true){
			ct++;
			r += dx;
			c += dy;
			
			if (r<0 || c<0 || r>=mat.length || c>=mat[0].length) break;
			
			int nDx = dy;
			int nDy = dx;
			
			if (mat[r][c] == '/') {
				nDx *= -1;
				nDy *= -1;
			}
			dx = nDx;
			dy = nDy;
		}
		return ct-1;
	}
}
