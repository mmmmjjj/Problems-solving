import java.io.*;
import java.util.*;

public class Main {
  
  /*
    마법사 상어와 파이어볼
    골드 4
    시간: 760ms
    메모리: 24868kb
     */

    static int N, M, K;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static ArrayList<Fire>[][] map;
    static ArrayList<Fire> balls = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            balls.add(new Fire(
                    stoi(st.nextToken()) - 1,
                    stoi(st.nextToken()) - 1,
                    stoi(st.nextToken()),
                    stoi(st.nextToken()),
                    stoi(st.nextToken())
            ));
        }

        for (int i = 0; i < K; i++) {

            for (Fire ball : balls) {
                int nr = (N + ball.r + dr[ball.d] * (ball.s % N)) % N;
                int nc = (N + ball.c + dc[ball.d] * (ball.s % N)) % N;

                ball.r = nr;
                ball.c = nc;
                map[nr][nc].add(ball);
            }

            combine();
        }
        System.out.println(sum());
    }

    private static int sum() {
        int sum = 0;

        for (Fire fire : balls) {
            sum += fire.m;
        }
        return sum;
    }

    private static void combine() {

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() >= 2) {

                    int mSum = 0, sSum = 0;
                    int d = map[r][c].get(0).d;
                    boolean flag = false;

                    for (Fire ball : map[r][c]) {
                        mSum += ball.m;
                        sSum += ball.s;
                        if ((d + ball.d) % 2 != 0)
                            flag = true;

                        balls.remove(ball);
                    }

                    mSum /= 5;
                    sSum /= map[r][c].size();

                    if (mSum > 0) {
                        if (flag)
                            d = 1;
                        else d = 0;

                        for (int i = 0; i < 4; i++, d += 2) {
                            Fire ball = new Fire(r, c, mSum, sSum, d);
                            balls.add(ball);
                        }
                    }
                }
                map[r][c].clear();
            }
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static class Fire {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

}
