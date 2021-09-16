package sw_기초.브루트포스;

import java.io.*;
import java.util.*;

public class Main_BOJ_1759_암호만들기 {

	static int L, C;
	static char[] a;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		a = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			a[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(a);

		combi(0, 0, new char[L], false, 0);

		System.out.println(sb);
	}

	private static void combi(int start, int cnt, char[] c, boolean hasVowel, int con) {

		if (cnt == L) {
			if (hasVowel && con >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(c[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			boolean b = false;
			int cs = con;
			if (a[i] == 'a' || a[i] == 'e' || a[i] == 'o' || a[i] == 'u' || a[i] == 'i') b = true;
			else cs = con + 1;
			c[cnt] = a[i];
			combi(i + 1, cnt + 1, c, hasVowel || b, cs);
			b = false;
		}
	}

}
