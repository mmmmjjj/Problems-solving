import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}

/*
+5
정확성  테스트
테스트 1 〉	통과 (0.02ms, 80.4MB)
테스트 2 〉	통과 (0.03ms, 79.4MB)
테스트 3 〉	통과 (0.18ms, 83.4MB)
테스트 4 〉	통과 (0.25ms, 82MB)
테스트 5 〉	통과 (0.35ms, 77.3MB)
테스트 6 〉	통과 (0.03ms, 82.6MB)
테스트 7 〉	통과 (0.15ms, 75.5MB)
테스트 8 〉	통과 (0.13ms, 70.3MB)
테스트 9 〉	통과 (0.02ms, 76.8MB)
테스트 10 〉	통과 (0.31ms, 79.5MB)
효율성  테스트
테스트 1 〉	통과 (12.84ms, 66.7MB)
테스트 2 〉	통과 (16.05ms, 68.6MB)
테스트 3 〉	통과 (15.35ms, 69.4MB)
테스트 4 〉	통과 (17.08ms, 69.8MB)
테스트 5 〉	통과 (12.17ms, 66.6MB)
 */