/*
 * Securing the Barn
=================

Farmer John has installed a new security system on the barn and now
must issue a valid password to the cows in the herd. A valid password
consists of L (3 <= L <= 15) different lower-case characters (from the
traditional latin character set 'a'...'z'), has at least one vowel
('a', 'e', 'i', 'o', or 'u'), at least two consonants (non-vowels),
and has characters that appear in alphabetical order (i.e., 'abc'
is valid; 'bac' is not).

Given a desired length L along with C lower-case characters, write a
program to print all the valid passwords of length L that can be formed
from those letters. The passwords must be printed in alphabetical order,
one per line.

PROBLEM NAME: passwd

INPUT FORMAT:

* Line 1: Two space-separated integers, L and C

* Line 2: C space-separated lower-case characters that are the set of
        characters from which to build the passwords

SAMPLE INPUT:

4 6
a t c i s w

INPUT DETAILS:

Passwords of length 4 chosen from the given six characters

OUTPUT FORMAT:

* Lines 1..?: Each output line contains a word of length L characters
        (and no spaces). The output lines must appear in alphabetical
        order.

SAMPLE OUTPUT:

acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
 */
package d10;

import java.io.*;
import java.util.*;

public class Passwd {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[] avail = new char[C]; 
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++){
			avail[i] = st.nextToken().charAt(0);
		}
		long startTime = System.nanoTime();
		Arrays.sort(avail);
		ArrayList<String> prevPas = new ArrayList<String>();
		
		int totPos = (1<<C);
		for (int i=0; i<(totPos); i++){
			String posPas = "";
			String binI = Integer.toBinaryString(i);
			if (countOnes(binI) != L){//we onyl want len L
				continue;
			}
			for (int j=0; j<C; j++){
				if((i&(1<<j)) != 0){
					posPas += avail[j];
				}
			}
//			if (posPas.length()==L && has1Vowel(posPas) && has2Cons(posPas) && !prevPas.contains(posPas)){
			if (has1Vowel2Cons(posPas) && !prevPas.contains(posPas)){
				prevPas.add(posPas);
			}
		}
		
		Collections.sort(prevPas);
		for (String s:prevPas){
			System.out.println(s);
		}
		
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	private static int countOnes(String str) {
		int ones = 0;
		for (int i=0; i<str.length(); i++){
			if (str.charAt(i) == '1'){
				ones++;
			}
		}
		return ones;
	}
	private static boolean has1Vowel2Cons(String posPas) {
		int v = 0;
		int c = 0;
		for (int i=0; i<posPas.length(); i++){
			if (posPas.charAt(i) != 'a' && posPas.charAt(i) != 'e' && posPas.charAt(i) != 'i' && posPas.charAt(i) != 'o' && posPas.charAt(i) != 'u'){
				c++;
			}
			if (posPas.charAt(i) == 'a' || posPas.charAt(i) == 'e' || posPas.charAt(i) == 'i' || posPas.charAt(i) == 'o' || posPas.charAt(i) == 'u'){
				v++;
			}
			
		}
		return c>1 && v>0;
	}
	public static int fact(int n){
		int ans = n;
		for (int i=2; i<n; i++){
			ans *= i;
		}
		return ans;
	}
}
