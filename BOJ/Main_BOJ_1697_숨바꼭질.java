package sw_기초.그래프와bfs;

import java.io.*;
import java.util.*;

public class Main_BOJ_1697_숨바꼭질 {

	static int N, K, result;
	static Queue<int[]> q; //bfs 큐
	static boolean v[] = new boolean[100001]; // 0부터 100000까지 방문여부 체크

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		System.out.println(result);
	}

	private static void bfs() {
		q = new LinkedList<int[]>(); // 0 : 현재 위치, 1 : 경과 시간

		q.add(new int[] { N, 0 }); // 처음 출발 지점을 큐에 추가한다.

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int n = cur[0]; //  x = 현재 위치

			if (n == K) { // 현재 위치가 동생 위치라면?
				result = cur[1]; // 경과시간을 result에 넣어주고 리턴
				return;
			}

			add(n - 1, cur[1] + 1); // 뒤로 한칸
			add(n + 1, cur[1] + 1); // 앞으로 한칸
			add(n * 2, cur[1] + 1); // 순간이동
		}

	}

	private static void add(int n, int level) {
		if (check(n)) { // n이  범위 내인지 체크
			if (!v[n]) { // n을 이전에 방문한 적이 있는 지 체크 
							 // 이전에 방문했다면 현 경우는 이미 최소값이 아니기 때문에 더할 필요가 없다.
				q.add(new int[] { n, level }); 
				v[n] = true; 
			}
		}
	}

	private static boolean check(int n) {
		return n >= 0 && n <= 100000;
	}
}
