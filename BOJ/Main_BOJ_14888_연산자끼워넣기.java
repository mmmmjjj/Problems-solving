package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_14888_연산자끼워넣기 {

	static int N;
	static int[] nums;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		op = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		perm(1, nums[0]);

		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	private static void perm(int cnt, int result) {

		if (cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int n = result;
			if (op[i] == 0) continue;
			if (i == 0) n += nums[cnt];
			else if (i == 1) n -= nums[cnt];
			else if (i == 2) n *= nums[cnt];
			else if (i == 3) n /= nums[cnt];

			op[i]--;
			perm(cnt + 1, n);
			op[i]++;

		}
	}

}
