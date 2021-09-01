package sw_기초.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1978_소수찾기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] Prim = new int[1001];
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		Prim[0] = Prim[1] = 1;
		
		for (int i = 2; i < Prim.length; i++) {
			if (Prim[i] == 1)
				continue;

			for (int j = i * 2; j < Prim.length; j += i) {
				Prim[j] = 1;
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			if (Prim[n] == 0)
				cnt++;
		}

		System.out.println(cnt);
	}

}
