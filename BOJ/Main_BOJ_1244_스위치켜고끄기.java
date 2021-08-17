package algo_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1244_스위치켜고끄기 {

	static int N;
	static int[] swt;
	static int studentNum;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		swt = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			swt[i] = Integer.parseInt(st.nextToken());
		}

		studentNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "1": {
				boy(Integer.parseInt(st.nextToken()));
				break;
			}
			case "2": {
				girl(Integer.parseInt(st.nextToken()));
				break;
			}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.printf(swt[i] + " ");
			if(i%20==0) System.out.println();
		}

	}

	private static void girl(int n) {
		int idx = 1;
		toggle(n);
		while (n - idx >= 1 && n + idx <= N) {
			if (swt[n - idx] != swt[n + idx])
				break;
			toggle(n - idx);
			toggle(n + idx);
			idx++;
		}

	}

	private static void boy(int n) {
		for (int i = 1; i < N + 1; i++) {
			if (i % n == 0)
				toggle(i);
		}

	}

	private static void toggle(int i) {
		swt[i] = (swt[i] == 1) ? 0 : 1;
	}
}
