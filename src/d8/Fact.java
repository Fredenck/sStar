/*
 * Factorial
=========

For a given number N, calculate and print N!

PROBLEM NAME: fact

INPUT FORMAT:

* Line 1: A single integer: N

SAMPLE INPUT:

5

OUTPUT FORMAT:

* Line 1: A single integer: value of N!

SAMPLE OUTPUT:

120
 */
package d8;

import java.io.*;

public class Fact {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fact(N));
		
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}

	public static int fact(int n) {
		if (n==0){
			return 1;
		}
		return n*fact(n-1);
	}
}
