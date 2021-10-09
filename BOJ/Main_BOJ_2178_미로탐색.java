import java.io.*;
import java.util.*;

public class Main_BOJ_2178_미로탐색 {
    static int N, M, result;
    static int[][] map;
    static int[] dr = {0, 0, -1, 1}; //사방 탐색
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
            // 도착 지점이라면 리턴
            if (cur.r == N - 1 && cur.c == M - 1) {
                result = cur.level;
                return;
            }
            
            // 4방향 체크하면서 갈 수 있다면 큐에 추가해준다.
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (!check(nr, nc)) continue;
                if (map[nr][nc] == 1) {
                	// 최초로 방문했을 시기가 그 지점을 방문할 수 있는 가장 빠른 경우이기 때문에 다시 방문할 필요가 없다.
                	// 그러므로 1을 0으로 바꿔서 방문 처리를 해준다.
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
        int r; // 현재 r
        int c; // 현재 c
        int level; // 지난 칸 수. 몇번째 칸인지

        public node(int r, int c, int level) {
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
}
