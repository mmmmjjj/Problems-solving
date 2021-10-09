package sw_기초.그래프와bfs;

import java.io.*;
import java.util.*;

public class Main_BOJ_11724_연결요소의개수 {

	static int N, M;
	static ArrayList<Integer>[] list;
	static int result;
	static int[] v;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		v = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (v[i] == 0) {
				v[i] = ++result;
				bfs(i);
			}
		}

		System.out.println(result);
	}

	private static void bfs(int n) {

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(n);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				if (v[next] != 0) continue;
				v[next] = v[n];
				q.add(next);
			}
		}
	}
	
	
}
