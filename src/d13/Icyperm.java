/*
 * Icy Perimeter
=============

Farmer John is going into the ice cream business! He has built a 
machine that produces blobs of ice cream but unfortunately in 
somewhat irregular shapes, and he is hoping to optimize the machine 
to make the shapes produced as output more reasonable.

The configuration of ice cream output by the machine can be 
described using an N x N grid (1 <= N <= 1000) as follows:

##....
....#.
.#..#.
.#####
...###
....##

Each '.' character represents empty space and each '#' character 
represents a 1 x 1 square cell of ice cream.

Unfortunately, the machine isn't working very well at the moment 
and might produce multiple disconnected blobs of ice cream (the 
figure above has two). A blob of ice cream is connected if you can 
reach any ice cream cell from every other ice cream cell in the blob 
by repeatedly stepping to adjacent ice cream cells in the north, 
south, east, and west directions.

Farmer John would like to find the area and perimeter of the blob 
of ice cream having the largest area. The area of a blob is just 
the number of '#' characters that are part of the blob. If multiple 
blobs tie for the largest area, he wants to know the smallest 
perimeter among them. In the figure above, the smaller blob has 
area 2 and perimeter 6, and the larger blob has area 13 and 
perimeter 22.

Note that a blob could have a "hole" in the middle of it (empty 
space surrounded by ice cream). If so, the boundary with the hole 
also counts towards the perimeter of the blob. Blobs can also 
appear nested within other blobs, in which case they are treated 
as separate blobs. For example, this case has a blob of area 1 
nested within a blob of area 16:

#####
#...#
#.#.#
#...#
#####

Knowing both the area and perimeter of a blob of ice cream is 
important, since Farmer John ultimately wants to minimize the 
ratio of perimeter to area, a quantity he calls the icyperimetric 
measure of his ice cream. When this ratio is small, the ice cream 
melts slower, since it has less surface area relative to its mass.

INPUT FORMAT:

The first line of input contains N, and the next N lines describe 
the output of the machine. At least one '#' character will be 
present.

OUTPUT FORMAT:

Please output one line containing two space-separated integers, the 
first being the area of the largest blob, and the second being its 
perimeter. If multiple blobs are tied for largest area, print the 
information for whichever of these has the smallest perimeter.

SAMPLE INPUT:

6
##....
....#.
.#..#.
.#####
...###
....##

SAMPLE OUTPUT:

13 22
 */
package d13;

import java.io.*;

public class Icyperm {
	
	static String[] iceCream;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] visited;
	static int area;
	static int perim;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		iceCream = new String[N];
		int pound = 0;
		for (int r=0; r<N; r++){
			iceCream[r] = br.readLine();
			for (int c=0; c<N; c++){
				if (iceCream[r].charAt(c)=='#'){
					pound++;
				}
			}
		}
		
		visited = new int[N][N];
		if (pound==N*N){
			System.out.println(N*N+" "+4*N);
		}else{
			int mArea = 0;
			int mPerim = 0;
			for (int r=0; r<N; r++){
				for (int c=0; c<N; c++){
					if (iceCream[r].charAt(c) == '#' && visited[r][c]==0){
						area = 1;
						perim = 0;
						fill(r,c);
						if (area>mArea){
							mArea = area;
							mPerim = perim;
						}else if (area==mArea){
							if (perim<mPerim){
								mPerim = perim;
							}
						}
					}
				}
			}
			
			System.out.print(mArea+" ");
			System.out.println(mPerim);
		}
	//	System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	//-Xss1024K
	public static void fill (int r, int c){
		visited[r][c] = 1;
		perim += perimeter(r,c);
		for (int i=0; i<4; i++){
			int nr = r+dx[i];
			int nc = c+dy[i];
			//out of bounds
			if (nr<0 || nc<0 || nr>iceCream.length-1 || nc>iceCream[0].length()-1){
				continue;
			}
			if (visited[nr][nc] == 1){
				continue;
			}
			//not connected
			if (iceCream[nr].charAt(nc) == '.'){
				continue;
			}
			area++;
			fill (nr, nc);
		}
		return;
	}
	public static int perimeter(int r, int c){
		int p=0;
		for (int i=0; i<4; i++){
			int nr = r+dx[i];
			int nc = c+dy[i];
			if (nr<0 || nc<0 || nr>iceCream.length-1 || nc>iceCream[0].length()-1){
				continue;
			}
			if (iceCream[nr].charAt(nc) == '#'){
				p++;
			}
		}
		return 4-p;
	}
}
