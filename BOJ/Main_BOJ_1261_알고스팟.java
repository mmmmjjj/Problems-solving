import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] v;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Arrays.fill(v[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        v[0][0] = 0;
        bfs();

        System.out.println(min);
    }

    private static void bfs() {
        PriorityQueue<node> q = new PriorityQueue<>();

        q.add(new node(0, 0, 0));

        while (!q.isEmpty()) {

            node cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                min = cur.wall;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!check(nr, nc)) continue;
                if (map[nr][nc] == 1 && cur.wall + 1 < v[nr][nc]) {
                    q.add(new node(nr, nc, cur.wall + 1));
                    v[nr][nc] = cur.wall + 1;
                } else if (map[nr][nc] == 0 && cur.wall < v[nr][nc]) {
                    q.add(new node(nr, nc, cur.wall));
                    v[nr][nc] = cur.wall;
                }

            }

        }

    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static class node implements Comparable<node> {
        int r;
        int c;
        int wall;

        public node(int r, int c, int wall) {
            this.r = r;
            this.c = c;
            this.wall = wall;
        }

        @Override
        public int compareTo(node o) {
            return this.wall - o.wall;
        }
    }
}