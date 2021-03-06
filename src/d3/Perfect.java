/*
 * The Perfect Cow
===============

For the 39th year in a row, Farmer John was named "Dairy Farmer of
the Year". The Dairy Association wants him to exhibit his most
perfect cow at the upcoming Cow Convention in Herbster, Wisconsin
on the frigid shores of Lake Superior.

FJ keeps up with scientific literature and knows that beauty is
actually a trend toward the average rather than the existence of
some superior trait. Thus, he wants to find his most average cow
and share her beauty with the other Dairy Farmers during the weekend
of revelry and partying at the convention.

Happily, each of the N*N cows (2 <= N <= 99; N odd) has her beauty
rating (1 <= R_ij <= 1,000) inscribed on a tag in her ear.

Cows aren't so good at math, so FJ lines them up into an N x N
square. He asks them to find the median cow in each row (the median
cow is the one whose  beauty number is bigger than or equal to half
the cows in her group and also smaller than or equal to half the
cows in her group -- the middle number of the group). From those N
medians, FJ then finds the median of those numbers and brings that
cow to the convention.

Given a set of N x N cows, find the beauty index of the most perfect
(average) cow.

PROBLEM NAME: perfect

INPUT FORMAT:

* Line 1: A single integer: N

* Lines 2..N+1: Line i+1 contains N space-separated integers that are
        the N beauty indices for row i of the cow square

SAMPLE INPUT:

5
1 5 3 9 5
2 5 3 8 1
6 3 5 9 2
8 8 3 3 2
5 4 4 4 4

INPUT DETAILS:

N=5, so there are 25 cows. They line up in a 5 x 5 square as shown.

OUTPUT FORMAT:

* Line 1: A single integer that is the index of the most perfect cow
        as described in the task.

SAMPLE OUTPUT:

4

OUTPUT DETAILS:

The medians of the rows are, respectively, 5, 3, 5, 3 and 4. The
median of those five values is 4.
 */
package d3;

import java.util.*;

public class Perfect {
	public static int findMedian(int[] arr){
		Arrays.sort(arr);
		return arr[arr.length/2];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] cows = new int[N][N];
		for (int r=0; r<N; r++){
			for (int c=0; c<N; c++){
				cows[r][c] = sc.nextInt();
			}
		}
		int[] medians = new int[N];
		for (int r=0; r<N; r++){
			medians[r] = findMedian(cows[r]);
//			System.out.println(medians[r]);
		}
		System.out.println(findMedian(medians));
		sc.close();
	}

}
