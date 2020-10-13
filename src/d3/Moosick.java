/*
 * Moo Sick
========

Everyone knows that cows love to listen to all forms of music.  Almost all
forms, that is -- the great cow composer Wolfgang Amadeus Moozart
once discovered that a specific chord tends to make cows rather ill.  This
chord, known as the ruminant seventh chord, is therefore typically avoided
in all cow musical compositions.

Farmer John, not knowing the finer points of cow musical history, decides
to play his favorite song over the loudspeakers in the barn.  Your task is
to identify all the ruminant seventh chords in this song, to estimate how
sick it will make the cows.

The song played by FJ is a series of N (1 <= N <= 20,000) notes, each an
integer in the range 1..88.  A ruminant seventh chord is specified by a
sequence of C (1 <= C <= 10) distinct notes, also integers in the range
1..88.  However, even if these notes are transposed (increased or decreased
by a common amount), or re-ordered, the chord remains a ruminant seventh
chord!  For example, if "4 6 7" is a ruminant seventh chord, then "3 5 6"
(transposed by -1), "6 8 9" (transposed by +2), "6 4 7" (re-ordered), and
"5 3 6" (transposed and re-ordered) are also ruminant seventh chords.

A ruminant seventh chord is a sequence of C consecutive notes satisfying
the above criteria. It is therefore uniquely determined by its starting
location in the song. Please determine the indices of the starting
locations of all of the ruminant seventh chords.

PROBLEM NAME: moosick

INPUT FORMAT:

* Line 1: A single integer: N.

* Lines 2..1+N: The N notes in FJ's song, one note per line.

* Line 2+N: A single integer: C.

* Lines 3+N..2+N+C: The C notes in an example of a ruminant seventh
        chord.  All transpositions and/or re-orderings of these notes
        are also ruminant seventh chords.

SAMPLE INPUT:

6
1
8
5
7
9
10
3
4
6
7

INPUT DETAILS:

FJ's song is 1,8,5,7,9,10.  A ruminant seventh chord is some
transposition/re-ordering of 4,6,7.

OUTPUT FORMAT:

* Line 1: A count, K, of the number of ruminant seventh chords that
        appear in FJ's song.  Observe that different instances of
        ruminant seventh chords can overlap each-other.

* Lines 2..1+K: Each line specifies the starting index of a ruminant
        seventh chord (index 1 is the first note in FJ's song, index N
        is the last).  Indices should be listed in increasing sorted
        order.

SAMPLE OUTPUT:

2
2
4

OUTPUT DETAILS:

Two ruminant seventh chords appear in FJ's song (and these occurrences
actually overlap by one note).  The first is 8,5,7 (transposed by +1 and
reordered) starting at index 2, and the second is 7,9,10 (transposed by +3)
starting at index 4.
 */
package d3;

import java.util.*;

public class Moosick {
	//true if same elemetns, dif order
	public static boolean compareArrays(int[] a1, int[] a2) {
		//int[] to Integer[]
		Integer[] aInteger1 = new Integer[a1.length];
		Integer[] aInteger2 = new Integer[a2.length];
		for (int i=0; i<a1.length; i++){
			aInteger1[i] = a1[i];
			aInteger2[i] = a2[i];
		}
	    HashSet<Integer> set1 = new HashSet<Integer>(Arrays.asList(aInteger1));
	    HashSet<Integer> set2 = new HashSet<Integer>(Arrays.asList(aInteger2));
	    return set1.equals(set2);
	}
	
	public static int choose(int total, int choose){
	    if(total < choose)
	        return 0;
	    if(choose == 0 || choose == total)
	        return 1;
	    return choose(total-1,choose-1)+choose(total-1,choose);
	}
	
	public static int[] differences(int[] arr){
		int[] d = new int[choose(arr.length, 2)];
		int dC = 0;
		
		for (int i=0; i<arr.length; i++){
			for (int j=i+1; j<arr.length; j++){
				d[dC] = Math.abs(arr[i]-arr[j]);
				dC++;
			}
		}
		return d;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] song = new int[n];
		for (int i=0; i<n; i++){
			song[i] = sc.nextInt();
		}
		
		int c = sc.nextInt();
		int[] ruminant = new int[c];
		for (int i=0; i<c; i++){
			ruminant[i] = sc.nextInt();
		}
		
		int[] rumDif = differences(ruminant);
//		System.out.println(Arrays.toString(rumDif));
		int[] chord = new int[c];
		
		int totRums = 0;
		//keeps track of all the ruminants
		int[] allRums = new int[n];
		//special counter for allRums
		int aRC = 0;
		for (int i=0; i<n-c+1; i++){
			//get chord of len c
			for (int j=0; j<c; j++){
				chord[j] = song[i+j];
			}
			//see the differences between them
			int[] posRumDif = differences(chord);
			//if same interval, then it's a ruminant
			if (compareArrays(posRumDif, rumDif)){
				totRums++;
				allRums[aRC] = i+1;//bc index
				aRC++;
			}
		}
		System.out.println(totRums);
		//because i made allRums' size up to the case when the song is all rums
		for (int a:allRums){
			if (a==0){
				continue;
			}
			System.out.println(a);
		}
		sc.close();
	}

}
