package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_10971_외판원순회2_perm {

	static int N;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0, 0, 0, new boolean[N]);

		System.out.println(min);
	}

	private static void perm(int current, int cnt, int price, boolean[] v) {

		if (cnt == N) {
			min = Math.min(min, price);
			return;
		}

		if (cnt == N - 1) {
			if (map[current][0] != 0) 
				perm(current, cnt + 1, price + map[current][0], v);
		} else {
			for (int i = 1; i < N; i++) {
				if(v[i] || map[current][i]==0) continue;
				v[i] = true;
				perm(i, cnt + 1, price + map[current][i], v);
				v[i] = false;
			}
		}

	}

}
