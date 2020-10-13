/*
 * Mountain Watching
=================

One day, Bessie was gazing off into the distance at the beautiful 
Wisconsin mountains when she wondered to herself: which is the 
widest one?

She decided to take N (1 <= N <= 10,000) height measurements H_i
(1 <= H_i <= 1,000,000,000) sequentially along the horizon using
her new Acme Long Distance Geoaltimeter. 

A mountain is defined to be a consecutive sequence of H_i values
which increases (or stays the same) and then decreases (or stays     
the same), e.g., 2, 3, 3, 5, 4, 4, 1. It is possible for a mountain
on the edge of her field of vision only to increase or only to      
decrease in height, as well.

The width of a mountain is the number of measurements it encompasses.
Help Bessie identify the widest mountain.

Here's a simple example of a typical horizon:

           *******                   *
          *********                 ***
          **********               *****
          ***********           *********               *
*      *****************       ***********             *** *
**    *******************     *************   * *     *******      *
**********************************************************************
?ddsssuussuussssssddddssddssssuuuuuuuuddddddssududssssuuudduddsssssuds
3211112333677777776543332111112344456765432111212111112343232111111211
aaaaa                     cccccccccccccccccccc eeeeeee    ggggggggg
  bbbbbbbbbbbbbbbbbbbbbbbbbbbb             ddddd ffffffffff  hhhhhhhhh

The mountains are marked 'a', 'b', etc.  Obviously, mountain b is
widest with width 28.

Hint: Sometimes it's easiest to find a mountain's width by knowing
where its highest parts are.

PROBLEM NAME: mount

INPUT FORMAT:

* Line 1: A single integer: N

* Lines 2..N+1: Line i+1 contains a single integer: H_i

SAMPLE INPUT:

7
3
2
3
5
4
1
6

INPUT DETAILS:

The height measurements are 3, 2, 3, 5, 4, 1, 6.

OUTPUT FORMAT:

* Line 1: A single line with a single integer that is the width of the
        widest mountain.

SAMPLE OUTPUT:

5

OUTPUT DETAILS:

The widest mountain consists of the measurements 2, 3, 5, 4, 1. Other
mountains include 3, 2 and 1, 6
 */
package d7;

import java.io.*;
import java.util.*;

public class Mount {
	//for greedy: if 1-1 matching higher and lower, then look at Buyfree(Wk2-Day2) or Highcard
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] mountains = new int[N];
		int[] widths = new int[N];
		
		for (int i=0; i<N; i++){
			mountains[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i=0; i<N; i++){
			int width = 1;
			if (isPeak(mountains, i)){
				int right = fRight(mountains, i);
				int left = fLeft(mountains, i);
				width += right+left;
			}
			widths[i] = width;
		}
		
		System.out.println(Arrays.toString(widths));
		int max = widths[0];
		for (int i=1; i<widths.length; i++){
			if (widths[i]>max){
				max = widths[i];
			}
		}
		System.out.println(max);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	private static int fLeft(int[] mountains, int i) {
		int ct = 0;
		if (i==0){
			return ct;
		}
		while (i!=0 && mountains[i-1] <= mountains[i]){
			ct++;
			i--;
		}
		return ct;
	}
	private static int fRight(int[] mountains, int i) {
		int ct = 0;
		if (i==mountains.length-1){
			return ct;
		}
		while (i!=mountains.length-1 && mountains[i+1] <= mountains[i]){
			ct++;
			i++;
		}
		return ct;
		
	}
	//check if mountains[pos] is a peak by checking adjacent 
	public static boolean isPeak(int[] mountains, int pos){
		if (pos-1<0){
			return mountains[pos+1]<=mountains[pos];
		}else if(pos+1>=mountains.length){
			return mountains[pos-1]<=mountains[pos];
		}else{
			return mountains[pos-1]<=mountains[pos] && mountains[pos]>=mountains[pos+1];
		}
	}
}
