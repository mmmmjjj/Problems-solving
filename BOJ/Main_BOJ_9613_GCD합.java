package sw_기초.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9613_GCD합 {

	static int[] nums;
	static long sum;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			combi(0, 0, new int[2]);
			System.out.println(sum);
			sum = 0;
		}

	}

	private static void combi(int start, int cnt, int[] arr) {

		if (cnt == 2) {
			sum += gcd(arr[0], arr[1]);
			return;
		}

		for (int i = start; i < n; i++) {
			arr[cnt] = nums[i];
			combi(i + 1, cnt + 1, arr);
		}

	}

	private static int gcd(int a, int b) {

		while (b != 0) {

			int tmp = b;
			b = a % b;
			a = tmp;
		}

		return a;
	}

}
