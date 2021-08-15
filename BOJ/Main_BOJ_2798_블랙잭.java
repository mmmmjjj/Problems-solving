package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2798_블랙잭 {

	static int N, M;
	static int result;
	static int[] Nums;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Nums = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			Nums[i] = Integer.parseInt(st.nextToken());
		}

		combi(0, 0, new int[3]);

		System.out.println(result);
	}

	private static void combi(int start, int cnt, int[] nums) {

		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += nums[i];
			}

			if (sum <= M && sum > result)
				result = sum;
			return;
		}

		for (int i = start; i < N; i++) {
			nums[cnt] = Nums[i];
			combi(i + 1, cnt + 1, nums);
		}

	}

}
