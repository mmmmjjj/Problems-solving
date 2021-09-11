package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_6603_로또 {

	static int[] nums;
	static int[] p;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s.equals("0")) break;

			StringTokenizer st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			nums = new int[N];
			p = new int[N];

			int cnt = 0;
			while (cnt < 6) p[cnt++] = 1;

			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			do {
				for (int i = 0; i < N; i++) {
					if (p[i] == 1) sb.append(nums[i] + " ");
				}
				sb.append("\n");
			} while (np(p));
			sb.append("\n");

		}

		System.out.println(sb);
	}

	private static boolean np(int[] nums) {

		int i = nums.length - 1;

		while (i > 0 && nums[i - 1] <= nums[i]) i--;

		if (i == 0) return false;

		int j = nums.length - 1;

		while (nums[i - 1] <= nums[j]) j--;

		swap(nums, i - 1, j);

		int k = nums.length - 1;

		while (i < k) swap(nums, i++, k--);

		return true;
	}

	private static void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

}
