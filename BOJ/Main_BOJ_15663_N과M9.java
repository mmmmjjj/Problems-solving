package sw_기초.브루트포스.N과M;

import java.io.*;
import java.util.*;

public class Main_BOJ_15663_N과M9 {
	static int N;
	static int M;
	static int[] nums;
	static LinkedHashSet<String> hs = new LinkedHashSet<>();
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		perm(0, "", new boolean[N]);

		br.close();
		bw.close();
	}

	private static void perm(int cnt, String s, boolean[] v) throws Exception {
		if (cnt == M) {
			if (hs.contains(s)) return;
			hs.add(s);
			bw.write(s);
			bw.newLine();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			s += nums[i] + " ";
			v[i] = true;
			perm(cnt + 1, s, v);
			v[i] = false;
		}
	}

}