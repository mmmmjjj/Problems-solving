package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309_일곱난쟁이 {

	static int[] dwarf;
	static boolean print = false;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dwarf = new int[9];

		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		combi(0, 0, new int[7]);

	}

	private static void combi(int start, int cnt, int[] d) {
		if (cnt == 7) {
			if (sum(d) == 100 && !print) {
				Arrays.sort(d);
				for (int i = 0; i < 7; i++) {
					System.out.println(d[i]);
				}
				print = true;
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			d[cnt] = dwarf[i];
			combi(i + 1, cnt + 1, d);
		}

	}

	private static int sum(int[] d) {
		int s = 0;
		for (int i = 0; i < d.length; i++) {
			s += d[i];
		}

		return s;
	}

}
