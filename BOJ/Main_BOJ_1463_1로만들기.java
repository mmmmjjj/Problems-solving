package algo_0914;

import java.io.*;

public class Main_BOJ_1463_1로만들기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int [] arr = new int[1000001];

		arr[2] = 1;
		arr[3] = 1;

		for (int i = 4; i < 1000001; i++) {
			
			arr[i] = arr[i - 1] + 1;
			
			if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
			
			if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);

		}

		System.out.println(arr[N]);

	}

}
