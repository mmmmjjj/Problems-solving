import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        do {
            answer++;
            
            while(left<right) {
                if(people[left] + people[right--] > limit)
                    answer++;
                else break;
            }
            
            left++;
        } while(left<=right);   
        
        return answer;
    }
}

/*
+7
정확성  테스트
테스트 1 〉	통과 (2.08ms, 81.2MB)
테스트 2 〉	통과 (1.81ms, 76.2MB)
테스트 3 〉	통과 (1.77ms, 72.2MB)
테스트 4 〉	통과 (1.88ms, 73.8MB)
테스트 5 〉	통과 (1.29ms, 80.2MB)
테스트 6 〉	통과 (0.97ms, 87.6MB)
테스트 7 〉	통과 (0.86ms, 70.8MB)
테스트 8 〉	통과 (0.39ms, 84.3MB)
테스트 9 〉	통과 (0.60ms, 81.4MB)
테스트 10 〉	통과 (1.59ms, 76.5MB)
테스트 11 〉	통과 (1.85ms, 76MB)
테스트 12 〉	통과 (1.47ms, 75.2MB)
테스트 13 〉	통과 (1.52ms, 73.7MB)
테스트 14 〉	통과 (1.31ms, 77.2MB)
테스트 15 〉	통과 (0.67ms, 72.6MB)
효율성  테스트
테스트 1 〉	통과 (9.32ms, 54.1MB)
테스트 2 〉	통과 (9.64ms, 53.1MB)
테스트 3 〉	통과 (12.10ms, 56.2MB)
테스트 4 〉	통과 (7.62ms, 53.8MB)
테스트 5 〉	통과 (9.07ms, 53.5MB)
채점 결과
정확성: 75.0
효율성: 25.0
합계: 100.0 / 100.0
 */