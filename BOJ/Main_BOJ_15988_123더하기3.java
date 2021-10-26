import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;

    /*
    n==1    | 1
    n==2    | 1+1   | 2
    n==3    | 1+1+1 | 1+2       | 2+1   | 3
    n==4    | 1~    | 1+1+2     | 1+2+1 | 1+3   | 2+1+1 | 2+2   | 3+1
    n==5    | 1~    | 1+1+1+2   | 1+1+2+1|1+1+3

    */

    public static void main(String[] args) throws Exception {

        dp = new long[1000001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++)
            sb.append(dp[Integer.parseInt(br.readLine())] + "\n");


        System.out.println(sb);
    }

}