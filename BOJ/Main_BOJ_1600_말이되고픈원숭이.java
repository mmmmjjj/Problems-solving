package algo_0915;

import java.io.*;
import java.util.*;

public class Main_BOJ_1600_말이되고픈원숭이 {

	static int K;
	static int H, W;
	static int[][] map;
	static boolean[][][] v;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[] hdr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hdc = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		v = new boolean[K + 1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0);

		min = (min == Integer.MAX_VALUE) ? -1 : min;
		System.out.println(min);
	}

	private static void bfs(int r, int c) {
		Queue<node> q = new LinkedList<>();

		q.add(new node(0, 0, 0, 0));
		v[0][0][0] = true;

		while (!q.isEmpty()) {

			node n = q.poll();

			if (n.r == H - 1 && n.c == W - 1) {
				min = Math.min(min, n.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				if (!check(nr, nc)) continue;
				if (!v[n.k][nr][nc] && map[nr][nc] != 1) {
					q.offer(new node(n.k, nr, nc, n.cnt + 1));
					v[n.k][nr][nc] = true;
				}
			}

			if (n.k < K) {
				for (int i = 0; i < 8; i++) {
					int nr = n.r + hdr[i];
					int nc = n.c + hdc[i];
					if (!check(nr, nc)) continue;
					if (!v[n.k + 1][nr][nc] && map[nr][nc] != 1) {
						q.offer(new node(n.k + 1, nr, nc, n.cnt + 1));
						v[n.k + 1][nr][nc] = true;
					}
				}
			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	public static class node {
		int k;
		int r;
		int c;
		int cnt;

		public node(int k, int r, int c, int cnt) {
			this.k = k;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

}
