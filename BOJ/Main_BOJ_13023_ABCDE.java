import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static boolean[] v;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N];
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (result == 1) break;
        }

        System.out.println(result);
    }

    private static void dfs(int cur, int cnt) {

        if (result == 1) return;

        if (cnt == 5) {
            result = 1;
            return;
        }

        v[cur] = true;
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if (!v[next])
                dfs(next, cnt + 1);
        }
        v[cur] = false;
    }
}
