import java.io.*;
import java.util.*;

public class Main_BOJ_2751_수정렬하기2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Integer [] nums = new Integer[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(nums);

		for (int i = 0; i < N; i++) {
			bw.append(Integer.toString(nums[i]) + "\n");
		}

		bw.flush();
		bw.close();
	}

}
