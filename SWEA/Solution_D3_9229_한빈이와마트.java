package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와마트 {

	static int N, M;
	static int[] snack;
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			snack = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			result = -1;
			combi(0, 0, new int[2]);

			System.out.println("#" + t + " " + result);
		}

	}

	private static void combi(int start, int cnt, int[] nums) {

		if (cnt == 2) {
			int sum = nums[0] + nums[1];
			if (sum > M)
				return;
			result = (result < sum) ? sum : result;
			return;
		}

		for (int i = start; i < N; i++) {
			nums[cnt] = snack[i];
			combi(i + 1, cnt + 1, nums);
		}

	}

}
