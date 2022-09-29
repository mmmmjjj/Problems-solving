import java.util.*;

// h-index : h번 이상 인용된 논문이 h편 이상인 수 중 최댓값
class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);
        // 정렬을 하면 인용 횟수 오름차순으로 정렬된다.
        // 0 1 3 5 6
        
        for(int i=0; i<n; i++) {
            int h = n-i; // citations[i]편 이상 인용된 논문 수
            // h가 citations[i]보다 크다면 H-index 성립
            if(h <= citations[i]) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}