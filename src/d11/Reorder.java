/*
 * Reordering the Cows
===================

Farmer John's N cows (1 <= N <= 100), conveniently numbered 1..N, are
standing in a row.  Their ordering is described by an array A, where A(i)
is the number of the cow in position i.  Farmer John wants to rearrange
them into a different ordering for a group photo, described by an array B,
where B(i) is the number of the cow that should end up in position i.

For example, suppose the cows start out ordered as follows:

A = 5 1 4 2 3

and suppose Farmer John would like them instead to be ordered like this:

B = 2 5 3 1 4

To re-arrange themselves from the "A" ordering to the "B" ordering, the
cows perform a number of "cyclic" shifts.  Each of these cyclic shifts
begins with a cow moving to her proper location in the "B" ordering,
displacing another cow, who then moves to her proper location, displacing
another cow, and so on, until eventually a cow ends up in the position
initially occupied by the first cow on the cycle.  For example, in the
ordering above, if we start a cycle with cow 5, then cow 5 would move to
position 2, displacing cow 1, who moves to position 4, displacing cow 2,
who moves to position 1, ending the cycle.  The cows keep performing cyclic
shifts until every cow eventually ends up in her proper location in the "B"
ordering.  Observe that each cow participates in exactly one cyclic shift,
unless she occupies the same position in the "A" and "B" orderings.

Please compute the number of different cyclic shifts, as well as the length
of the longest cyclic shift, as the cows rearrange themselves.

PROBLEM NAME: reorder

INPUT FORMAT:

* Line 1: The integer N.

* Lines 2..1+N: Line i+1 contains the integer A(i).

* Lines 2+N..1+2N: Line 1+N+i contains the integer B(i).

SAMPLE INPUT:

5
5
1
4
2
3
2
5
3
1
4

OUTPUT FORMAT:

* Line 1: Two space-separated integers, the first giving the number of
        cyclic shifts and the second giving the number cows involved
        in the longest such shift.  If there are no cyclic shifts,
        output -1 for the second number.

SAMPLE OUTPUT:

2 3

OUTPUT DETAILS:

There are two cyclic shifts, one involving cows 5, 1, and 2, and the other
involving cows 3 and 4.
 */
package d11;

import java.io.*;
import java.util.*;

public class Reorder {
	
	public static void main(String[] args) throws IOException {
//		File file = new File("helpcross");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		for (int i=0; i<N; i++){
			a[i] = Integer.parseInt(br.readLine());
		}
		int[] b = new int[N];
		for (int i=0; i<N; i++){
			b[i] = Integer.parseInt(br.readLine())-1;
		}
		
		ArrayList<Integer> involved= new ArrayList<Integer>();//cows who are in cyclic
		int maxInvolved = -1;
		int totCyclic = 0;
		ArrayList<Integer> particip = new ArrayList<Integer>();
		ArrayList<Integer> partIdx = new ArrayList<Integer>();
		boolean found = false;
		for (int i=0; i<N; i++){
			if (particip.contains(a[i]) || partIdx.contains(b[i])){//cur cow in other cycle
				continue;
			}
			int ni = i;
			while(!involved.contains(a[ni])){
				involved.add(a[ni]);
				particip.add(a[ni]);
				partIdx.add(b[ni]);
				ni = idx(b,a[ni]-1);
			}			
			
			if (involved.size()>maxInvolved){
				maxInvolved = involved.size();
			}
			if (involved.size()>=2){//cycle exists
				totCyclic++;
				found = true;
			}
			involved.clear();
		}
		if (found){
			System.out.println(totCyclic+" "+maxInvolved);			
		}else{
			System.out.println("0 -1");
		}
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
	public static int idx(int[] arr, int ele){
		for (int i=0; i<arr.length; i++){
			if (arr[i]==ele){
				return i;
			}
		}
		return -1;
	}
}