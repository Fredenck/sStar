/*
 * The Leisurely Stroll
====================

Bessie looks out the barn door at the beautiful spring day and
thinks to herself, "I'd really like to enjoy my walk out to the
pastures for the tender spring grass." She knows that once she
leaves the barn, she will traverse a path for a while, take one of
two choices that lead to other paths, follow one of them, take one
of two other choices, and continue on until the path leads to a
verdant pasture.

She decides to make the set of path choices that enables her to
walk over the greatest number of cow paths on her way to breakfast.
Given the description of these paths, determine how many cow paths
she traverses, presuming that she commences choosing various paths
as soon as she leaves the barn.

The farm has P (1 <= P <= 1,000) pastures that are lead to by P-1
choice-nodes (range 1..P-1) connected by paths. From the barn (which
is node 1), only one set of path traversals exists to reach any
choice-node or pasture.

Consider this set of paths (lines), pastures ('%'), and the highlighted
('#') route to a pasture on the right:

                 %                             %
                /                             /
      2----%   7----8----%          2----%   7####8----%
     / \      /      \             # #      #      #
    1   5----6        9----%      1   5####6        9----%
     \   \    \        \           \   \    \        #
      \   %    %        %           \   %    %        %
       \                             \
        3-----%                       3-----%
         \                             \
          4----%                        4----%
           \                             \
            %                             %


The pasture reached from choice-node 9 is one of two that enable
Bessie to traverse seven different cowpaths on the way to breakfast.
These are the 'furthest' pastures from node 1, the barn.

Three integers describe each node: Cn, D1, and D2. Cn is the
nodenumber (1 <= Cn <= P-1); D1 and D2 are the destinations from
that node (0 <= D1 <= P-1; 0 <= D2 <= P-1). If D1 is 0, the node
leads to a pasture in that direction; D2 has the same property.

PROBLEM NAME: stroll

INPUT FORMAT:

* Line 1: A single integer: P

* Lines 2..P: Line i+1 contains three space-separated integeres that
        describe a choice-node: Cn, D1, and D2

SAMPLE INPUT:

10
7 8 0
5 0 6
9 0 0
6 0 7
3 4 0
2 5 0
8 0 9
4 0 0
1 2 3

INPUT DETAILS:

This input describes the example farm layout in the task description.

OUTPUT FORMAT:

* Line 1: A single integer that is the largest number of paths Bessie
        can traverse on the way to the furthest pasture.

SAMPLE OUTPUT:

7

OUTPUT DETAILS:

1-2-5-6-7-8-9-P is one of the longest routes.
 */
package d13;

import java.io.*;
import java.util.*;

public class Stroll {
	
	static int[][] adjL;
	static ArrayList<ArrayList<Integer>> pathO;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		
		adjL = new int[P+1][2];
		for (int i=0; i<P-1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			adjL[idx][0] = Integer.parseInt(st.nextToken());
			adjL[idx][1] = Integer.parseInt(st.nextToken());			
		}
		
		pathO = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> path = new ArrayList<Integer>();
		dfs(1,path);
		
		int mSize = 0;
		for (ArrayList<Integer> arr:pathO){
			if (arr.size()>mSize){
				mSize = arr.size();
			}
		}
		
		System.out.println(mSize+1);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	@SuppressWarnings("unchecked")
	public static void dfs(int cidx, ArrayList<Integer> path){
		//end is two pastures
		if (adjL[cidx][0]==0 && adjL[cidx][1]==0){
			pathO.add((ArrayList<Integer>) path.clone());
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