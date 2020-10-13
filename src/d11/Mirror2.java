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
//direction means 0 going down, 1 going left, 2 going up, 3 going right
// /->3

public class Mirror2 {
	public static char[][] pasture;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
//		pasture = new char[R][C];
		pasture = new char[R][C];
		for (int r=0; r<R; r++){
			String line = br.readLine();
			for (int c=0; c<C; c++){
				pasture[r][c] = line.charAt(c);
			}
		}
		
		//horizontal
		int res = 1;
		for (int i=0; i<R; i++) {
			res = Math.max(res, sim(i,0,3));
			res = Math.max(res, sim(i,C-1,1));
		}

		//vert
		for (int i=0; i<C; i++) {
			res = Math.max(res, sim(0,i,0));
			res = Math.max(res, sim(R-1,i,2));
		}
		
		System.out.println(res);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static int sim(int r, int c, int d){
		int ct=0;
		
		while (r >= 0 && r < pasture.length && c >= 0 && c < pasture[0].length){
			// "\\" means \ 
			ct++;
            if (pasture[r][c] != '\\') {
                if (d == 0) {
                    c--;
                    d = 1;
                } else if (d == 1) {
                    r++;
                    d = 0;
                } else if (d == 2) {
                    c++;
                    d = 3;
                } else if (d == 3) {
                    r--;
                    d = 2;
                }
            } else {
                if (d == 0) {
                    c++;
                    d = 3;
                } else if (d == 1) {
                    r--;
                    d = 2;
                } else if (d == 2) {
                    c--;
                    d = 1;
                } else if (d == 3) {
                    r++;
                    d = 0;
                }
            }
		}
		return ct;
	}
}
