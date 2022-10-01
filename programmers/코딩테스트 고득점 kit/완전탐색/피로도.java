import java.util.*;

class Solution {
    static int max = 0;
    static boolean[] v;
    public int solution(int k, int[][] dungeons) {
        
        v = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return max;
    }
    
    public static void dfs(int cnt, int tired, int[][] dungeons) {
        
        for(int i=0; i<dungeons.length; i++) {
            if(v[i]) continue;
            
            if(tired >= dungeons[i][0] && tired >= dungeons[i][1]) {
                v[i] = true;
                dfs(cnt+1, tired-dungeons[i][1], dungeons);
                v[i] = false;
            }
        }
        
        max = Math.max(max, cnt);
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 73.1MB)
테스트 2 〉	통과 (0.03ms, 73.4MB)
테스트 3 〉	통과 (0.04ms, 75.5MB)
테스트 4 〉	통과 (0.11ms, 74.3MB)
테스트 5 〉	통과 (0.32ms, 73.9MB)
테스트 6 〉	통과 (0.70ms, 77.7MB)
테스트 7 〉	통과 (2.39ms, 75.3MB)
테스트 8 〉	통과 (3.49ms, 76.9MB)
테스트 9 〉	통과 (0.05ms, 78.5MB)
테스트 10 〉	통과 (0.38ms, 75.9MB)
테스트 11 〉	통과 (0.03ms, 77.9MB)
테스트 12 〉	통과 (0.61ms, 77.5MB)
테스트 13 〉	통과 (0.21ms, 92.7MB)
테스트 14 〉	통과 (0.06ms, 91MB)
테스트 15 〉	통과 (0.05ms, 100MB)
테스트 16 〉	통과 (0.04ms, 76.1MB)
테스트 17 〉	통과 (0.05ms, 78.4MB)
테스트 18 〉	통과 (0.05ms, 75.2MB)
테스트 19 〉	통과 (0.06ms, 79.8MB)
*/