import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (x.contains(a)) x.remove(x.indexOf(a));
            else x.add(a);
            if (y.contains(b)) y.remove(y.indexOf(b));
            else y.add(b);
        }

        System.out.println(x.get(0) + " " + y.get(0));
    }

}
