import java.io.*;
import java.util.*;

public class Main_BOJ_1929_소수구하기 {

	static int[] isprime;
	static int M, N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		isprime = new int[N + 1];
		isprime[0] = 1;
		isprime[1] = 1;

		for (int i = 2; i <= N/2; i++) {
			for (int j = 2 * i; j <= N; j += i) {
				isprime[j] = 1;
			}
		}

		for (int i = M; i <= N; i++) {
			if (isprime[i] == 0) bw.append(Integer.toString(i) + "\n");
		}

		bw.flush();
		bw.close();
	}

}
