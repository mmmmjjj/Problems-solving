package algo_0804;

import java.io.*;
import java.util.*;

public class Solution_D2_2001_파리퇴치 {

	static int N, M;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					kill(i, j);
				}
			}

			System.out.println("#" + t + " " + max);
		}

	}

	private static void kill(int r, int c) {
		int sum = 0;

		for (int i = r; i < r + M; i++) {
			for (int j = c; j < c + M; j++) {
				sum += map[i][j];
			}
		}

		max = (sum > max) ? sum : max;

		return;
	}

}
