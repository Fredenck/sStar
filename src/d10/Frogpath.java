/*
 * Frog's Path
===========

A frog starts from the first square (leftmost) and tries to reach 
the end of a road (rightmost). The road has some obstacles. The 
frog can only slide one square or jump over a square to right. 
In how many ways, he can reach his destination.

PROBLEM NAME: frogpath

INPUT FORMAT:

* Line 1: A single line, the board composed of '-' and '#'
          where '-' is an empty spot and '#' is an obstacle.
          The length of the road will not be more than 20.

SAMPLE INPUT:

---#-#---

OUTPUT FORMAT:

* Line 1: A single integer that is the number of ways.

SAMPLE OUTPUT:

4

OUTPUT DETAILS:

The frog can reach to the rightmost square in 4 ways:

(s: for slide, j for jump)

Board        Moves
---------    ------
012#3#456 => ssjjss
012#3#4-5 => ssjjj
0-1#2#345 => jjjss
0-1#2#3-4 => jjjj
 */
package d10;

import java.io.*;

public class Frogpath {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String board = br.readLine();
//		int N = board.length();
		
		System.out.println(solve(0,board));
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static int solve(int x, String board){
		if (x>=board.length() || board.charAt(x) == '#'){
			return 0;
		}else if (x==board.length()-1){
			return 1;
		}
		return solve(x+1, board)+solve(x+2, board);
	}
	public static int Perm(int cur, int n, int[] used, String seq, char[] ans){
		if (cur == n){
			return ans.length;
		}
		for (int i=0; i<n; i++){
			if (!(used[i]==1)){
				ans[cur] = seq.charAt(i);
				used[i] = 1;
				if (ans[cur] == '-'){
					
				}
				Perm(cur+1, n, used, seq, ans);
				used[i] = 0;
			}
		}
		return ans.length;
	}
}
