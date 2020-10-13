package d15;

import java.io.*;
import java.util.*;

//N<=20,000
//0<=A<=B<=10^9
public class Milktemp {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		
		Pair[] ranges = new Pair[N]; 
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			ranges[i] = new Pair(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		
		long maxM = 0;
		for (int i=0; i<N; i++){
			long milk = 0;
			long cur = ranges[i].s;
			for (int j=0; j<N; j++){
				long cmpS = ranges[j].s;
				long cmpE = ranges[j].e;
				if(cur < cmpS){
					milk += X;
				}else if (cmpE < cur){
					milk += Z;
				}else{
					milk+=Y;
				}
			}
			if (milk>maxM){
				maxM = milk;
			}
		}
		System.out.println(maxM);
		br.close();
	}
	public static class Pair{
		long s;
		long e;
		public Pair(long start, long end){
			s=start;
			e=end;
		}
	}
}
