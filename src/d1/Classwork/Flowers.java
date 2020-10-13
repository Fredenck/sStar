/*
 * The Flower Garden
=================

Imagine Betsy's surprise as she rounded the barn and discovered
that Farmer John had built a secret greenhouse that was now brimming
with gorgeous flowers. Her mind ran wild as visions of a gorgeous
colorful garden swirled through her little bovine brain.

"I think I'll make a long row of F (7 <= F <= 10,000) flowers against
the far fence," she thought.  "I'll plant roses in every 3rd slot,
begonias in every 7th slot that is still open, and daisies in every
4th slot that is still open." Betsy wondered how many open slots
would remain. She realized that the number would depend on which
slot she started planting when she intended to fill every Nth slot
with a kind of flower.

Help Betsy know how many open slots will remain. Read a set of K
(1 <= K <= 100) planting descriptors, each of which tells a starting
location L (1 <= L <= F) -- L=1 is the first flower -- and an
interval I (1 <= I <= F) for planting flowers. Deduce the number
of empty slots that remain after planting the entire set.

If Betsy followed through on her initial vision, she might specify
the planting as:
      30 3     [30 slots total; 3 kinds of flowers]
      1 3      [start at slot 1 and plant roses every 3rd slot]
      3 7      [start at slot 3 and plant begonias every 7rd slot]
      1 4      [start at slot 1 and plant daisies in every 4th slot]

Thus, the empty garden looks like this:
     . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
Then, after the rose planting:
     R . . R . . R . . R . . R . . R . . R . . R . . R . . R . .
Then, after the begonia planting:
     R . B R . . R . . R . . R . . R B . R . . R . B R . . R . .
Then, after the daisy planting:
     R . B R D . R . D R . . R . . R B . R . D R . B R . . R D .

13 empty slots remain after all the planting.

PROBLEM NAME: flowers

INPUT FORMAT:
* Line 1: Two space-separated integers: F and K
* Lines 2..K+1: Line j contains two space-separated integers that
        specify the planting of one kind of flower: L_j and I_j

SAMPLE INPUT:
30 3
1 3
3 7
1 4

INPUT DETAILS:
As in the problem's text

OUTPUT FORMAT:
* Line 1: A single line with a single integer that is the number of
        empty flower slots that remain after the planting is complete

SAMPLE OUTPUT:
13
 */
package d1.Classwork;

import java.util.*;

public class Flowers {
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int k = sc.nextInt();
		boolean[] garden = new boolean[f];
		int ct = 0;		
		
		int start;
		int interval;
		
		for (int i=0; i<k; i++){
			start = sc.nextInt()-1;
			interval = sc.nextInt();
			for (int j=start; j<f; j+=interval){
				garden[j] = true;
			}
		}
		for (boolean b:garden){
			if (!b){
				ct++;
			}
		}
		System.out.println(ct);
		sc.close();
	}
}
