package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2491_수열 {

	static int[] nums;
	static int N;
	static int max;


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		max = 1;
		int up = 1;
		int down = 1;

		for (int i = 0; i < N - 1; i++) {
			if (nums[i] <= nums[i + 1]) {
				up++;
			} else
				up = 1;
			max = Math.max(up, max);
		}

		for (int i = 0; i < N - 1; i++) {
			if (nums[i] >= nums[i + 1]) {
				down++;
			} else
				down = 1;
			max = Math.max(max, down);
		}

		System.out.println(max);
	}

}
