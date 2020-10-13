/*
 * Time Cards
==========

Farmer John wanted to improve farm productivity, so his cows now
get extra hay if they spend more time at a milking machine. To
implement this plan, he has instituted the use of time cards for
each of the N (1 <= N <= 145) cows conveniently numbered 1..N. When
a cow starts at a milking machine, she enters the start time on the
master time card. Likewise, when she leaves, she notes that on the
master time card, as well. FJ is fortunate to have enough milking
machines that he can milk every cow at the same time.

The time entries are typed into a computer file where each line
includes a cow number C (1 <= C <= N), a keyword ('START' or 'STOP'),
and the time expressed as two space-separated integers HH and MM
(0 <= HH <= 23; 0 <= MM <= 59). Cows never stay at the machine past
midnight. The timecard file is complete in the sense that every
cow's START entry contains a corresponding STOP entry later in the
input file.

Calculate the total time each cow spends at the milking machine.

By way of example, consider a time card file for just two cows. The
file includes not only the number of cows but also the total number
of time card entries, Nlines (1 <= Nlines <= 1,458).

2 6
1 START 9 0
2 START 9 30
1 STOP 10 0
2 STOP 10 15
1 START 17 0
1 STOP 17 42

Cow 1 spent times 9:00-10:00 and 17:00-17:42 at the machine for a
total of one hour and 42 minutes (1:42). Cow 2 spent time 9:30-10:15
at the machine, for a total of 45 minutes.

PROBLEM NAME: timecards

INPUT FORMAT:

* Line 1: Two space-separated integers: N and Nlines

* Lines 2..Nlines+1: Each line contains four space-separated entities:
        C, keyword, HH, and MM

SAMPLE INPUT:
2 6
1 START 9 0
2 START 9 30
1 STOP 10 0
2 STOP 10 15
1 START 17 0
1 STOP 17 42

OUTPUT FORMAT:

* Lines 1..N: Line i contains two space-separated integers that are
        respectively the number of hours and minutes that cow i spends
        at the milking machine. Of course, the minutes value never
        exceeds 59.

SAMPLE OUTPUT:
1 42
0 45
 */
package d14;

import java.io.*;
import java.util.*;

public class Timecards {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Shifts[] sh = new Shifts[N];
		int[] cowTimes = new int[cows];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			String keyword = st.nextToken();
			int HH = Integer.parseInt(st.nextToken());
			int MM = Integer.parseInt(st.nextToken());
			sh[i] = new Shifts(c,keyword,HH,MM);
		}
		
		for (int i=1; i<cows+1; i++){
			int start = 0;
			for (int j=0; j<N; j++){
				if (sh[j].c==i){
					if (sh[j].keyword.equals("START")){
						start = sh[j].HH*60+sh[j].MM;
					}else{
						cowTimes[sh[j].c-1] += (sh[j].HH*60+sh[j].MM)-start;
					}
				}
			}
		}
		
		for (int i=0; i<cows; i++){
			int minutes = cowTimes[i];
			int hours = 0;
			while (minutes>=60){
				hours++;
				minutes -= 60;
			}
			System.out.println(hours+" "+minutes);
		}
		
		br.close();
	}
	public static class Shifts{
		int c;
		String keyword;
		int HH;
		int MM;
		
		public Shifts(int aa, String bb, int cc, int dd){
			c=aa;
			keyword=bb;
			HH=cc;
			MM=dd;
		}
	}
}
