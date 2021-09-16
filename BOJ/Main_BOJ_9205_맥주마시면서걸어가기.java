package algo_0916;

import java.io.*;
import java.util.*;

public class Main_BOJ_9205_맥주마시면서걸어가기 {

	static int n;
	static Point[] store;
	static Point rock;
	static StringBuilder sb = new StringBuilder();
	static boolean []v;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			n = Integer.parseInt(br.readLine());

			store = new Point[n];
			v = new boolean[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			Point p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			rock = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			bfs(p);

		}
		System.out.println(sb);
	}

	private static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();

		q.offer(point);

		while (!q.isEmpty()) {

			Point p = q.poll();

			if (Math.abs(p.x - rock.x) + Math.abs(p.y - rock.y) <= 1000) {
				sb.append("happy\n");
				return;
			}

			else {
				for (int i = 0; i < n; i++) {
					if (!v[i]&&Math.abs(p.x - store[i].x) + Math.abs(p.y - store[i].y) <= 1000) {
						q.offer(store[i]);
						v[i] = true;
					}
				}
			}

		}
		sb.append("sad\n");
		return;
	}

}
