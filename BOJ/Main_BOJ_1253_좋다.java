import java.io.*;
import java.util.*;

public class Main {

    /*
    좋다
    골드 4
    시간: 148ms
    메모리: 12888kb
    */

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        System.out.println(find());
    }

    private static int find() {

        int ans = 0;

        for (int i = 0; i < N; i++) {
            int n = arr[i];

            int s = 0;
            int e = N - 1;

            while (s < e) {

                int sum = arr[s] + arr[e];

                if (s == i) s++;
                else if (e == i) e--;

                else {
                    if (sum == n) {
                        ans++;
                        break;
                    } else if (sum > n)
                        e--;
                    else s++;
                }
            }

        }

        return ans;
    }
}
