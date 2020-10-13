/*
 * One More than Zero
==================

Given an integer N output all N-digit binary numbers that has 
1's more than 0's.

PROBLEM NAME: onezero

INPUT FORMAT:

* Line 1: A single integer: N (0 < N <= 16)

SAMPLE INPUT:

4

OUTPUT FORMAT:

* Line 1..?: One number in each line that has 1's more than 0's.

The numbers have to be in increasing order. The last line has 
the number of binary numbers that has 1's more than 0's.

SAMPLE OUTPUT:

0111
1011
1101
1110
1111
5
 */
package d10;

import java.io.*;

public class Onezero {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long startTime = System.nanoTime();
		
		int ct = 0;
		for (int i=0; i<(1<<N); i++){
			String num = Integer.toBinaryString(i);
			while(num.length()<N){
				num = "0"+num;//leading zeroes
			}
			int ones = 0;
			int twos = 0;
			for (int j=0; j<N; j++){
//				if (i&(1<<j) != 0){
//					
//				}
				if (num.charAt(j) == '1'){
					ones++;
				}else{
					twos++;
				}
			}
			if (ones>twos){
				System.out.println(num);
				ct++;
			}
		}
		System.out.println(ct);

		
		
		
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
}
