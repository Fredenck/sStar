/*
 * MasterMind
==========

Jessie was learning about programming contests at Bessie's knee.
"Do they play games?" she asked.
"Oh yes," Bessie nodded sagely. "Here's a classic."
MasterMind is a classic two player game. One of the players is the
'codemaker'; she picks a four digit secret number S (1000 <= S <=
9999). The other player is the 'codebreaker' who repeatedly guesses
four digit numbers until she solves the code.
The codemaker provides feedback that comprises two integers for
each codebreaker guess G_i (1000 <= G_i <= 9999). For each codebreaker
guess, the codemaker's feedback comprises two integers:

* The first integer C_i (0 <= C_i <= 4) specifies how many of the
  guess's digits are correct and in their correct location in the
  secret number
* The second integer W_i (0 <= W_i <= 4-C_i) specifies how many of
  the remaining digits (i.e., those not described by C_i) are correct
  but in the wrong location.

For example, suppose codemaker's secret number is 2351. If codebreaker
guesses 1350, the codemaker provides the feedback "2 1", since 3
and 5 are in correct locations in the number, and 1 is in the wrong
location. As another example, if the secret number is 11223 (in a
five-digit version of mastermind) and the guess is 12322, then the
feedback would be "2 2".

Below is a sample game where the secret number is 2351:

        Correct digits in correct location
        | Correct digits in wrong location
Guess   | |
3157    1 2
1350    2 1
6120    0 2
2381    3 0
2351    4 0

For this task, you are given N (1 <= N <= 100) guesses with their
feedback in the middle of a game. You are asked to output the
smallest four digit number which can be a candidate for codemaker's
secret code (i.e., which satisfies all the constraints).
If there are no such numbers, output "NONE" (without the quotes).

PROBLEM NAME: mmind

INPUT FORMAT:

* Line 1: A single integer: N

* Lines 2..N+1: Line i+1 contains guess i and its two responses
        expressed as three space-separated integers: G_i, C_i, and W_i

SAMPLE INPUT:

4
3157 1 2
1350 2 1
6120 0 2
2381 3 0

OUTPUT FORMAT:

* Line 1: A single integer that is the smallest four-digit number
        (same range as the secret integer: 1000..9999) which could be
        the secret code. If there are no such numbers, output a single
        line containing the word "NONE" (without quotes).

SAMPLE OUTPUT:

2351
 */
package d5;

//import java.io.*;
//import java.lang.*;
import java.util.*;


public class Mmind {
    public static Bcg bullsAndCows(String secret, String guess) {
        //arrays
        //String[] sArr = secret.split("");
        //String[] gArr = guess.split("");
    	String sArr = secret;
    	String gArr = guess;
        int[] noI = new int[10];
        int[] noJ = new int[10];
        
        int b=0;
        int c=0;
        for (int i=0; i<sArr.length(); i++){
            //bulls
        	if (sArr.charAt(i)==(gArr.charAt(i))){
                b++;
            }else{
                //frq of others
                noI[(sArr.charAt(i))-'0']++;
                noJ[(gArr.charAt(i))-'0']++;            	
            }
        }
        for (int i=0; i<10; i++){
        	c += Math.min(noI[i], noJ[i]);
        }
        
        return new Bcg(Integer.parseInt(secret), b, c);
    }
	
	public static boolean bc(int a, Bcg[] arr){
		for (int i=0; i<arr.length; i++){
//		    System.out.print(a);
//		    System.out.println(" " +arr[i].guess);
			Bcg t = bullsAndCows(""+a, ""+arr[i].guess);
//            System.out.println(t.bull==arr[i].bull);
//			System.out.print(t.bull+ " ");
//			System.out.println(arr[i].bull);
//            System.out.println(t.cow==arr[i].cow);
			if (!(t.bull==arr[i].bull && t.cow==arr[i].cow)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Bcg[] guesses = new Bcg[N];
		for (int i=0; i<N; i++){
			guesses[i] = new Bcg(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		boolean found = false;
		for (int pos=1000; pos<10000; pos++){
		    
			if (bc(pos, guesses)){
				System.out.println(pos);
				found = true;
				break;
			}
		}
		if (!found){
			System.out.println("NONE");
		}
		sc.close();
	}
	public static class Bcg{
		int guess;
		int bull;
		int cow;
		public Bcg(int g, int b, int c){
			guess = g;
			bull = b;
			cow = c;
		}
	}
}
