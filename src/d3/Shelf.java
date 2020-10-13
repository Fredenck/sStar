/*
 * Bookshelf
=========

Farmer John recently bought a bookshelf for cow library, but the
shelf is getting filled up quite quickly, and now the only available
space is at the top.

Each of the N cows (1 <= N <= 20,000) has some height of H_i (1 <=
H_i <= 10,000) and a total height summed across all N cows of S.
The bookshelf has a height of B (1 <= B <= S < 2,000,000,007).

To reach the top of the bookshelf taller than the tallest cow, one
or more of the cows can stand on top of each other in a stack, so
that their total height is the sum of each of their individual
heights. This total height must be no less than the height of the
bookshelf. Since more cows than necessary in the stack can be
dangerous, your job is to find the set of cows that produces a stack
of the smallest number of cows possible such that the stack can
reach the bookshelf.

PROBLEM NAME: shelf

INPUT FORMAT:

* Line 1: Two space-separated integers: N and B

* Lines 2..N+1: Line i+1 contains a single integer: H_i

SAMPLE INPUT:

6 40
6
18
11
13
19
11

INPUT DETAILS:

Six cows; bookshelf height 40. Cow heights fall in the range 6..19.

OUTPUT FORMAT:

* Line 1: A single integer representing the size of the smallest set
        of cows that can reach the bookshelf.

SAMPLE OUTPUT:

3

OUTPUT DETAILS:

One way to reach 40 with 3 cows is 18+11+13; many others exist
 */
package d3;

import java.util.*;

public class Shelf {
    public static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        }  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r);
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		int[] cows=  new int[N];
		for (int i=0; i<N; i++){
			cows[i] = sc.nextInt();
		}
		sort(cows, 0, N-1);
		
		int sum=0;
//		System.out.println(Arrays.toString(cows));
		for (int i=N-1; i>=0; i--){
			sum += cows[i];
			if (sum>=B){
//				System.out.println(sum);
				System.out.println((N)-i);
				break;
			}
		}
		sc.close();
	}

}
