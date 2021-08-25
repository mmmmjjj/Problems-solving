package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11399_ATM {

	static int[] p;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		p = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(p);

		int min = p[0];
		
		for (int i = 1; i < N; i++) {
			p[i]+=p[i-1];
			min+=p[i];
		}
		

		System.out.println(min);
	}

}
