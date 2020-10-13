package d15;

import java.io.*;
//largest amount of groups so no carries
//sorting small to greatest will not work (e.g. 19 vs 91 and 21)
//N<=20
public class Escape {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] cows = new int[N];
		for (int i=0; i<N; i++){
			cows[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		for (int i=0; i<(1<<N); i++){
			int ct = 0;
			int sum = 0;
			for (int j=0; j<N; j++){
				if ((i&(1<<j)) != 0){
					if (noCarry(sum,cows[N-j-1])){
						sum += cows[N-j-1];
						ct++;
					}
				}
			}
			if (ct>max){
				max = ct;
			}
		}		
		System.out.println(max);
		br.close();
	}
	//digs must not reach 10
	public static boolean noCarry(int x, int y){
		int maxLen = Math.max(len(x), len(y));
		
		for (int i=0; i<maxLen; i++){
			if ((x%10)+(y%10)>=10){
				return false;
			}
			x/=10;
			y/=10;
		}
		return true;
	}
	public static int len(int x){
		int ct = 0;
		while (x!=0){
			x/=10;
			ct++;
		}
		return ct;
	}
}
