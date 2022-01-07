import java.io.*;
import java.util.*;

/*
    욕심쟁이 판다
    골드 3
    시간 : 466ms
    메모리 : 40720kb
*/

public class Main {

    static int T;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < input.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(input.charAt(i));
                    continue;
                }

                if (stack.peek() == '(' && input.charAt(i) == ')') {
                    stack.pop();
                } else stack.push(input.charAt(i));
            }

            if (stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb.toString());
    }
}
