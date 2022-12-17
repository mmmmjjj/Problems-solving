import java.util.*;
import java.io.*;

/*
적어도 M미터의 나무를 집에 가져가기 위해 설정할 높이의 최댓값
 */
public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int l = 0;
        int r = 1_000_000_000;

        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] < mid) continue;
                sum += (arr[i] - mid);

                if (sum > M) break;
            }

            if (sum < M)
                r = mid - 1;
            else {
                l = mid + 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
