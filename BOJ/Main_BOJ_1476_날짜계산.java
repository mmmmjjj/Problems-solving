package sw_기초.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1476_날짜계산 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int idx = 0;
		if (S == 28) S = 0;
		if (M == 19) M = 0;
		
		while (true) {

			int n = 15 * idx + E;

			if (n % 28 == S && n % 19 == M) {
				System.out.println(n);
				break;
			}

			idx++;

		}

	}

}
