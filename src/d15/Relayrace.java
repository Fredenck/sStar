package d15;

import java.io.*;
import java.util.*;

public class Relayrace {
	
	static int N;
	static Info[] info;
	static int[] ran;
	static int t1 = 0;
	static int t2 = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		info = new Info[N];
		for (int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());			
			int cowId = i+1;
			int time = Integer.parseInt(st.nextToken());
			int signals = Integer.parseInt(st.nextToken());
			int[] signalTo = new int[signals];
			for (int j=0; j<signals; j++){
				signalTo[j] = Integer.parseInt(st.nextToken());
			}
			info[i] = new Info(cowId,time,signals,signalTo);
		}
		
		ran = new int[N+1];
		
		rec(1,0);
		
		System.out.println(t1);
		br.close();
	}
	public static void rec(int cur, int time){
		if (ran[cur]==1){
//			System.out.println(time);
			return;
		}
		for (int i=0; i<N; i++){
			if (info[i].ID==cur){
				ran[info[i].ID] = 1;
				time += info[i].timeReq;
				for (int j=0; j<info[i].signals; j++){
					rec(info[i].signalTo[j],time);
				}
			}
		}
//		System.out.println(time);
		if (time>t1){
			t1 = time;
		}else if (time>t2){
			t2 = time;
		}
		return;
	}
	public static class Info{
		int ID, timeReq, signals;
		int[] signalTo;
		public Info(int i, int t, int sig, int[] sigTo){
			ID = i;
			timeReq = t;
			signals = sig;
			signalTo = sigTo;
		}	
	}
}
