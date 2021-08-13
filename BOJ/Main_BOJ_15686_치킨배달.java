package algo_0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_15686_치킨배달 {

	static int N, M;
	static int[][] map;
	static int[][] distance;
	static int[][] home;
	static int[][] chicken;

	static int cn, hn;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		chicken = new int[13][2];
		home = new int[N * 2][2];

		cn = 0; // 치킨집 개수
		hn = 0; // 집 개수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					chicken[cn][0] = i;
					chicken[cn++][1] = j;

				} else if (map[i][j] == 1) {
					home[hn][0] = i;
					home[hn++][1] = j;
				}
			}
		}

		distance = new int[hn][cn];

		for (int i = 0; i < hn; i++) {
			for (int j = 0; j < cn; j++) {

				distance[i][j] = Math.abs(chicken[j][0] - home[i][0]) + Math.abs(chicken[j][1] - home[i][1]);

			}
		}

		combi(0, 0, new int[M]);
		System.out.println(min);
	}

	private static void combi(int start, int cnt, int[] num) {

		if (cnt == M) {
			int sum = 0;

			for (int i = 0; i < hn; i++) {
				sum += findMin(i, num);
			}

			min = Math.min(sum, min);
			return;
		}

		for (int i = start; i < cn; i++) {

			num[cnt] = i;
			combi(i + 1, cnt + 1, num);

		}

	}

	private static int findMin(int hn, int[] num) {

		int d = Integer.MAX_VALUE;

		for (int i : num) {
			d = Math.min(distance[hn][i], d);
		}

		return d;
	}

}
