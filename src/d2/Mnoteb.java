/*
 * Music Notes
===========

FJ is going to teach his cows how to play a song. The song consists
of N (1 <= N <= 100) notes, and the i-th note lasts for B_i (1 <=
B_i <= 100) beats. The cows will begin playing the song at time 0;
thus, they will play note 1 from time 0 to time B_1 - 1, note 2
fromtime B_1 to time B_1 + B_2 - 1, etc.

The cows have lost interest in the song, as they feel that it is
long and boring. Thus, to make sure his cows are paying attention,
FJ asks them Q (1 <= Q <= 1,000) questions of the form, "During the
beat at time T_i (0 <= T_i < length of song), which note should you be
playing?" The cows need your help to answer these questions.

By way of example, consider a song with these specifications: note
1 for length 2, note 2 for length 1, and note 3 for length 3:

NOTES    1   1   2   3   3   3
       +---+---+---+---+---+---+
TIME     0   1   2   3   4   5

PROBLEM NAME: mnoteb

INPUT FORMAT:

* Line 1: Two space-separated integers: N and Q

* Lines 2..N+1: Line i+1 contains a single integer: B_i

* Lines N+2..N+Q+1: Line N+i+1 contains a single integer: T_i

SAMPLE INPUT:

3 5
2
1
3
2
3
4
0
1

INPUT DETAILS:

The song has 3 notes, with lengths 2, 1, and 3. FJ has 5 queries.

OUTPUT FORMAT:

* Lines 1..Q: Line i contains the a single integer that is note the
        cows should be playing at time T_i

SAMPLE OUTPUT:

2
3
3
1
1

OUTPUT DETAILS:

As per the chart above.
 */
package d2;

import java.util.*;

public class Mnoteb {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] song = new int[N*100];//N notes, each with a max of 100 beats
		
		int prevNoteTimes = 0;
		for (int i=1; i<N+1; i++){//notes
			int noteTimes = sc.nextInt();
			for (int j=0; j<noteTimes; j++){//length of the note
				song[j+prevNoteTimes] = i;
				System.out.println(Arrays.toString(song));
			}
			prevNoteTimes += noteTimes;
		}
		
		for (int i=0; i<Q; i++){
			int question = sc.nextInt();
			System.out.println(song[question]);
		}
		sc.close();
	}

}
