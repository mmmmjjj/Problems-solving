package IMpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7272_안경이없어 {

	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String result = "";

			StringTokenizer st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (a.length() != b.length()) {
				result = "DIFF";
				System.out.println("#" + t + " " + result);
				continue;
			}

			else {
				int n = a.length();

				for (int i = 0; i < n; i++) {

					char ac = a.charAt(i);
					char bc = b.charAt(i);

					if (isDiff(ac, bc)) {
						result = "DIFF";
						break;
					}
					
					result = "SAME";
				}

			}

			System.out.println("#" + t + " " + result);
		}

	}

	private static boolean isDiff(char ac, char bc) {
		int a = 0;
		int b = 0;

		if (ac == 'A' || ac == 'D' || ac == 'P' || ac == 'Q' || ac == 'O' || ac == 'R')
			a = 1;
		else if (ac == 'B') {
			a = 2;
		}
		
		if (bc == 'A' || bc == 'D' || bc == 'P' || bc == 'Q' || bc == 'O' || bc == 'R')
			b = 1;
		else if (bc == 'B')
			b = 2;

		return a != b;
	}

}
