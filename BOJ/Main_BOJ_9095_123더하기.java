package sw_기초.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9095_123더하기 {

	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());
			cnt = 0;
			print(n);

			System.out.println(cnt);
		}

	}

	private static void print(int n) {
		
		if (n == 0) {
			cnt++;
			return;
		}

		if (n >= 3) print(n - 3);
		if (n >= 2) print(n - 2);
		
		print(n - 1);
		
	}

}
