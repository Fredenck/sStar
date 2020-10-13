/*
 * Satellite Photographs
=====================

Farmer John purchased satellite photos of W x H pixels of his farm
(1 <= W <= 80, 1 <= H <= 1000) and wishes to determine the largest
'contiguous' (connected) pasture. Pastures are contiguous when any
pair of pixels in a pasture can be connected by traversing adjacent
vertical or horizontal pixels that are part of the pasture.  (It is
easy to create pastures with very strange shapes, even circles that
surround other circles.)

Each photo has been digitally enhanced to show pasture area as an
asterisk ('*') and non-pasture area as a period ('.').  Here is a
10 x 5 sample satellite photo:
 
..*.....**
.**..*****
.*...*....
..****.***
..****.***
 
This photo shows three contiguous pastures of 4,  16, and 6 pixels.  
Help FJ find the largest contiguous pasture in each of his satellite
photos.

PROBLEM NAME: satpix

INPUT FORMAT:

* Line 1: Two space-separated integers: W and H

* Lines 2..H+1: Each line contains W "*" or "." characters
        representing one raster line of a satellite photograph.

SAMPLE INPUT:

10 5
..*.....**
.**..*****
.*...*....
..****.***
..****.***

OUTPUT FORMAT:

* Line 1: The size of the largest contiguous field in the satellite
        photo.

SAMPLE OUTPUT:

16
 */
package d13;

import java.io.*;
import java.util.*;

public class Satpix {
	
	static String[] satellite;
	static int[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		satellite = new String[R];
		for (int r=0; r<R; r++){
			satellite[r] = br.readLine();
		}
		
		int[] sizes = new int[R*C];
		int sidx = 0;
		visited = new int[R][C];
		for (int r=0; r<R; r++){
			for (int c=0; c<C; c++){
				if (satellite[r].charAt(c) == '*'){
					size = 1;
					fill(r,c);
					sizes[sidx] = size;
					sidx++;
				}
			}
		}
		
		
		System.out.println(max(sizes));
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static void fill (int r, int c){
		visited[r][c] = 1;
		for (int i=0; i<4; i++){
			int nr = r+dx[i];
			int nc = c+dy[i];
			//out of bounds
			if (nr<0 || nc<0 || nr>satellite.length-1 || nc>satellite[0].length()-1){
				continue;
			}
			//not connected or visited
			if (satellite[nr].charAt(nc) == '.' || visited[nr][nc] == 1){
				continue;
			}
			size++;
			fill (nr, nc);
		}
		
		return;
	}
	public static int max(int[] arr){
		int maximum = arr[0];
		for (int i=1; i<arr.length; i++){
			if (arr[i]>maximum){
				maximum = arr[i];
			}
		}
		return maximum;
	}
}
