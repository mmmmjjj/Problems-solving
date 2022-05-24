import java.util.*;
import java.io.*;

/*
    스도쿠
    골드 4
    시간 : 312ms
    메모리 : 15520kb
*/

public class Main {

    static int[][] map;
    static boolean[][] s1; // 가로 줄
    static boolean[][] s2; // 세로 줄
    static boolean[][] s3; // 정사각형
    static ArrayList<Point> list; // 빈칸
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        s1 = new boolean[9][10];
        s2 = new boolean[9][10];
        s3 = new boolean[9][10];
        list = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            map[i] = new int[9];
            s1[i] = new boolean[10];
            s2[i] = new boolean[10];
            s3[i] = new boolean[10];
        }

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 빈칸 리스트에 추가하면서 가로줄 체크
                if (map[i][j] == 0)
                    list.add(new Point(i, j));
                else s1[i][map[i][j]] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // s2
                if (map[j][i] != 0)
                    s2[i][map[j][i]] = true;
            }
        }

        dfs(0);
    }

    private static void dfs(int cnt) {

        if (cnt == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        // 채울 빈칸
        Point p = list.get(cnt);

        // 1부터 9까지 넣어본다.
        for (int i = 1; i <= 9; i++) {

            // 부합하면
            if (check(p, i)) {
                // 그 숫자로 픽스
                map[p.r][p.c] = i;
                // 다음 dfs
                s1[p.r][i] = true;
                s2[p.c][i] = true;
                dfs(cnt + 1);
                s1[p.r][i] = false;
                s2[p.c][i] = false;
            }
        }
        map[p.r][p.c] = 0;

    }

    private static boolean check(Point p, int value) {

        // 가로 체크
        if (s1[p.r][value])
            return false;

        // 세로 체크
        if (s2[p.c][value])
            return false;

        // 네모 체크
        int r = (p.r / 3) * 3;
        int c = (p.c / 3) * 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (map[i][j] == value)
                    return false;
            }
        }

        return true;
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}