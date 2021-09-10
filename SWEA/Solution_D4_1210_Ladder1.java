import java.io.*;
import java.util.*;

public class Solution_1210_D4_Ladder1 {

	static int[][] map;
	static boolean[][] v;
	static int r, c;
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { 1, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			map = new int[100][100];
			v = new boolean[100][100];
			

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 100; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}

			while (true) {
				
				if(r==0) break;
				
				v[r][c] = true;
				
				for (int d = 0; d < 3; d++) {

					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc)) continue;
					if (map[nr][nc] == 0 || v[nr][nc]) continue;

					r = nr;
					c = nc;
					break;
				}

			}

			System.out.println("#" + t + " " + c);
		}

	}


	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < 100 && nc >= 0 && nc < 100;
	}

}
