/*
 * Cow Cotillion
=============

The cow cotillion, a fancy dance every spring, requires the cows
(shown as ">") and bulls (shown as "<") to bow to each other during
a dance. Schematically, one properly bowing pair of cattle is shown
like this: "><". Sometimes another pair of cattle will sashay between
a pair of bowing cows: "> >< <".

In fact, sometimes a larger number of cows will mix it up on the
dance floor: "> >< < ><" (this includes a second set of bowing cows
on the right). Complex arrangements can be perfectly legal dance
formations:
              > > > >< < >< < >< >< >< <
 
              | | | -- | -- | -- -- -- |
              | | ------    |          |
              | -------------          |
              --------------------------

Farmer John notices that a stray heifer sometimes sneaks into a
group and unbalances it: "> >< < <><". This is strictly forbidden;
FJ wants to punish the interlopers.

FJ has copied down records of as many as 500 cows participating in
dance lines and wonders if the dance line is properly balanced
(i.e., all of the cattle can be paired off in at least one way as
properly bowing pair by pair). He copied only the direction each
cow was bowing without any extra spaces to help determine which cow
was bowing to which bull, strings like this rendition of the illegal
example from the previous paragraph: ">><<<><". He wants you to
write a program to tell him if the dance line is legal.

FJ has N (1 <= N <= 1,000) pattern recordings P_i comprising just
the characters '>' and '<' with varying length K_i (1 <= K_i <=
200).  Print "legal" for those patterns that include proper pairs
of bowing cows and "illegal" for those that don't.

PROBLEM NAME: dance2

INPUT FORMAT:

* Line 1: A single integer: N

* Lines 2..N+1: Line i contains an integer followed by a space and a
        string of K characters '>' and '<': K_i and P_i

SAMPLE INPUT:

2
6 >><<><
4 ><<>

OUTPUT FORMAT:

* Lines 1..N: Line i contains either the word "legal" or "illegal"
        (without the quotes, of course) depending on whether the input
        has a legal bowing configuration.

SAMPLE OUTPUT:

legal
illegal
 */
package d5;

import java.util.*;

public class Dance2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++){
			int totDancers = sc.nextInt();
			String dancers = sc.next();
			int cows = 0;
			int bulls = 0;
			for (int j=0; j<totDancers; j++){
				if (dancers.charAt(j) == '>'){
					cows++;
				}else if (dancers.charAt(j) == '<'){
					bulls++;
				}
				
				if (bulls > cows){
					break;
				}
			}
			if (bulls > cows){
				System.out.println("illegal");
			}
			else if (cows==bulls){
				System.out.println("legal");
			}else{
				System.out.println("illegal");
			}
		}
		sc.close();
	}
}