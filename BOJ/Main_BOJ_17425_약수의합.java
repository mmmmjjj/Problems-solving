import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long arr[] = new long[1000001];
        long dp[] = new long[1000001];
        
        Arrays.fill(arr,1);

        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; i*j < arr.length; j++) {
                arr[i*j] += i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1] + arr[i];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]+"\n");
        }

        System.out.println(sb);
    }
}
