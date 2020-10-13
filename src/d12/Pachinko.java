/*
 * Cow Pinball
===========

The cows are playing that cool Japanese 'pinball' game called
Pachinko. You've probably seen it, you drop a ball in the top and
it hits nails on the way down, veering just a little left or right,
until the ball comes out the bottom.

This pachinko game is special: the ball always hits the top nail
of the R rows of nails (1 <= R <= 25) and then will hit either the
right or left nail underneath that.  From there, the ball can hit
the next nail that's just a bit lower and to the left or right of
the second nail, and so on. The ball never veers too far (i.e.,
more than 1/2 nail away) from the nail it just hit.

This game also has scoring that's unique: you get points X_ij (0
<= X_ij <= 3,000) for each little nail you hit on the way down. The
cows want to maximize their score on this machine. What is the best
score they can achieve?

Here's an example triangle and a good route:

                    7                        *7

                  3   8                    *3   8

                8   1   0                *8   1   0

              2   7   4   4             2  *7   4   4

            4   5   2   6   5         4  *5   2   6   5

In the sample above, the route from 7 to 3 to 8 to 7 to 5 produces
the highest sum: 30. It's not possible to go from 7 to 8 to 8 --
the 8 on the third row is too far away.

PROBLEM NAME: pachinko

INPUT FORMAT:

* Line 1: A single integer: R

* Lines 2..R+1: Line i+1 contains i space-separated integers that
        compose the scores of row R of the pachinko machine: X_i1,
        X_i2, ...

SAMPLE INPUT:

5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5

OUTPUT FORMAT:

* Line 1: A single integer that is the maximum achievable score.

SAMPLE OUTPUT:

30

OUTPUT DETAILS:

No other achievable sum is higher.
 */
package d12;

import java.io.*;
import java.util.*;

public class Pachinko {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		
		int[][] pachinko = new int[R][R];
		
		for (int i=0; i<R; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<i+1; j++){
				pachinko[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long startTime = System.nanoTime();
		
		ArrayList<Integer> tots = new ArrayList<Integer>();
		int tot = dfs(pachinko,0,0,pachinko[0][0],0,tots);
		
		System.out.println(tot);
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static int dfs(int[][] mat, int r, int c, int tot, int maxTot, ArrayList<Integer> tots){
		//BL, BR
		int[] cDirections = {0, 1};
		int[] rDirections = {1, 1};
		
		for (int i=0; i<2; i++){
			if (c+cDirections[i]>mat.length-1 || r+rDirections[i]>mat.length-1){
				return tot;
			}
			tot += mat[r+rDirections[i]][c+cDirections[i]];
			dfs(mat, r+rDirections[i], c+cDirections[i], tot, maxTot,tots);
			if (tot>max(tots)){
				maxTot = tot;
				tots.add(maxTot);
//				System.out.println(maxTot);
			}
			tot -= mat[r+rDirections[i]][c+cDirections[i]];
		}
		if (r==0 && c==0){
			return max(tots);
		}
		return tot;
	}
	public static int max(ArrayList<Integer> arr){
		int max = 0;
		for (int i:arr){
			if (i>max){
				max = i;
			}
		}
		return max;
	}
}
