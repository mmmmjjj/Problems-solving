import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(result);
    }

    private static void bfs() {

        Queue<node> q = new LinkedList<>();

        q.add(new node(0, 0, 1));

        while (!q.isEmpty()) {
            node cur = q.poll();
            if (cur.r == N - 1 && cur.c == M - 1) {
                result = cur.level;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (!check(nr, nc)) continue;
                if (map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    q.add(new node(nr, nc, cur.level + 1));
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static class node {
        int r;
        int c;
        int level;

        public node(int r, int c, int level) {
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
}
