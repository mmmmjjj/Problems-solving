import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int pre = 10;
        List<Integer> list = new ArrayList<>();

        for(int n : arr) {
            if(pre!=n) {
                list.add(n);
                pre = n;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

/*
+1
정확성  테스트
테스트 1 〉	통과 (0.03ms, 75MB)
테스트 2 〉	통과 (0.09ms, 74.7MB)
테스트 3 〉	통과 (0.10ms, 75.4MB)
테스트 4 〉	통과 (0.06ms, 78.7MB)
테스트 5 〉	통과 (0.05ms, 72.8MB)
테스트 6 〉	통과 (0.06ms, 76.3MB)
테스트 7 〉	통과 (0.07ms, 81.6MB)
테스트 8 〉	통과 (0.04ms, 71.9MB)
테스트 9 〉	통과 (0.10ms, 83.6MB)
테스트 10 〉	통과 (0.07ms, 72.9MB)
테스트 11 〉	통과 (0.04ms, 71.4MB)
테스트 12 〉	통과 (0.04ms, 74MB)
테스트 13 〉	통과 (0.06ms, 77.9MB)
테스트 14 〉	통과 (0.06ms, 71.6MB)
테스트 15 〉	통과 (0.05ms, 85.4MB)
테스트 16 〉	통과 (0.11ms, 76MB)
테스트 17 〉	통과 (0.03ms, 75.1MB)
효율성  테스트
테스트 1 〉	통과 (22.77ms, 109MB)
테스트 2 〉	통과 (23.04ms, 115MB)
테스트 3 〉	통과 (24.13ms, 110MB)
테스트 4 〉	통과 (26.17ms, 113MB)
 */