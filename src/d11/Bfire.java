/*
 * The Bovine Fire Drill
=====================

The N (3 <= N <= 250) cows (conveniently labeled cow_1..cow_N) sat
in a perfect circle  around the camp fire in chairs numbered
chair_1..chair_N as Farmer John told them stories of the old days
(cow_i sits in chair_i, of course). At the conclusion of one story,
FJ suggested they perform a Bovine Fire Drill.

In a Bovine Fire Drill, one cow at a time walks around the circle
from her chair to a potentially new chair while the other cows chant
"Fire, fire, fire." When it is cow_i's turn to move, she rises and
moves clockwise to the i'th chair encountered in that direction (so
if it was cow_3's turn, she would rise from chair_3 and move to
chair_6 if N >= 6).

When cow_i arrives at her new chair, she taps any cow sitting there
on the shoulder; that cow rises to make room for cow_i, who sits
down. This process continues until a cow lands in an empty chair
or until a cow is asked to move for a second time. In either of
those cases, the game ends. Cow 1 always starts, so it is her chair
that will be the empty one.

Only rarely do all the cows get to participate, as the game termination
conditions arise naturally and frequently from the properties of
whole numbers. The final cow to move (whether she ends the game by
sitting in cow_1's chair or by tapping the shoulder of a cow who
has already moved) receives a special treat of extra tender grass.

Help FJ plan in advance to learn which cow will get the tender
grass.

For example, consider five cows sitting around the blazing campfire:

  2   -   3
 (         )
  1 - 5 - 4

First, cow 1 walks one space and taps cow 2, who rises. (The *
denotes the empty chair.)

    2
 1   -   3
 (         )
  * - 5 - 4

Cow 2 walks two spaces and taps cow 4, who begins her journey:

  1   -    3
 (         )
  * -  5 - 2
          4

Cow 4 will walk four spaces and tap cow 3:
             3
  1   -    4  
 (         )
  * -  5 - 2
          
Finally, cow 3 will walk three spaces to chair_1, which is empty and thus
terminates
the drill.
             
  1   -    4  
 (         )
  3 -  5 - 2

Cow 3 receives tender spring grass as the other cows clap and cheer.

PROBLEM NAME: bfire

INPUT FORMAT:

* Line 1: A single integer: N

SAMPLE INPUT:

5

OUTPUT FORMAT:

* Line 1: The number of the cow who ends the drill

SAMPLE OUTPUT:

3
 */
package d11;

import java.io.*;
import java.util.*;

public class Bfire {
	
	public static void main(String[] args) throws IOException {
//		File file = new File("helpcross");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i=1; i<N+1; i++){
			arr[i-1] = i;
		}
		boolean flag = true;
		int cidx = 0;
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(1);
		int ocidx = 0;
		while (flag){
			cidx = (cidx+arr[cidx])%N;
			if (visited.contains(arr[cidx])){
				flag = false;
				break;
			}
			visited.add(arr[cidx]);
			ocidx = cidx;
		}
		
		System.out.println(arr[ocidx]);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
}
