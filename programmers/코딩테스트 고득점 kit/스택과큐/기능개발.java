import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];
        
        for(int i=0; i<days.length; i++) {
            days[i] = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]>0)
                days[i]++;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int day = days[0];
        int cnt = 1;
        for(int i=1; i<days.length; i++) {
            
            if(day >= days[i]) cnt++;
            else {
                list.add(cnt);
                cnt = 1;
                day = days[i];
            }
        }
        
        if(cnt!=0) list.add(cnt);
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++)
            answer[i] = list.get(i);
            
        return answer;
    }
}

/*
+4
정확성  테스트
테스트 1 〉	통과 (0.02ms, 73.2MB)
테스트 2 〉	통과 (0.03ms, 77.1MB)
테스트 3 〉	통과 (0.05ms, 81.8MB)
테스트 4 〉	통과 (0.03ms, 73.5MB)
테스트 5 〉	통과 (0.03ms, 75.7MB)
테스트 6 〉	통과 (0.03ms, 65.9MB)
테스트 7 〉	통과 (0.04ms, 75.4MB)
테스트 8 〉	통과 (0.04ms, 76.4MB)
테스트 9 〉	통과 (0.04ms, 82.3MB)
테스트 10 〉	통과 (0.07ms, 79.8MB)
테스트 11 〉	통과 (0.04ms, 82.2MB)
 */