import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] a, b;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new int[N];
            b = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                b[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(a);
            Arrays.sort(b);

            int sum = 0;
            int cnt = 0;
            int idxB = 0;
            for (int i : a) {
                while (idxB < b.length && i > b[idxB]) {
                    cnt++;
                    idxB++;
                }
                sum += cnt;
            }
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}