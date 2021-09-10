import java.io.*;
import java.util.*;

public class Solution_1210_D4_Ladder1 {

	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {

			int T = Integer.parseInt(br.readLine().trim());

			int[][] map = new int[100][100];
			boolean[][] v = new boolean[100][100];
			int r = 99;
			int c = 0;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());

				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) c = j;
				}
			}

			while (r!=0) {
				
				v[r][c] = true;

				for (int d = 0; d < 3; d++) {

					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc))
						continue;
					if (map[nr][nc] == 0 || v[nr][nc])
						continue;

					r = nr;
					c = nc;
					break;
				}

			}

			sb.append("#" + T + " " + c).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < 100 && nc >= 0 && nc < 100;
	}

}
