package algo_0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이 {

	static int[][] map;
	static int L = 100;
	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		map = new int[L][L];
		int result = 0;
		
		for (int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int i = r; i < r+10; i++) {
				for (int j = c; j < c+10; j++) {
					map[i][j]=1;
				}
			}
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				if(map[i][j]==1) result++;
			}
		}
		System.out.println(result);
	}

}
