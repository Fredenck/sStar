/*
 * Combination Lock
================

Farmer John's cows keep escaping from his farm and causing mischief. To try
and prevent them from leaving, he purchases a fancy combination lock to
keep his cows from opening the pasture gate. 

Knowing that his cows are quite clever, Farmer John wants to make sure they
cannot easily open the lock by simply trying many different combinations. 
The lock has three dials, each numbered 1..N (1 <= N <= 100), where 1 and N
are adjacent since the dials are circular.  There are two combinations that
open the lock, one set by Farmer John, and also a "master" combination set
by the lock maker.  The lock has a small tolerance for error, however, so
it will open even if the numbers on the dials are each within at most 2
positions of a valid combination.  For example, if Farmer John's
combination is (1,2,3) and the master combination is (4,5,6), the lock will
open if its dials are set to (1,N,5) (since this is close enough to Farmer
John's combination) or to (2,4,8) (since this is close enough to the master
combination).  Note that (1,5,6) would not open the lock, since it is not
close enough to any one single combination.

Given Farmer John's combination and the master combination, please
determine the number of distinct settings for the dials that will open the
lock.  Order matters, so the setting (1,2,3) is distinct from (3,2,1).

PROBLEM NAME: combo

INPUT FORMAT:

* Line 1: The integer N.

* Line 2: Three space-separated integers, specifying Farmer John's
        combination.

* Line 3: Three space-separated integers, specifying the master
        combination (possibly the same as Farmer John's combination).

SAMPLE INPUT:

50
1 2 3
5 6 7

INPUT DETAILS:

Each dial is numbered 1..50.  Farmer John's combination is (1,2,3), and the
master combination is (5,6,7).

OUTPUT FORMAT:

* Line 1: The number of distinct dial settings that will open the
        lock.

SAMPLE OUTPUT:

249
 */
package d1.Classwork;
import java.util.*;

public class Combo {
	public static boolean isClose(int N, int a, int master){
		if ((Math.abs(a-master)<=2) || (Math.abs(a-master)>= N-2)){//two apart or two apart, looping around the lock
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int FJ1 = sc.nextInt();
		int FJ2 = sc.nextInt();
		int FJ3 = sc.nextInt();
		int MC1 = sc.nextInt();
		int MC2 = sc.nextInt();
		int MC3 = sc.nextInt();
		
		int ct = 0;
		for (int i=1; i<N+1; i++){
			for (int j=1; j<N+1; j++){
				for (int k=1; k<N+1; k++){
					//check with FJ and MC separately because they are independent
					//if and else if because a combination(i,j,k) cannot be counted twice, once for FJ and MC
					if (isClose(N, i,FJ1) && isClose(N, j,FJ2) && isClose(N, k,FJ3)){
						ct++;
					}else if (isClose(N, i,MC1) && isClose(N, j,MC2) && isClose(N, k,MC3)){
						ct++;
					}
				}
			}
		}
		System.out.println(ct);
		sc.close();
	}

}
