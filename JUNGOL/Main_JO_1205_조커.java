package IMpractice;

import java.util.Arrays;
import java.util.Scanner;

public class Main_JO_1205_조커 {

	static int N; 
	static int[] nums; 
	static int max = 0, joker = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
			if (nums[i] == 0)
				joker++; 
		}

		Arrays.sort(nums); 

		if (joker != N) { 
			for (int i = joker; i < N - 1; i++) {
				straight(i, joker, 1);
			}
		}
		max = (joker == N) ? N : max; 
		System.out.println(max);

	}

	private static void straight(int n, int joker, int cnt) {

		if (n == N - 1) { 
			cnt+=joker; 
			max = Math.max(max, cnt);
			return;
		}

		int n1 = nums[n];
		int n2 = nums[n + 1];

		if (n2 == n1 + 1) { 
			straight(n + 1, joker, cnt + 1); 
		}

		else if (n2 > n1 + 1) { 
			if (n2 - n1 - 1 <= joker) { 
				straight(n + 1, joker - (n2 - n1 - 1), cnt + (n2 - n1)); 
			} else {
				cnt += joker; 
				max = Math.max(max, cnt);
				return;
			}
		} else if (n2 == n1) { 
			straight(n + 1, joker, cnt); 
		}

	}

}
