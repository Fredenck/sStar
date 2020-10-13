package d15;

import java.io.*;
import java.util.*;
//bfs?
public class Relayrace2 {
	
	static int N;
	static Info[] info;
	static int[] ran;
	
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
			
//			if (cowId==1){
//				int timeTot = time;
//			}
		}
		
		ran = new int[N+1];
		boolean flag = true;
		
		ran[1] = 1;
		while (flag){
			
		}
		
		
		br.close();
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
