/*
 * Counting Haybales
=================

Farmer John has just arranged his N haybales (1 <= N <= 100,000) at 
various points along the one-dimensional road running across his 
farm. To make sure they are spaced out appropriately, please help him 
answer Q queries (1 <= Q <= 100,000), each asking for the number of 
haybales within a specific interval along the road.

PROBLEM NAME: haybales2

INPUT FORMAT:

The first line contains N and Q.

The next line contains N distinct integers, each in the range 
0...1,000,000,000, indicating that there is a haybale at each of 
those locations.

Each of the next Q lines contains two integers A and B (0 <= A <= B 
<= 1,000,000,000) giving a query for the number of haybales between A 
and B, inclusive.

OUTPUT FORMAT:

You should write Q lines of output. For each query, output the number 
of haybales in its respective interval.

SAMPLE INPUT:

4 6
3 2 7 5
2 3
2 4
2 5
2 7
4 6
8 10

SAMPLE OUTPUT:

2
2
3
4
1
0
 */
package d4;

import java.util.*;

public class Haybales2 {
	
	static int upperBound(int[] a, int low, int high, int element) {
	    while (low < high) {
	        int middle = low + (high - low) / 2;
	        if (a[middle] > element) {
	            high = middle;
	        } else {
	            low = middle + 1;
	        }
	    }
	    return low;
	}
	
	static int lowerBound(int[] a, int low, int high, int element) {
	    while (low < high) {
	        int middle = low + (high - low) / 2;
	        if (element > a[middle]) {
	            low = middle + 1;
	        } else {
	            high = middle;
	        }
	    }
	    return low;
	}
	
	//binary search for b, position of that is how many are before it
	//same for a
	//b-a will be how many are between it 
	public static int haybalesBefore(int a, int b, int arr[]){
		return upperBound(arr, 0, arr.length, b) - lowerBound(arr, 0, arr.length, a);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		int[] haybales = new int[N];
		for (int i=0; i<N; i++){
			haybales[i] = sc.nextInt();
		}
		Arrays.sort(haybales);
		
		for (int i=0; i<Q; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
//			System.out.println(Arrays.binarySearch(haybales, a));
			System.out.println(haybalesBefore(a,b, haybales));
		}
		sc.close();
	}
}
