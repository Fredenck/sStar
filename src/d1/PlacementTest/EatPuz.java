/*
 * The Eating Puzzle
=================

Bessie is on a diet where she can eat no more than C (10 <= C <= 35,000)
calories per day. Farmer John is teasing her by putting out B (1 <= B <= 21)
buckets of feed, each with some (potentially non-unique) number of calories
(range: 1..35,000). Bessie has no self-control: once she starts on a
feed bucket, she consumes all of it.

Bessie is not so good at combinatorics. Determine the optimal combination of
feed buckets that gives Bessie as many calories without exceeding the limit C.

As an example, consider a limit of 40 calories and 6 buckets with
7, 13, 17, 19, 29, and 31 calories. Bessie could eat 7 + 31 = 38 calories
but could eat even more by consuming three buckets: 7 + 13 + 19 = 39 calories.
She can find no better combination.

PROBLEM NAME: eatpuz

INPUT FORMAT:

* Line 1: Two space-separated integers: C and B

* Line 2: B space-separated integers that respectively name the number of calories
in bucket 1, 2, etc.

SAMPLE INPUT:

40 6
7 13 17 19 29 31

OUTPUT FORMAT:

* Line 1: A single line with a single integer that is largest number of calories
Bessie can consume and still stay on her diet.

SAMPLE OUTPUT:

39
 */
package d1.PlacementTest;
//Error: I reuse elements (e.g. 7+19=26, 7+26=33 [I cannot use 7 twice])
import java.util.*;

public class EatPuz {
	
	public static int max(int[] arr){
		int max = arr[0];
		for (int i=1; i<arr.length; i++){
			if (max<arr[i]){
				max = arr[i];
			}
		}
		return max;
	}	
	
	public static int min(int[] arr){
		int min = arr[0];
		for (int i=1; i<arr.length; i++){
			if (min>arr[i]){
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int[] sum1(int maximum, int[] arr){
		ArrayList<Integer> sums = new ArrayList<Integer>();
		int sum;
		
		for (int i=0; i<arr.length; i++){
			for (int j=i+1; j<arr.length; j++){
				sum = arr[i]+arr[j];
				if (!sums.contains(sum) && sum<=maximum){
					sums.add(sum);
				}
			}
		}
		int[] sums2 = new int[sums.size()];
		for (int i=0; i<sums.size(); i++){
			sums2[i] = (int) sums.get(i);
		}
		return sums2;
	}
	
	public static int[] sum2(int maximum, int[] arr1, int[] arr2){
		ArrayList<Integer> sums = new ArrayList<Integer>();
		int sum;
		
		for (int i=0; i<arr1.length; i++){
			for (int j=0; j<arr2.length; j++){
				if (isIn(arr2[j]-arr1[i], arr1)){
					continue;
				}
				sum = arr1[i]+arr2[j];
				if (!sums.contains(sum) && sum<=maximum){
					sums.add(sum);
				}
			}
		}
		return ArrayListToArray(sums);
	}
	
	public static boolean isIn(int a, int[] arr){
		for (int q:arr){
			if (a==q){
				return true;
			}
		}
		return false;
	}
	
	public static int[] ArrayListToArray(ArrayList<Integer> arr){
		int[] arr2 = new int[arr.size()];
		for (int i=0; i<arr.size(); i++){
			arr2[i] = (int) arr.get(i);
		}
		return arr2;
	}
	
	public static int[] combine(int[] a1, int[] a2){
		int[] atot = new int[a1.length+a2.length];
		for (int i=0; i<a1.length; i++){
			if (!isIn(a1[i], atot)){
				atot[i] = a1[i];
			}
		}
		for (int i=a1.length; i<a1.length+a2.length; i++){
			if (!isIn(a2[i-a1.length], atot)){
				atot[i] = a2[i-a1.length];
			}
		}
		return atot;
	}
	
	public static boolean sumExists(int maximum, int[] arr){
		int[] farr = sum1(maximum, arr);
		for (int i=0; i<arr.length; i++){
			farr = combine(farr, sum2(maximum, arr, farr));
			if (isIn(9531,farr)){
				System.out.println();
			}
		}
		//9532 12
		//8452 2877 8038 2783 1340 4690 1083 4093 5688 1285 2603 7912
//		System.out.println(Arrays.toString(farr));
		return maximum==max(farr);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cal = Integer.valueOf(sc.nextInt());
		int bucketNum = Integer.valueOf(sc.nextInt());
		int[] buckets = new int[bucketNum];
		int next;
		for (int i=0; i<bucketNum; i++){
			next = sc.nextInt();
			if (next>cal){
				next = 0;
			}
			buckets[i] = Integer.valueOf(next);
		}
//		System.out.println(cal);
//		System.out.println(bucketNum);
//		System.out.println(Arrays.toString(buckets));
		for (int max=cal; max>=min(buckets); max--){
			if (sumExists(max, buckets)){
				System.out.println(max);
				break;
			}
		}
		sc.close();
	}

}
