package IMpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2567_색종이2 {

	static int[][] map;
	static int L = 102;
	static int T;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
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
		
		for (int i = 0 ; i < L; i++) {
			for (int j = 0; j < L; j++) {
				if(map[i][j]==1) {
					for (int k = 0; k < 4; k++) {
						int nr = i+dr[k];
						int nc = j+dc[k];
						
						if(!check(nr,nc)) continue;
						if(map[nr][nc]==0) result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}

	private static boolean check(int nr, int nc) {
		return nr>=0&&nr<L&&nc>=0&&nc<L;
	}

}
