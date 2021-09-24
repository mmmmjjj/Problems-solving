package algo_0924;

import java.io.*;
import java.util.*;

public class Main_BOJ_7576_토마토 {

	static int M, N;
	static int[][] map;
	static Queue<point> q;
	static int result = 0;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		q = new LinkedList<point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) q.add(new point(i, j, 0));
			}
		}

		while (!q.isEmpty()) {

			point p = q.poll();

			if (result < p.day) result = p.day;

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 0) {
					q.add(new point(nr, nc, p.day + 1));
					map[nr][nc] = 1;
				}
			}
		}

		checkMap();

		System.out.println(result);
	}

	private static void checkMap() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					result = -1;
					return;
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	public static class point {
		int r;
		int c;
		int day;

		public point(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

}
