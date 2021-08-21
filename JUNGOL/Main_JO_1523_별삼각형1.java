package IMpractice;

import java.util.Scanner;

public class Main_JO_1523_별삼각형1 {

	static int n, m;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		if (n > 100)
			System.out.println("INPUT ERROR!");

		else
			print(n, m);

	}

	private static void print(int n, int m) {

		if (m == 1) {

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j < i + 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

		} else if (m == 2) {
			for (int i = n; i > 0; i--) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

		} else if (m == 3) {
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= n + i; j++) {
					if (j < n - i)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}

	}
}