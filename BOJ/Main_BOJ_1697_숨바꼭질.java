package sw_기초.그래프와bfs;

import java.io.*;
import java.util.*;

public class Main_BOJ_1697_숨바꼭질 {

	static int N, K, result;
	static Queue<int[]> q;
	static boolean v[] = new boolean[100001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		System.out.println(result);
	}

	private static void bfs() {
		q = new LinkedList<int[]>();

		q.add(new int[] { N, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];

			if (x == K) {
				result = cur[1];
				return;
			}

			add(x - 1, cur[1] + 1);
			add(x + 1, cur[1] + 1);
			add(x * 2, cur[1] + 1);
		}

	}

	private static void add(int n, int level) {
		if (check(n)) {
			if (!v[n]) {
				q.add(new int[] { n, level });
				v[n] = true;
			}
		}
	}

	private static boolean check(int n) {
		return n >= 0 && n <= 100000;
	}
}
