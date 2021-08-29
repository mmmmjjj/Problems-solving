package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4698_테네스 {

	static int result;
	static int A, B, D;
	static int[] isNotPrime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		isNotPrime = new int[1000001];

		for (int i = 2; i <= isNotPrime.length; i++) {
			int j = 2;

			while (true) {
				if (i * j > 1000000)
					break;
				isNotPrime[i * j] = 1;
				j++;
			}
		}

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			result = 0;
			if (A == 1)
				A = 2;
			for (int i = A; i <= B; i++) {
				int n = i;

				if (isNotPrime[n] == 1)
					continue;
				while (n != 0) {
					if (n % 10 == D) {
						result++;
						break;
					} else
						n /= 10;

				}

			}

			System.out.println("#" + t + " " + result);
		}

	}

}
