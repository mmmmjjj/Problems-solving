package algo_0823;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1238_Contact {

	static int N, S;
	static int tel[][];
	static int v[];
	static int MAX = 100;
	static int max, ti, tj;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			N = sc.nextInt();
			S = sc.nextInt();

			tel = new int[MAX + 1][MAX + 1];
			v = new int[MAX + 1];

			for (int i = 0; i < N / 2; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				tel[start][end] = 1;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(S);
			ti = 1;
			v[S] = 1;

			int temp = 0;
			while (!queue.isEmpty()) {

				if (ti == 0) {
					if (tj != 0) {
						max = temp;
						temp = 0;
					}
					ti = tj;
					tj = 0;
				}

				int n = queue.poll();
				for (int i = 1; i <= MAX; i++) {

					if (tel[n][i] == 1 && v[i] == 0) {
						queue.add(i);
						tj++;
						v[i] = 1;
						temp = (temp < i) ? i : temp;
					}
				}
				ti--;

			}
			System.out.println("#" + t + " " + max);
		}
	}

}
