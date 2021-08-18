package algo_0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		divide(0, 0, N);
		System.out.println(sb);
	}

	private static void divide(int r, int c, int size) {

		if (isPossible(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}

		int newSize = size / 2;

		sb.append("(");
		divide(r, c, newSize);
		divide(r, c + newSize, newSize);
		divide(r + newSize, c, newSize);
		divide(r + newSize, c + newSize, newSize);

		sb.append(")");

	}

	private static boolean isPossible(int r, int c, int size) {
		int n = map[r][c];

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (n != map[i][j])
					return false;
			}
		}

		return true;
	}

}
