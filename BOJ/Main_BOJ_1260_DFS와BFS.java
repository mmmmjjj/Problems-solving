import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer> list[];
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        v = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(v, false);
        bfs(V);


        System.out.println(sb);
    }

    private static void bfs(int n) {

        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        while (!q.isEmpty()) {

            int num = q.poll();
            v[num] = true;

            sb.append(num + " ");

            for (int i = 0; i < list[num].size(); i++) {
                int next = list[num].get(i);
                if (!v[next]) {
                    v[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static void dfs(int n) {

        v[n] = true;
        sb.append(n+" ");

        for (int i = 0; i < list[n].size(); i++) {
            int num = list[n].get(i);
            if (!v[num]) {
                dfs(num);
            }
        }

    }
}
