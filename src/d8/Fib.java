/*
 * Fibonacci
=========

Fibonacci numbers are a sequence of integers as shown below
1 1 2 3 5 8 13 ...

Except for the first two, each number is the sum of the previous two numbers.

For a given number N, calculate and print the Nth number in the fibonacci sequence.

PROBLEM NAME: fib

INPUT FORMAT:

* Line 1: A single integer: N

SAMPLE INPUT:

7

OUTPUT FORMAT:

* Line 1: A single integer: Nth number in the fibonacci sequence

SAMPLE OUTPUT:

13
 */
package d8;

import java.io.*;

public class Fib {
	
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fib(N));
		
		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}

	public static int fib(int n) {
		if (n==1 || n==2){
			return 1;
		}
		return fib(n-1)+fib(n-2);
	}
}
