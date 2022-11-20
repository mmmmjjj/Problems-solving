import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(0,0,numbers, target);
    }
    
    public static int dfs(int cnt, int n, int[] numbers, int target) {
        
        if(cnt==numbers.length) {
            if(n==target) return 1;
            else return 0;
        }
        
        return dfs(cnt+1, n+numbers[cnt], numbers, target) +
            dfs(cnt+1,n-numbers[cnt], numbers, target);
    }
}