/*
 * High Card Wins
==============

Bessie the cow is a huge fan of card games, which is quite 
surprising, given her lack of opposable thumbs. Unfortunately, none 
of the other cows in the herd are good opponents. They are so bad, 
in fact, that they always play in a completely predictable fashion! 
Nonetheless, it can still be a challenge for Bessie to figure out 
how to win.

Bessie and her friend Elsie are currently playing a simple card 
game where they take a deck of 2N cards, conveniently numbered 
1...2N, and divide them into N cards for Bessie and N cards for 
Elsie. The two then play N rounds, where in each round Bessie and 
Elsie both play a single card, and the player with the highest card 
earns a point.

Given that Bessie can predict the order in which Elsie will play 
her cards, please determine the maximum number of points Bessie can 
win.

PROGRAM NAME: highcard

INPUT FORMAT:

The first line of input contains the value of N (1 <= N <= 50,000).

The next N lines contain the cards that Elsie will play in each of 
the successive rounds of the game. Note that it is easy to 
determine Bessie's cards from this information.

OUTPUT FORMAT:

Output a single line giving the maximum number of points Bessie can 
score.

SAMPLE INPUT:

3
1
6
4

SAMPLE OUTPUT:

2

Here, Bessie must have cards 2, 3, and 5 in her hand, and she can 
use these to win at most 2 points by saving the 5 until the end to 
beat Elsie's 4.
 */
package d7;

import java.io.*;
import java.util.*;

public class Highcard {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[100005];
		ArrayList<Integer> eHand = new ArrayList<Integer>();
		ArrayList<Integer> bHand = new ArrayList<Integer>();
		for (int i=0; i<N; i++){
			int in = Integer.parseInt(br.readLine());
			arr[in] = true;
		}
		for (int i=1; i<2*N+1; i++){
			if(arr[i]){
				eHand.add(i);
			}else{
				bHand.add(i);
			}
		}
		
		int ct = 0;
		int e = 0,b = 0;
		while(e<N && b<N){
			if (eHand.get(e)<bHand.get(b)){
				ct++;
				b++;
				e++;
			}else{
				b++;
			}
		}
		
		System.out.println(ct);
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
}
