import java.util.*;

// 누적합?
// 5 0 0 -5
// 0 0 0 0
// -5 0 0 5
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] sum = new int[n+1][m+1];
        
        for(int[] s: skill) {
            int degree = s[5] * (s[0]==1?-1:1);
            
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            
            sum[r1][c1] += degree;
            sum[r1][c2+1] -= degree;
            sum[r2+1][c1] -= degree;
            sum[r2+1][c2+1] += degree;
        }      
        
        for(int r=1; r<n; r++) {
            for(int c=0; c<m; c++)
                sum[r][c] += sum[r-1][c];
        }
        
        for(int c=1; c<m; c++) {
            for(int r=0; r<n; r++)
                sum[r][c] += sum[r][c-1];
        }
        
        for(int r=0; r<n; r++)
            for(int c=0; c<m; c++) {
                if(sum[r][c] + board[r][c] >0) answer++;
            }
        
        return answer;
    }
}

/*
+14
정확성  테스트
테스트 1 〉	통과 (0.02ms, 74.3MB)
테스트 2 〉	통과 (0.04ms, 75.1MB)
테스트 3 〉	통과 (0.09ms, 67.9MB)
테스트 4 〉	통과 (0.09ms, 70.9MB)
테스트 5 〉	통과 (0.23ms, 86.6MB)
테스트 6 〉	통과 (0.23ms, 75.5MB)
테스트 7 〉	통과 (0.29ms, 76.9MB)
테스트 8 〉	통과 (0.43ms, 75.9MB)
테스트 9 〉	통과 (0.87ms, 79.6MB)
테스트 10 〉	통과 (1.26ms, 78.5MB)
효율성  테스트
테스트 1 〉	통과 (54.25ms, 216MB)
테스트 2 〉	통과 (48.06ms, 214MB)
테스트 3 〉	통과 (48.71ms, 209MB)
테스트 4 〉	통과 (51.91ms, 222MB)
테스트 5 〉	통과 (45.15ms, 219MB)
테스트 6 〉	통과 (47.08ms, 219MB)
테스트 7 〉	통과 (49.42ms, 218MB)
 */