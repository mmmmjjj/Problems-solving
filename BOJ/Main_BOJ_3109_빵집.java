import java.util.*;
import java.io.*;

// 파이프 완성하지 않더라도 되돌릴 필요가 없다!
class Main {

    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int r = 0; r < R; r++)
            if (go(r,0)) answer++;

        System.out.println(answer);
    }

    public static boolean go(int r, int c) {
        map[r][c] = 'x';

        if(c==C-1) return true;

        if(r>0 && map[r-1][c+1]=='.')
            if(go(r-1,c+1)) return true;

        if(map[r][c+1]=='.')
            if(go(r,c+1)) return true;

        if(r+1<R && map[r+1][c+1]=='.')
            if(go(r+1,c+1)) return true;

        return false;
    }
}