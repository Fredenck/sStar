/*
 * Binary Search
=============

Implement a binary search algorithm that returns the index of the
first occurrence of a number K, or -1 if it could not be found. You
will be supplied with a (sorted) list of N numbers (0 <= N <= 100,000).

For example, suppose you were given the following (sorted) array as
input.

2 3 4 4 9 11 12

Searching for 4 should return 2, searching for 9 should return 4, and
searching for 10 should return -1.

You will be asked to answer Q queries (1 <= Q <= 100,000), each of which
is a single number and should be answered as stated above.

PROBLEM NAME: binarysearch

INPUT FORMAT:

* Line 1: Two integers, N and Q.

* Line 2: N sorted integers. 

* Lines 3..Q+2: A single integer K on each line, representing a query.

SAMPLE INPUT:

7 2
2 3 4 4 9 11 12
9
10

OUTPUT FORMAT:

* Lines 1..Q: The index of the first occurrence of K in the supplied array,
        or -1 if not found.

SAMPLE OUTPUT:

4
-1

OUTPUT DETAILS:

The index of 9 is 4, and 10 is not in the array so the function returns -1.
 */
package d4;

import java.util.*;

public class BinarySearch {    
	public static int binS(int[] arr, int val){
		int low = 0;
		int high = arr.length-1;
		while (low<high){
			int mid = (low+high)/2;
			if (arr[mid] > val){
				high = mid-1;
			}else if(arr[mid] < val){
				low = mid+1;
			}else{//because there can be duplicates, set the new high as the place where we found it
//				high = mid;
				return mid;
			}
		}
		if (arr[low] != val){
			return -1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		if (N==0){
		    for (int i=0; i<Q; i++){
		        System.out.println(-1);
		    }
		}else{
			int[] arr = new int[N];
			for (int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}
			for (int i=0; i<Q; i++){
				int q = sc.nextInt();
				int idx = binS(arr, q);
	//			int idx = binaryS(arr, 0, N-1, q);
				//traverses backwards when there are duplicates
				while (idx-1 >= 0 && idx<N && arr[idx-1] == arr[idx]){
					idx--;
				}
				System.out.println(idx);
			}
		}
		sc.close();
	}
}
// 