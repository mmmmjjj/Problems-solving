package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기 {

	static int N;
	static int T;
	static int[][] map;
	static int profit;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			profit=0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {

					profit += map[i][j];

				}
			}

			for (int i = N / 2, a = 0; i < N; i++, a++) {
				for (int j = a; j < N - a; j++) {
					profit += map[i][j];
				}
			}

			System.out.println("#" + t + " " + profit);
		}

	}

}
