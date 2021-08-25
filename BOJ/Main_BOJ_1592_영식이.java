package IMpractice;

import java.util.Scanner;

public class Main_BOJ_1592_영식이 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int[] p = new int[N + 1];

		p[1] = 1;

		int count = 0;
		int temp = 1;
		while (true) {

			if (p[temp] % 2 != 0) {
				temp = (temp + L) % N;

			} else {
				temp = (Math.abs(temp + N - L)) % N;
			}
			if (temp == 0) temp = N;
			p[temp]++;
			count++;

			if (p[temp] == M) break;
		}

		System.out.println(count);

	}

}
