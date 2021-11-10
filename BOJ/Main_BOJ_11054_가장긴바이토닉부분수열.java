import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int result = 0;

		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] dp2 = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(dp2, 1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[i] > arr[j]) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i] + dp2[i]);
		}

		System.out.println(result - 1);
	}
}