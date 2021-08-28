package sw_기초.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcd = gcd(a, b);
		int lcm = lcm(a, b);

		StringBuilder sb = new StringBuilder();
		sb.append(gcd).append('\n').append(lcm);

		System.out.println(sb);
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {

		while (b != 0) {

			int tmp = b;
			b = a % b;
			a = tmp;
		}

		return a;
	}

}
