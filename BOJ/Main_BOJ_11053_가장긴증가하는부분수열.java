import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        int []arr = new int[n];
        int []dp = new int[n];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
