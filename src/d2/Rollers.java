/*
 * Oh Those Rollers
================

Farmer John has installed a new winch that gives him mechanical
advantage when lifting bales of hay into the barn. The winch was
manufactured by the Rube Goldberg Winch Company and has way too
many rollers to make any sense at all. The winch has a huge steel
plate with a number of rollers whose ultimate source of power is
the drive-roller whose location FJ has denoted as the origin (0,0).
This roller drives a roller that drives another roller, etc. etc.
until the final roller is driven. FJ is trying to find that final
roller and wants to know which one it is.

FJ has recorded the x_i,y_i (-5,000 <= x_i <= 5,000; -5,000 <= y_i
<= 5,000) coordinates and the radius r_i (3 <= r_i <= 1024) of each
of the N (2 <= N <= 1080) rollers. Tell him the x,y coordinate of
the last roller in the chain (the roller that is driven but drives
no other roller). Every roller except the drive-roller is driven
by exactly one other roller.

PROBLEM NAME: rollers

INPUT FORMAT:

* Line 1: A single integer: N

* Lines 2..N+1: Line i+1 describes roller i with three space separated
        integers: x_i, y_i, and r_i

SAMPLE INPUT:

3
0 0 30
30 40 20
-15 100 55

INPUT DETAILS:

Three rollers. First is at the origin with radius 30. It drives the roller
at (30,40) whose radius is 20. That roller in turn drives the third roller
located at (-15,100) with radius 55.

OUTPUT FORMAT:

* Line 1: A single line with two space-separated integers that are
        respectively the x,y coordinates of the last roller in the
        chain of driven rollers.

SAMPLE OUTPUT:

-15 100
 */
package d2;

import java.util.*;

public class Rollers {
	
	public static int calcReq(int x1, int x2, int y1, int y2){
		int xDifSq = (int) Math.pow((Math.abs(x2-x1)),2);
		int yDifSq = (int) Math.pow((Math.abs(y2-y1)),2);
		return (int) Math.sqrt(xDifSq + yDifSq);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//xarr[0], yarr[0], and rarr[0] is for ONE roller
		int[] xarr = new int[N];
		int[] yarr = new int[N];
		int[] rarr = new int[N];
		for (int i=0; i<N; i++){
			xarr[i] = sc.nextInt();
			yarr[i] = sc.nextInt();
			rarr[i] = sc.nextInt();
		}
		//connection[0] with the first roller
		//will be 3 if not driver or end, 2 if it is the driver/end (bc 1 connection to and 1 from)
		int[] connections = new int[N];
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				int dReq = calcReq(xarr[i], xarr[j], yarr[i], yarr[j]);
				int dAvail = rarr[i] + rarr[j];
				if (dAvail >= dReq){
					connections[i] ++;
				}
			}
		}
		for (int i=0; i<N; i++){
			if (connections[i]==2 && xarr[i] != 0 && yarr[i] != 0){
				System.out.println(xarr[i] + " " + yarr[i]);
			}
		}
//		System.out.println(Arrays.toString(connections));
		sc.close();
	}

}

