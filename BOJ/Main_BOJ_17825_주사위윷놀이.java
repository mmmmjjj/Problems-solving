import java.util.*;
import java.io.*;

/*
    주사위 윷놀이
    골드 2
    시간 : 124ms
    메모리 : 13476kb
*/

public class Main {

    static int[] dice; // 주사위
    static Node[] nodes;
    static boolean[] map; // 말이 있는지 없는지
    static int[] mal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[10];
        map = new boolean[33];
        mal = new int[4];

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        setMap();
        System.out.println(perm(0));

    }

    private static int perm(int cnt) {

        int max = 0;

        if (cnt == 10) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int now = mal[i];
            int des = go(dice[cnt],now);

            if(now==32) continue;
            if(map[des] && des!=32) continue;

            map[now] = false;
            mal[i] = des;
            map[des] = true;

            int sum = perm(cnt + 1) + nodes[des].score;

            max = Math.max(sum,max);

            mal[i] = now;
            map[des]=false;
            map[now]=true;
        }

        return max;
    }

    private static int go(int n, int now) {

        if(nodes[now].blue!=0)
            now = nodes[now].blue;
        else
            now = nodes[now].next;

        for (int i = 1; i < n; i++) {
            now = nodes[now].next;
        }

        return now;
    }

    private static void setMap() {

        nodes = new Node[33];

        // 바깥 맵
        for (int i = 0; i <= 20; i++) {
            nodes[i] = new Node(i * 2, i + 1);
        }

        nodes[5].blue = 21;
        nodes[21] = new Node(13, 22);
        nodes[22] = new Node(16, 23);
        nodes[23] = new Node(19, 24);
        nodes[24] = new Node(25, 30);

        nodes[10].blue = 25;
        nodes[25] = new Node(22, 26);
        nodes[26] = new Node(24, 24);

        nodes[15].blue = 27;
        nodes[27] = new Node(28, 28);
        nodes[28] = new Node(27, 29);
        nodes[29] = new Node(26, 24);

        nodes[30] = new Node(30, 31);
        nodes[31] = new Node(35, 20);
        nodes[20].next = 32;
        nodes[32] = new Node(0, 32);


    }

    public static class Node {
        int score;
        int next;
        int blue;

        public Node(int score, int next) {
            this.score = score;
            this.next = next;
            this.blue = 0;
        }

    }

}