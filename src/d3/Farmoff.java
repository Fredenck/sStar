/*
 * The Grand Farm-off
==================

Farmer John owns 3*N (1 <= N <= 500,000) cows surprisingly numbered
0..3*N-1, each of which has some associated integer weight W_i (1 <=
W_i <= d). He is entering the Grand Farm-off, a farming competition
where he shows off his cows to the greater agricultural community.

This competition allows him to enter a group of N cows. He has given
each of his cows a utility rating U_i (1 <= U_i <= h), which
represents the usefulness he thinks that a particular cow will have
in the competition, and he wants his selection of cows to have the
maximal sum of utility.

There might be multiple sets of N cows that attain the maximum
utility sum. FJ is afraid the competition may impose a total weight
limit on the cows in the competition, so a secondary priority is
to bring lighter weight competition cows.

Help FJ find a set of N cows with minimum possible total weight
among the sets of N cows that maximize the utility, and print the
remainder when this total weight is divided by M (10,000,000 <= M
<= 1,000,000,000).

Note: to make the input phase faster, FJ has derived polynomials
which will generate the weights and utility values for each cow.
For each cow 0 <= i < 3*N,

       W_i = (a*i^5+b*i^2+c) mod d
 and   U_i = (e*i^5+f*i^3+g) mod h

with reasonable ranges for the coefficients (0 <= a <= 1,000,000,000;
0 <= b <= 1,000,000,000; 0 <= c <= 1,000,000,000; 0 <= e <=
1,000,000,000; 0 <= f <= 1,000,000,000; 0 <= g <= 1,000,000,000;
10,000,000 <= d <= 1,000,000,000; 10,000,000 <= h <= 1,000,000,000).

The formulae do sometimes generate duplicate numbers; your algorithm
should handle this properly.

PROBLEM NAME: farmoff

INPUT FORMAT:

* Line 1: Ten space-separated integers: N, a, b, c, d, e, f, g, h, and M

SAMPLE INPUT:

2 0 1 5 55555555 0 1 0 55555555 55555555

INPUT DETAILS:

The functions generate weights of 5, 6, 9, 14, 21, and 30 along
with utilities of 0, 1, 8, 27, 64, and 125.

OUTPUT FORMAT:

* Line 1: A single integer representing the lowest sum of the weights
        (modulo M) of the N cows with the highest net utility.

SAMPLE OUTPUT:

51

OUTPUT DETAILS:

The two cows with the highest utility are cow 5 and 6, and their combined
weight is 21+30=51.
 */
//java too slow, use cpp
/*
 * #include <bits/stdc++.h>

using namespace std;

struct pairs{
    long long first;
    long long second;
};

bool cmp (pairs p1, pairs p2){
    return (p1.second>p2.second || (p1.second==p2.second && p1.first<p2.first));
}

long long power(int b, int p, int m){
    long long fin = 1;
    for (int i=0; i<p; i++){
        fin = (fin*b)%m;
    }
    return fin;
}

pairs UAW[1500000];

int main(){
    long long total = 0;
    int n,a,b,c,d,e,f,g,h,m;
    cin>>n>>a>>b>>c>>d>>e>>f>>g>>h>>m;
    
    for (int i=0; i<3*n; i++){
        UAW[i].first = ((a*power(i,5,d)%d)+(b*power(i,2,d)%d)+c)%d;
        UAW[i].second = ((e*power(i,5,h)%h)+(f*power(i,3,h)%h)+g)%h;
    }
    
    sort(UAW, UAW+n*3, cmp);
    
    for (int i=0; i<n; i++){
        total += UAW[i].first;
    }
    
    cout << total%m;
}
 */
package d3;

import java.util.*;

public class Farmoff {
	public static long exponent(long a, long b, long c){
		long d=1;
		while (b > 0){
			if ((b&1) == 1) d = d * a % c;
			b >>= 1;
			a = (a * a) % c;
		}
		return d;
	}
//	public static long exponent(long a, long b, long c){
//		//slow
//		long d=1;
//		for (int i=0; i<b; i++){
//			d = (a*d)%c;//modding each time before multiplying
//		}
//		return d;
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		long d = sc.nextInt();
		long e = sc.nextInt();
		long f = sc.nextInt();
		long g = sc.nextInt();
		long h = sc.nextInt();
		long M = sc.nextInt();
		long startTime = System.nanoTime();
		
		//Keep each cow's weight and utility together
		UAW[] UtilsAndWeights = new UAW[(int) (3*N)];//total is 3N cows, he wants N
		
		for (int i=0; i<3*N; i++){
			long weight = (a*exponent(i,5,d) + b*exponent(i,2,d) + c)%d;
			long util = (e*exponent(i,5,h) + f*exponent(i,3,h) + g)%h;
			UtilsAndWeights[i] = new UAW(weight, util);
//			System.out.println(Arrays.toString(UtilsAndWeights[i]));
		}
		//sort by best util, if same, then sort by least weight
		System.out.println("Took "+ (double)(System.nanoTime() - startTime)/1000000000 + " s"); 

		Arrays.sort(UtilsAndWeights, new Comparator<UAW>() {
		   	@Override  
			public int compare(UAW o1, UAW o2) {
		   		if (o2.util == o1.util){//same util, then sort by least weight
		   			return (int) (o1.weight-o2.weight);
		   		}
			    return (int) (o2.util-o1.util);//if dif util, then sort by most util 
			}
		});
		System.out.println("Took "+ (double)(System.nanoTime() - startTime)/1000000000 + " s"); 

		
		long sum = 0;
		for (int i=0; i<N; i++){
			sum += UtilsAndWeights[i].weight;
		}
		System.out.println((sum)%M);
		System.out.println("Took "+ (double)(System.nanoTime() - startTime)/1000000000 + " s"); 
		sc.close();
	}
	public static class UAW{
		long weight;
		long util;
		public UAW(long w, long u){
			weight = w;
			util = u;
		}
	}
}
