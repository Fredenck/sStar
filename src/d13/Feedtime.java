/*
 * Feeding Time
============

It's Bessie's feeding time, and Farmer John is trying to decide
where to put her. FJ has a farm that comprises W x H (1 <= W <=
750; 1 <= H <= 750) squares and is partitioned into one or more
separate pastures by rocks both large and small. Every pasture
contains some grass and some rocks.

Bessie is a hungry little cow and just loves to eat, eat, eat her
grass. She can move from any square to any other square that is
horizontally, vertically, or diagonally adjacent. Bessie can't cross
the rocks because they hurt her feet, and, of course, she can't
leave the farm. Bessie wants to know the maximum number of squares
of grass that she can eat.

FJ has a map of his farm, where a '.' represents a square of grass,
and a '*' represents a rock. Consider this 10x8 map and a detailed
breakdown of the extent of each of its three pastures:

      ...*....**  |  111*....**   ...*2222**    ...*....**
      ..**....**  |  11**....**   ..**2222**    ..**....**
      ...*....**  |  111*....**   ...*2222**    ...*....**
      ...**.*.**  |  111**.*.**   ...**2*2**    ...**.*.**
      ***.**.***  |  ***1**.***   ***.**2***    ***.**.***
      ...**.*.**  |  111**.*.**   ...**2*2**    ...**.*.**
      ...*.*****  |  111*.*****   ...*2*****    ...*.*****
      ...***..**  |  111***..**   ...***..**    ...***33**

Pasture 1 has 21 squares; pasture 2 has 18 squares; pasture 3 has
2 squares. Thus Bessie should choose pasture 1 with 21 squares to
maximize the grass she can eat.

PROBLEM NAME: feedtime

INPUT FORMAT:

* Line 1: Two space-separated integers: W and H

* Lines 2..H+1: Line i+1 describes field row i with W characters (and
        no spaces), each either '.' or '*'

SAMPLE INPUT:

10 8
...*....**
..**....**
...*....**
...**.*.**
***.**.***
...**.*.**
...*.*****
...***..**

OUTPUT FORMAT:

* Line 1: A single integer that represents the maximum number of
        squares of grass that Bessie can eat.

SAMPLE OUTPUT:

21
 */
package d13;

import java.io.*;
import java.util.*;

public class Feedtime {
	
	static String[] farm;
	static int[][] visited;
	static int[] dx = {1, 0, 1,-1,-1, -1, 0, 1};
	static int[] dy = {0, 1, 1, 0, 1, -1,-1,-1};
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		farm = new String[R];
		for (int r=0; r<R; r++){
			farm[r] = br.readLine();
		}
		
		int maxSize = 0;
		visited = new int[R][C];
		for (int r=0; r<R; r++){
			for (int c=0; c<C; c++){
				if (farm[r].charAt(c) == '.'){
					size = 1;
					fill(r,c);
					if (size>maxSize){
						maxSize = size;
					}
				}
			}
		}
		
		System.out.println(maxSize);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static void fill (int r, int c){
		visited[r][c] = 1;
		for (int i=0; i<8; i++){
			int nr = r+dx[i];
			int nc = c+dy[i];
			//out of bounds
			if (nr<0 || nc<0 || nr>farm.length-1 || nc>farm[0].length()-1){
				continue;
			}
			//not connected or visited
			if (farm[nr].charAt(nc) == '*' || visited[nr][nc] == 1){
				continue;
			}
			size++;
			fill (nr, nc);
		}
		return;
	}	
}
