import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int r=1; r<triangle.length; r++) {
            triangle[r][0] += triangle[r-1][0];
            
            for(int c=1; c<triangle[r].length-1; c++) {
                triangle[r][c] += Math.max(triangle[r-1][c-1],triangle[r-1][c]);
            }
            
            triangle[r][triangle[r].length-1] 
                += triangle[r-1][triangle[r-1].length-1];
        }
        
        for(int n : triangle[triangle.length-1])
            answer = Math.max(answer, n);
        
        return answer;
    }
}

/*
+2
정확성  테스트
테스트 1 〉	통과 (0.04ms, 64.4MB)
테스트 2 〉	통과 (0.03ms, 67.4MB)
테스트 3 〉	통과 (0.05ms, 67.6MB)
테스트 4 〉	통과 (0.08ms, 74.9MB)
테스트 5 〉	통과 (0.32ms, 78.8MB)
테스트 6 〉	통과 (0.13ms, 83MB)
테스트 7 〉	통과 (0.35ms, 83.1MB)
테스트 8 〉	통과 (0.07ms, 76.8MB)
테스트 9 〉	통과 (0.03ms, 73.4MB)
테스트 10 〉	통과 (0.07ms, 76.7MB)
효율성  테스트
테스트 1 〉	통과 (7.31ms, 63.5MB)
테스트 2 〉	통과 (5.94ms, 59MB)
테스트 3 〉	통과 (8.08ms, 60.6MB)
테스트 4 〉	통과 (10.58ms, 60.4MB)
테스트 5 〉	통과 (6.50ms, 60.7MB)
테스트 6 〉	통과 (8.43ms, 66.8MB)
테스트 7 〉	통과 (8.81ms, 60MB)
테스트 8 〉	통과 (16.14ms, 73MB)
테스트 9 〉	통과 (7.48ms, 60.2MB)
테스트 10 〉	통과 (8.44ms, 60.7MB)
 */