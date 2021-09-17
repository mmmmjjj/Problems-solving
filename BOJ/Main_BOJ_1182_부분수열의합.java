package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_1182_부분수열의합 {
	static int N, S;
	static int[] nums;
	static int result = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		subset(0, 0);

		if (S == 0) result--;
		System.out.println(result);
	}

	private static void subset(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S) result++;
			return;
		}

		subset(cnt + 1, sum + nums[cnt]);
		subset(cnt + 1, sum);
	}

}
