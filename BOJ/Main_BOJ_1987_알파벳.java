package algo_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳 {

	static int R, C;
	static char[][] map;
	static int max;
	static int[] dr = { 0, 1, -1, 0 }; // 우상하좌
	static int[] dc = { 1, 0, 0, -1 };
	static boolean[] v = new boolean[26];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		go(0, 0, 1);

		System.out.println(max);

	}

	private static void go(int r, int c, int cnt) {

		v[map[r][c] - 'A'] = true;
		max = max < cnt ? cnt : max;
		for (int i = 0; i < 4; i++) {

			int nr = r + dr[i];
			int nc = c + dc[i];

			if (!check(nr, nc))
				continue;

			if (v[map[nr][nc] - 'A'])
				continue;

			go(nr, nc, cnt + 1);

		}

		v[map[r][c] - 'A'] = false;

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
