import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = Integer.MIN_VALUE;

        int []dp = new int[n];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            if(i>0) dp[i]= Math.max(dp[i], dp[i]+dp[i-1]);
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
