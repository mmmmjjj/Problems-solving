package sw_기초.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class Main_BOJ_11052_카드구매하기 {

	static int N;
	static int[] p, dp;
	
/*	
    n==1 1
	n==2 2, 1+dp[1]
	n==3 3, 2+dp[1], 1+dp[2]
	n==4 4, 3+dp[1], 2+dp[2], 1+dp[3] 
*/

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		p = new int[N+1];
		dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			dp[i] =p[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+p[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
