package sw_기초.그래프와bfs;

import java.io.*;
import java.util.*;

public class Main_BOJ_4963_섬의개수 {
	static int w, h;
	static int[][] map;
	static int[] dr = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) break;

			result = 0;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						dfs(i, j);
						result++;
					}
				}
			}

			bw.append(Integer.toString(result));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int r, int c) {
		map[r][c] = 0;

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc)) continue;
			if (map[nr][nc] == 1) dfs(nr, nc);
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w;
	}

}
