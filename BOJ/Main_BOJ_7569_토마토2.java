package algo_0924;

import java.io.*;
import java.util.*;

public class Main_BOJ_7569_토마토2 {

	static int M, N, H;
	static int[][][] map;
	static Queue<point> q;
	static int result = 0;

	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 1, -1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		q = new LinkedList<point>();

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1) q.add(new point(h, i, j, 0));
				}
			}
		}

		while (!q.isEmpty()) {

			point p = q.poll();

			if (result < p.day) result = p.day;

			for (int i = 0; i < 6; i++) {
				int nh = p.h + dh[i];
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (!check(nh, nr, nc)) continue;
				if (map[nh][nr][nc] == 0) {
					q.add(new point(nh, nr, nc, p.day + 1));
					map[nh][nr][nc] = 1;
				}
			}
		}

		checkMap();

		System.out.println(result);
	}

	private static void checkMap() {

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						result = -1;
						return;
					}
				}
			}
		}
	}

	private static boolean check(int h, int r, int c) {
		return h >= 0 && h < H && r >= 0 && r < N && c >= 0 && c < M;
	}

	public static class point {
		int h;
		int r;
		int c;
		int day;

		public point(int h, int r, int c, int day) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

}
