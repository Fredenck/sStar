/*
 * Calf Flac
=========

It is said that if you give an infinite number of cows an infinite 
number of heavy-duty laptops (with very large keys), that they will 
ultimately produce all the world's great palindromes. Your job will 
be to detect these bovine beauties.

Ignore punctuation, whitespace, numbers, and case when testing for 
palindromes, but keep these extra characters around so that you can 
print them out as the answer; just consider the letters 'A-Z' and 
'a-z'.

Find any largest palindrome in a string no more than 20,000 
characters long. The largest palindrome is guaranteed to be at most 
2,000 characters long before whitespace and punctuation are removed.

PROGRAM NAME: calfflac

INPUT FORMAT:

A file with no more than 20,000 characters. The file has one or 
more lines. No line is longer than 80 characters (not counting the 
newline at the end).

SAMPLE INPUT:

Confucius say: Madam, I'm Adam.

OUTPUT FORMAT:

The first line of the output should be the length of the longest 
palindrome found. The next line or lines should be the actual text 
of the palindrome (without any surrounding white space or 
punctuation but with all other characters) printed on a line (or 
more than one line if newlines are included in the palindromic 
text). If there are multiple palindromes of longest length, output 
the one that appears first.

SAMPLE OUTPUT:

11
Madam, I'm Adam
 */
package d5;

import java.io.*;


public class Calfflac {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] words = new char[35];
		int len = 0;
		int palLen = 0;
		String pal = null;
		String posPal = null;
		
		while(br.ready()){
			words[len] = (char) br.read();
			len++;
		}
		String s = new String(words, 0, len);
		//odd pal
		for(int i = 0; i < s.length(); i++){
			//palindrome centered at i
			if(alphabetical(s.charAt(i))){
				//possible pal centered at i
				posPal = findPal(s,i,i);
				//use alphabetCount to count alphabetical char and use that for len
				if(posPal != null && alphabetCount(posPal) > palLen){
					palLen = alphabetCount(posPal);
					pal = posPal;
				}
			}
		}
		System.out.println(pal);
		//even pal
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(alphabetical(c)){
				//use nextChar instead of i+1 when s.charAt(i+1) is not alphabetical
				int next = nextChar(s,c,i+1);
				if(next != -1){
					posPal = findPal(s,i,next);
					if(posPal != null && alphabetCount(posPal) > palLen){
						palLen = alphabetCount(posPal);
						pal = posPal;
					}
				}
			}
		}
		System.out.println(palLen);
		System.out.println(pal);
	}
	//-1 if not found, idx if found
	private static int nextChar(String s, char c, int start) {
		for(int i = start; i < s.length(); i++){
			if(s.charAt(i) == c)
				return i;
			else if(alphabetical(s.charAt(i)))
				return -1;
		}
		return -1;
	}
	//to count actual length of pal with only alphabeticals
	private static int alphabetCount(String s) {
		int ct = 0;
		for(int i = 0; i < s.length(); i++){
			if(alphabetical(s.charAt(i)))
				ct ++;
		}
		return ct;
	}
	
	private static String findPal(String s, int left, int right) {
		//first and last is the previous two ranges
		//left and right are the possible two new ranges
		int first = left;
		int last = right;
		//go until end of String, skipping any non-alphabetical
		while(left >=0 && right <= s.length()-1){
			if(!alphabetical(s.charAt(left))){
				left--; 
				continue;
			}
			if(!alphabetical(s.charAt(right))){
				right++;
				continue;
			}
			//when l and r are dif, exit
			if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
				return s.substring(first,last+1);				
			}
			else{
				first = left;
				last = right;
				left--;
				right++;
			}
		}
		return s.substring(first,last+1);
	}
	
	private static boolean alphabetical(char c) {		
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
}
