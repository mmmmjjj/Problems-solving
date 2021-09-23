import java.io.*;
import java.util.*;

public class main {

    static int N;
    static int[][] map;
    static boolean[] v;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N+1][N+1];
        v = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        v[1] = true;

        dfs(0,1,0);

        System.out.println(min);
    }

    private static void dfs(int cnt, int current,int sum) {
        if(sum>min) return;
        if(cnt==N&&current==1){
            min = Math.min(min,sum);
            return;
        }

        else if(cnt==N-1){
            if(map[current][1]!=0){
                dfs(cnt+1,1,sum+map[current][1]);
            }
        }

        for (int i = 2; i <= N; i++) {
            if(map[current][i]==0||v[i]==true) continue;
            v[i] = true;
            dfs(cnt+1,i,sum+map[current][i]);
            v[i]= false;
        }

    }


}
