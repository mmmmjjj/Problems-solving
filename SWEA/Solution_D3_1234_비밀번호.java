package IMpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int length = Integer.parseInt(st.nextToken());

			List<Integer> nums = new ArrayList<>();

			String s = st.nextToken();

			for (int i = 0; i < length; i++) {
				nums.add(s.charAt(i) - '0');

				if (nums.size() > 1 && nums.get(nums.size() - 1).equals(nums.get(nums.size() - 2))) {
					nums.remove(nums.size() - 1);
					nums.remove(nums.size() - 1);
				}
			}

			StringBuilder pw = new StringBuilder();

			for (int i = 0; i < nums.size(); i++) {
				pw.append(nums.get(i));
			}

			System.out.println("#" + t + " " + pw);
		}

	}

}
