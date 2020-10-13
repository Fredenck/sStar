/*
 * Cow Line
========

Farmer John's N cows (conveniently numbered 1..N) are forming a
line. The line begins with no cows and then, as time progresses,
one by one, the cows join the line on the left or right side. Every
once in a while, some number of cows on the left or right side of
the line all leave the line to go graze in their favorite pasture.

FJ has trouble keeping track of all the cows in the line. Please
help him.

The cows enter the line in numerical order 1..N, and once a cow
leaves the line she never re-enters it. Your program will be given
S (1 <= S <= 100,000) input specifications; each appears on a single
line and is one of two types:

   * A cow enters the line (a parameter indicates whether on the
     left or right).

   * K cows leave the line from the left or right side (supplied
     parameters define both the number of cows and which side).

Input lines never request an operation that can not be performed.

After all the input lines have been procssed, your program should
print the cows in the line in order from left to right. The final
line is guaranteed to be non-empty at the end of the input
specifications.

PROBLEM NAME: cline

INPUT FORMAT:
* Line 1: A single integer: S

* Lines 2..S+1: Line i+1 contains query i in one of four formats:
   * A L -- a cow arrives on the Left of the line
   * A R -- a cow arrives on the Right of the line
   * D L K -- K cows depart the Left side of the line
   * D R K -- K cows depart the Right side of the line

SAMPLE INPUT:

10
A L
A L
A R
A L
D R 2
A R
A R
D L 1
A L
A R

OUTPUT FORMAT:

* Lines 1..??: Print the numbers of the cows in the line in order from
        left to right, one number per line.

SAMPLE OUTPUT:
7
2
5
6
8

OUTPUT DETAILS:
Input    Resulting Cow Line
A L      1
A L      2 1
A R      2 1 3
A L      4 2 1 3
D R 2    4 2
A R      4 2 5
A R      4 2 5 6
D L 1    2 5 6
A L      7 2 5 6
A R      7 2 5 6 8
 */
package d14;

import java.io.*;
import java.util.*;

public class Cline {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
		int idx = 1;
		for (int i=0; i<N; i++){
			int mag = 1;
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			char come = st.nextToken().charAt(0);
			char d = st.nextToken().charAt(0);
			if (come=='D'){
				mag = Integer.parseInt(st.nextToken());
			}
			
			if (come=='A'){
				if (d=='L'){
					deq.addFirst(idx);
				}else{
					deq.addLast(idx);
				}
			}else{
				for (int j=0; j<mag; j++){
					if (d=='L'){
						deq.removeFirst();
					}else{
						deq.removeLast();
					}
				}
				idx--;//we don't go to next num if we are removing
			}
			idx++;
		}
		for (int a:deq){
			System.out.println(a);
		}
		
		br.close();
	}
}
