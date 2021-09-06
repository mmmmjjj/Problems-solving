package sw_기초.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14500_테트로미노 {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int max = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j]=true;
				func(i, j);
				dfs(i, j, 1, map[i][j]);
				v[i][j]=false;
			}
		}

		System.out.println(max);

	}

	private static void func(int r, int c) {

		if ((r == 0 || r == N - 1) && (c == 0 || c == M - 1))
			return;

		int sum = map[r][c];

		boolean out = false;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!check(nr, nc)) {
				out = true;
				continue;
			}
			sum += map[nr][nc];
		}

		if (out == false) {

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				max = (sum - map[nr][nc] > max) ? sum - map[nr][nc] : max;
			}

		}

		else
			max = (max < sum) ? sum : max;

		return;

	}

	private static void dfs(int r, int c, int cnt, int sum) {

		if (cnt == 4) {
			max = (max < sum) ? sum : max;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (!check(nr, nc))
				continue;

			v[nr][nc] = true;
			dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
			v[nr][nc] = false;
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 00 && nc < M && !v[nr][nc];
	}

}
