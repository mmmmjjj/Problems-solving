import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long result = 0;

        for (int i = 1; i <= n; i++) {
            result += (n/i)*i;
        }

        System.out.println(result);
    }
}