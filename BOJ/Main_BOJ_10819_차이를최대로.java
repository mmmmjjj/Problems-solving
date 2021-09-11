package sw_기초.브루트포스;

import java.util.*;
import java.io.*;

public class Main_BOJ_10819_차이를최대로 {

	static int N;
	static int[] nums;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		do {
			int sum = 0;

			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(nums[i] - nums[i + 1]);
			}

			max = (max > sum) ? max : sum;

		} while (np(nums));

		System.out.println(max);
	}

	private static boolean np(int[] nums) {

		int i = nums.length - 1;

		while (i > 0 && nums[i - 1] >= nums[i]) i--;

		if (i == 0) return false;

		int j = nums.length - 1;

		while (nums[i - 1] >= nums[j]) j--;

		swap(nums, i - 1, j);

		int k = nums.length - 1;

		while (i < k) {
			swap(nums, i++, k--);
		}

		return true;
	}

	private static void swap(int[] nums, int i, int j) {

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

}
