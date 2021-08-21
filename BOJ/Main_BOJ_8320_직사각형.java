package IMpractice;

import java.util.Scanner;

public class Main_BOJ_8320_직사각형 {

	public static void main(String[] args) throws Exception {

		int n, count = 0;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (i * j <= n)
					count++;
			}
		}

		System.out.println(count);
	}

}
