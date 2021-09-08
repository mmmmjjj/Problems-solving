import java.io.*;
import java.util.*;

public class Solution_D2_1954_달팽이 {

	static int N;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			map = new int[N][N];

			int r = 0, c = 0, d = 0;
			map[r][c] = 1;

			for (int i = 2; i <= N * N; i++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!check(nr, nc)) {
					d++;
					d %= 4;
				}
				r += dr[d];
				c += dc[d];

				map[r][c] = i;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				if(i==N-1) break;
				sb.append("\n");
			}

			System.out.println("#" + t);
			System.out.println(sb);

		}

	}

	private static boolean check(int nr, int nc) {

		return nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0;
	}

}
