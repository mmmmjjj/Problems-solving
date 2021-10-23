import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dp[n]);
    }

}