public class Main {

    static long dp[][];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < 9 ; j++) {
                dp[i][j] = dp[i-1][j-1] % 1_000_000_000 + dp[i-1][j+1] % 1_000_000_000;
            }
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % 1_000_000_000;
        }

        System.out.println(result);
    }
}
