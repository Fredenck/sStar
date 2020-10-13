/*
 * Marathon II
===========

Unhappy with the poor health of his cows, Farmer John enrolls them in
an assortment of different physical fitness activities.  His prize cow
Bessie is enrolled in a running class, where she is eventually
expected to run a marathon through the downtown area of the city near
Farmer John's farm!

The marathon course consists of N checkpoints (3 <= N <= 100,000) to
be visited in sequence, where checkpoint 1 is the starting location
and checkpoint N is the finish.  Bessie is supposed to visit all of
these checkpoints one by one, but being the lazy cow she is, she
decides that she will skip up to one checkpoint in order to shorten
her total journey.  She cannot skip checkpoints 1 or N, however, since
that would be too noticeable.

Please help Bessie find the minimum distance that she has to run if
she can skip up to one checkpoint.  

Note that since the course is set in a downtown area with a grid of
streets, the distance between two checkpoints at locations (x1, y1)
and (x2, y2) is given by |x1-x2| + |y1-y2|.  This way of measuring
distance -- by the difference in x plus the difference in y -- is
sometimes known as "Manhattan" distance because it reflects the fact
that in a downtown grid, you can travel parallel to the x or y axes,
but you cannot travel along a direct line "as the crow flies".

PROBLEM NAME: marathon2

INPUT:

The first line gives the value of N.

The next N lines each contain two space-separated integers, x and y,
representing a checkpoint (-1000 <= x <= 1000, -1000 <= y <= 1000).
The checkpoints are given in the order that they must be visited.
Note that the course might cross over itself several times, with
several checkpoints occurring at the same physical location.  When
Bessie skips such a checkpoint, she only skips one instance of the
checkpoint -- she does not skip every checkpoint occurring at the same
location.

SAMPLE INPUT:

4
0 0
8 3
11 -1
10 0

OUTPUT:

Output the minimum distance that Bessie can run by skipping up to one
checkpoint.  Don't forget to end your output with a newline.  In the
sample case shown here, skipping the checkpoint at (8, 3) leads to the
minimum total distance of 14.

SAMPLE OUTPUT:

14
 */
package d11;

import java.io.*;
import java.util.*;

public class Marathon2 {
	
	public static void main(String[] args) throws IOException {
//		File file = new File("helpcross");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Coords[] checkpoints = new Coords[N];
		for (int i=0; i<N; i++){
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			checkpoints[i] = new Coords(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int maxSaved = 0;
//		int bestIdx = 0;
		int totD = 0;
		for (int i=1; i<N-1; i++){//second checkpoint to second-last
			int distNotSkip = dReq(i,checkpoints);
			int dSkip = dist(checkpoints[i+1].x,checkpoints[i-1].x,checkpoints[i+1].y,checkpoints[i-1].y);
			if (distNotSkip-dSkip>maxSaved){
//				bestIdx = i;
				maxSaved = distNotSkip-dSkip;
			}
		}
		
		for (int i=0; i<N-1; i++){
			totD += dist(checkpoints[i].x,checkpoints[i+1].x,checkpoints[i].y,checkpoints[i+1].y);
		}
		System.out.println(totD);
		System.out.println(maxSaved);
		System.out.println(totD-maxSaved);
		
		
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static class Coords{
		int x;
		int y;
		public Coords(int xc, int yc){
			x = xc;
			y = yc;
		}
	}
	public static int dReq(int idx, Coords[] checkpoints){
		int d1 = dist(checkpoints[idx].x,checkpoints[idx-1].x,checkpoints[idx].y,checkpoints[idx-1].y);
		int d2 = dist(checkpoints[idx].x,checkpoints[idx+1].x,checkpoints[idx].y,checkpoints[idx+1].y);
		return d1+d2;
	}
	public static int dist(int x1, int x2, int y1, int y2){
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
