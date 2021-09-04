package sw_기초.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_6588_골든바흐 {

	static int [] prim;
	static int max=1000000;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		prim = new int[max+1];
		
		for (int i = 2; i < max; i++) {
			if(prim[i]==1)continue;
			
			for (int j = i*2; j < max; j+=i) {
				prim[j]=1;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			int n = Integer.parseInt(br.readLine());
			
			if(n==0)break;
			
			print(n);

		}
		
		System.out.println(sb);

	}

	private static void print(int n) {
		int a,b;
		
		for (int i = 3; i < max; i+=2) {
			if(prim[i]!=0) continue;
			a = i;
			b = n - a;
			if(prim[b]==0) {
				sb.append(n+" = "+a+" + "+b).append("\n");
				return;
			}
		}
		
		sb.append("Goldbach's conjecture is wrong.\n");
	}

}
