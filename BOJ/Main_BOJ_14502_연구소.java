package algo_0917;

import java.io.*;
import java.util.*;

public class Main_BOJ_14502_연구소 {

	static int N, M;
	static int[][] map;
	static int[][] origin;
	static ArrayList<point> v = new ArrayList<>();
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max = Integer.MIN_VALUE;

	public static class point {
		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		origin = new int[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) v.add(new point(i, j));
			}
		}
		combi(0, 0, 0);

		System.out.println(max);

	}

	private static void combi(int r, int c, int cnt) {
		if (cnt == 3) {
			dfs();
			max = Math.max(max, find());
			return;
		}

		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					combi(i, j, cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static int find() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) cnt++;
				if (map[i][j] == 2) map[i][j] = origin[i][j];
			}
		}

		return cnt;
	}

	private static void dfs() {
		Queue<point> q = new LinkedList<>();

		for (int i = 0; i < v.size(); i++) {
			q.add(v.get(i));
		}

		while (!q.isEmpty()) {
			point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 1) continue;
				else if (map[nr][nc] == 0) {
					map[nr][nc] = 2;
					q.add(new point(nr, nc));
				}
			}
		}

		return;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
