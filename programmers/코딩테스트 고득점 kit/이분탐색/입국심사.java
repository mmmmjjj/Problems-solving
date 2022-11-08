import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int tNum = times.length;
        
        Arrays.sort(times);
        
        long left=0;
        long right= (long) times[tNum-1] * n;
        
        while(left <= right) {
            
            // 이 시간안에 가능하면 left - mid 탐색
            // 불가능하면 mid - right 탐색
            long mid = (left + right) / 2;
            
            long sum = 0;
            for(int i=0; i<tNum; i++)
                sum += (mid / times[i]);
            
            if(sum < n)
                left = mid + 1;
            else {
                right = mid -1;
                answer = mid;
            }
        }
        return answer;
    }
}

/*
+5
정확성  테스트
테스트 1 〉	통과 (0.52ms, 67MB)
테스트 2 〉	통과 (0.46ms, 66.9MB)
테스트 3 〉	통과 (2.69ms, 77.2MB)
테스트 4 〉	통과 (132.93ms, 108MB)
테스트 5 〉	통과 (126.53ms, 107MB)
테스트 6 〉	통과 (105.17ms, 87.1MB)
테스트 7 〉	통과 (130.62ms, 96MB)
테스트 8 〉	통과 (102.80ms, 96.7MB)
테스트 9 〉	통과 (0.59ms, 72.6MB)
 */