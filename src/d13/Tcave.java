/*
 * Treasure Cave
=============

Bessie's grandfather was a pirate who accumulated a great treasure
chest of golden plunder. He hid the treasure chest in a cave that
Bessie has recently discovered right on Farmer John's land! Just
inside the cave's entrance she found a map that told her how to get
the treasure.

The cave has P passages (3 <= P <= 5,000) conveniently numbered
1..P. The entrance is passage 1; the treasure is located in some
reachable passage T (2 <= T <= P), whose value is supplied. Passages
are all approximately the same length; each one leads to a split
where hitherto unexplored numbered passages take the inquisitive
cow deeper underground. No passage appears as the split from more
than one passage, and the map contains a total of NS splits (1 <=
NS <= 5,000).

Bessie wants to know both how far away from the entrance the treasure
lies and also which passage numbers to take to get to the treasure.

Consider the schematic representation of a cave shown below. Passage
numbers are shown close to the passage they name. For this example,
the treasure is at the end of passage number 7:

                   3/
                   /
                  +
                 / \   /5
               2/  4\ /
           1   /     +
          ----+      6\   #7    /11
               \       \ /     /
              13\       +     +
                        8\ 10/ \
                          \ /   \12
                           +
                           9\
                             \

Bessie would have to traverse passages 1, 2, 4, 6, and 7 to get to
the treasure, a total distance of 5 (which is simply the passage
count).

The input file includes a set of lines, each with a passage number
N (1 <= N <= P) and the two passages (B1 and B2; 1 <= B1 <= P; 1
<= B2 <= P) that branch off from it. Some line in the input file
will include passage number 1 and its two branches (for our example,
passages 2 and 13; likewise, passage number 8 has two branches: 9
and 10).

Tell Bessie how to get to the treasure.

PROBLEM NAME: tcave

INPUT FORMAT:

* Line 1: Line 1 contains three space-separated integers: P, NS, and T

* Lines 2..NS+1: Each line contains three space-separated integers: N,
        B1, and B2

SAMPLE INPUT:

13 6 7
6 7 8
2 3 4
10 11 12
8 9 10
1 2 13
4 5 6

INPUT DETAILS:

This input describes the sample cave in text.

OUTPUT FORMAT:

* Line 1: The distance D from the entrance to the treasure

* Lines 2..D+1: Line i+1 contains a single integer that is next
        passage Bessie takes to get to the treasure.

SAMPLE OUTPUT:

5
1
2
4
6
7

OUTPUT DETAILS:

As in the text.
 */
package d13;

import java.io.*;
import java.util.*;

public class Tcave {
	
	static int[][] adjL;
	static int P;
	static int NS;
	static int T;
	static boolean found = false;
	static ArrayList<Integer> path;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		P = Integer.parseInt(st.nextToken());
		NS = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		//1 idx
		adjL = new int[P+1][2];
		for (int i=0; i<NS; i++){
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			adjL[idx][0] = Integer.parseInt(st.nextToken());
			adjL[idx][1] = Integer.parseInt(st.nextToken());
		}

		path = new ArrayList<Integer>();
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		dfs(1,path);
		System.out.println(path.size());
		for (int i:path){
			System.out.println(i);
		}
		
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	@SuppressWarnings("unchecked")
	public static void dfs(int cidx, ArrayList<Integer> path){
		if (cidx==T){
			path.add(T);
			path = (ArrayList<Integer>) path.clone();
			return;
		}
		//dead end
		if (adjL[cidx][0]==0 && adjL[cidx][1]==0){
			return;
		}
		path.add(cidx);
		
		for (int i=0; i<2; i++){
			int next = adjL[cidx][i];
			dfs(next,path);
		}
		path.remove(path.size()-1);
		return;
	}
}
