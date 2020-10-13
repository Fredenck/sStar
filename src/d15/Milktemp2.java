package d15;

import java.io.*;
import java.util.*;

//N<=20,000
//0<=A<=B<=10^9
public class Milktemp2 {
	
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
		
		Arrays.sort(ranges, new Comparator<Pair>() {
		   	@Override  
			public int compare(Pair o1, Pair o2) {
		   		if (o1.s==o2.s) return (int) (o1.e-o2.e);
			    return (int) (o1.s-o2.s);
			}
		});
		
		int i=0,j=0;
		int ans = 0;
		int cur = N*X;
		while (i<N || j<N){
			if (ranges[i].s<ranges[j].e){
				cur += Y-X;
				i++;
			}else{
				cur += Z-Y;
				j++;
			}
			if(cur>ans){
				ans = cur;
			}
			
		}
		
		System.out.println(ans);
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
