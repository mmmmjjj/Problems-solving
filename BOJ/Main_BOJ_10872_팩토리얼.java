import java.io.*;

public class Main_BOJ_10872_팩토리얼 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int sum = 1;

		for (int i = N; i > 0; i--) {
			sum *= i;
		}

		System.out.println(sum);
	}

}
