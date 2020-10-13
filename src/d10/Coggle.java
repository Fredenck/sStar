/*
 * Coggle
======

Like everyone else on their vacation, the cows play the cow version of the
word game called Boggle: Coggle. It's a similar game where 25
letter dice are rolled into a matrix like this one:

           Z C C D X
           K Q M N B
           U O W Z Y
           F C O I J
           P A Q Z T

Words are made (and thus points scored) by starting at some letter
and proceeding to one of its (as many as) eight neighbors, etc.
until the successive letters spell out a word from a dictionary

In the matrix above, the lower 'C' can be used to form the words
"CAP", "COW", and "COOK" (but not "COD" or "PACK"). The complete
list of dictionary words for the above square is: "CAP", "COOK",
"COW", "OWN", "WIT", "WOO", "ZOO", and "ZOOM".

Help Bessie see how good she can do. Read in five rows of five
letters that represent the dice and see how many words from the
dictionary can be formed.  Don't use any given die's letter twice.

Count the number of words that can be formed (a number that might
well be smaller than the number of ways a word a can be formed since
words might be formed in more than one way).

PROBLEM NAME: coggle

INPUT FORMAT:

* Lines 1..5: Line i contains five space-separated upper-case letters
        that are row i
        
* Line 6..?: Each line will contain one word in the dictionary.
	The dictionary is sorted in alphabetic order and has fewer 
	than 25,000 words; each word is no longer than 20 characters.

SAMPLE INPUT:

Z C C D X
K Q M N B
U O W Z Y
F C O I J
P A Q Z T
AARGH
AARON
ABABA
ABACK
ABANDON
ABANDONED
[and so on....]

OUTPUT FORMAT:

* Line 1: A single integer that is the number of words in the
        dictionary that can be formed using the described rules

SAMPLE OUTPUT:

8
 */
package d10;

import java.io.*;
import java.util.*;

public class Coggle {
	
	static char[][] mat;
	static int[][] visited;
	static boolean found = false;
	static int[] dx = {1, 0, 1,-1,-1, -1, 0, 1};
	static int[] dy = {0, 1, 1, 0, 1, -1,-1,-1};
	static int ct = 0;
	static ArrayList<String> wordsFound;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		mat = new char[5][5];
		for (int i=0; i<5; i++){
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j=0; j<5; j++){
				mat[i][j] = st.nextToken().charAt(0);
			}
		}

		wordsFound = new ArrayList<String>();
		
		visited = new int[5][5];
		while (br.ready()){
			String word = br.readLine();
			String word2 = word;
			found = false;
			for (int r=0; r<5; r++){
				for (int c=0; c<5; c++){
					//this pos has the first letter of the word we want to find
					// "HELLO"->"ELLO"
					if (mat[r][c]==word2.charAt(0) && !found && !wordsFound.contains(word)){
						rec(word,word2.substring(1),r,c);
					}
				}
			}
			
		}
		
		System.out.println(ct);
		br.close();
	}

	private static void rec(String oWord, String word, int r, int c) {
		if (word.length()==0 && !found){
			found = true;
			ct++;
			wordsFound.add(oWord);
			System.out.println(oWord);
			return;
		}
		//word not there
		if(word.length()==0){
			return;
		}
		if (found){
			return;
		}
		visited[r][c] = 1;
		for (int i=0; i<8; i++){
			int nr = r+dx[i];
			int nc = c+dy[i];
			if (nr<0 || nc<0 || nr>=mat.length || nc>=mat[0].length){
				continue;
			}
			if (mat[nr][nc]==word.charAt(0) && visited[nr][nc]==0){
				rec(oWord,word.substring(1),nr,nc);				
			}
		}
		visited[r][c] = 0;
		return;
		
	}
}