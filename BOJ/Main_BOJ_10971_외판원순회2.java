package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_10971_외판원순회2 {

	static int N;
	static int[][] map;
	static int[] root;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		root = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (cnt < N) root[cnt] = cnt++;

		do {
			go();
		} while (np(root));

		System.out.println(min);
	}

	private static void go() {
		int price = 0;
		if (map[root[N - 1]][root[0]] == 0) return;
		price += map[root[N - 1]][root[0]];
		for (int i = 0; i < N - 1; i++) {
			if (map[root[i]][root[i + 1]] == 0) return;
			price += map[root[i]][root[i + 1]];
		}

		min = (price < min) ? price : min;
	}

	private static boolean np(int[] perm) {

		int n = perm.length;

		int i = n - 1;
		while (i > 0 && perm[i - 1] >= perm[i]) --i;

		if (i == 0) return false;

		int j = n - 1;

		while (perm[i - 1] >= perm[j]) --j;

		swap(perm, i - 1, j);

		int k = n - 1;
		while (i < k) swap(perm, i++, k--);

		return true;
	}

	private static void swap(int[] perm, int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;

	}

}
