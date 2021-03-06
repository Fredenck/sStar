/*
 * Long Distance Racing
====================

Bessie is training for her next race by running on a path that
includes hills so that she will be prepared for any terrain. She
has planned a straight path and wants to run as far as she can --
but she must be back to the farm within M seconds (1 <= M <=
10,000,000).

The entire path she has chosen is T units (1 <= T <= 100,000) in
length and consists of equal-length portions that are uphill, flat,
or downhill. The input data describes path segment i with a single
character S_i that is u, f, or d, indicating respectively uphill,
flat, or downhill.

Bessie takes U seconds (1 <= U <= 100) to run one unit of uphill
path, F (1 <= F <= 100) seconds for a unit of flat path, and D (1
<= D <= 100) seconds for a unit of downhill path.  Note that, when
returning home, uphill paths become downhill paths and downhill
paths become uphill paths.

Find the farthest distance Bessie can get from the farm and still
make it back in time.

PROBLEM NAME: racing

INPUT FORMAT:

* Line 1: Five space-separated integers: M, T, U, F, and D

* Lines 2..T+1: Line i+1 describes path segment i with a single
        letter: S_i

SAMPLE INPUT:
13 5 3 2 1
u
f
u
d
f

INPUT DETAILS:

Bessie has 13 seconds to get home (short workout!), and the total
path she has planned is 5 units long. She can run an uphill unit
in 3 seconds, a flat unit in 2 seconds, and a downhill unit in 1
seconds. The path looks like this:

 _/\_
/

OUTPUT FORMAT:

* Line 1: A single integer that is the farthest distance (number of
        units) that Bessie can get from the farm and make it back in
        time.

SAMPLE OUTPUT:
3

OUTPUT DETAILS:
She can run three units and back in 3 + 2 + 3 + 1 + 2 + 1 = 12
seconds, just a second less than her limit. If she tried to go
farther she would not make it.
 */
package d7;

import java.io.*;

public class Racing {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int time = Integer.parseInt(str[0]);
		int dist = Integer.parseInt(str[1]);
		int up = Integer.parseInt(str[2]);
		int flat = Integer.parseInt(str[3]);
		int down = Integer.parseInt(str[4]);
		
		int bTime = 0;
		int times = 0;
		for (int i=0; i<dist; i++){
			char c = br.readLine().charAt(0);
			if (c=='u' || c=='d'){
				if (bTime+up+down>time){
					break;
				}
				bTime += up + down;//forward and back
				times++;
			}else if (c=='f'){
				if (bTime+flat+flat>time){
					break;
				}
				bTime += 2*flat;
				times++;
			}
		}
		System.out.println(times);
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " s");
		br.close();
	}
}
