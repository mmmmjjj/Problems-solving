package algo_0917;

import java.io.*;
import java.util.*;

public class Solution_1767_프로세서연결하기 {

	static int min;
	static int linecount, maxcore;
	static int N;
	static ArrayList<point> core;
	static int[][] map;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static public class point {
		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "point [r=" + r + ", c=" + c + "]";
		}

		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			core = new ArrayList<>();
			map = new int[N][N];
			linecount = 0;
			min = Integer.MAX_VALUE;
			maxcore = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) core.add(new point(i, j));
				}
			}

			dfs(0, 0, 0);

			bw.append("#" + t + " " + min);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int cnt, int linkcnt, int line) {

		if (cnt == core.size()) {

			if (maxcore == linkcnt) 
				min = Math.min(min, line);
			else if(maxcore<linkcnt) {
				maxcore = linkcnt;
				min = line;
			}
			
			return;
		}

		point p = core.get(cnt);
		for (int d = 0; d < 4; d++) {
			if (connectable(p, d)) {
				go(p, d, 2);
				dfs(cnt + 1, linkcnt + 1, line + linecount);
				go(p, d, 0);
			}

		}

		dfs(cnt + 1, linkcnt, line);

	}

	private static void go(point p, int d, int n) {
		int nr = p.r + dr[d];
		int nc = p.c + dc[d];
		linecount = 0;

		while (check(nr, nc)) {
			linecount++;
			map[nr][nc] = n;
			nr += dr[d];
			nc += dc[d];
		}

	}

	private static boolean connectable(point p, int d) {
		int nr = p.r + dr[d];
		int nc = p.c + dc[d];

		while (check(nr, nc)) {

			if (map[nr][nc] != 0) return false;
			nr += dr[d];
			nc += dc[d];
		}

		return true;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
