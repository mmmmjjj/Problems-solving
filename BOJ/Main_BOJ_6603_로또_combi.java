package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_6603_로또_combi {

	static int[] nums;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();
			if (s.equals("0")) break;

			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			nums = new int[N];

			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			combi(0, 0, new int[6]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void combi(int start, int cnt, int[] ns) {
		
		if(cnt==6) {
			for (int i = 0; i < 6; i++) {
				sb.append(ns[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			
			ns[cnt]=nums[i];
			combi(i+1,cnt+1,ns);
			
		}
		
	}

}
