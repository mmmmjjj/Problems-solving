import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i;
        for(i=0; i<completion.length; i++) {
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        
        return participant[i];
    }
}

/*
+4
정확성  테스트
테스트 1 〉	통과 (0.20ms, 75.7MB)
테스트 2 〉	통과 (0.24ms, 74.9MB)
테스트 3 〉	통과 (1.80ms, 79.6MB)
테스트 4 〉	통과 (3.52ms, 80.2MB)
테스트 5 〉	통과 (3.86ms, 80.5MB)
효율성  테스트
테스트 1 〉	통과 (141.19ms, 81.9MB)
테스트 2 〉	통과 (250.59ms, 88.4MB)
테스트 3 〉	통과 (328.93ms, 94.1MB)
테스트 4 〉	통과 (334.18ms, 95.4MB)
테스트 5 〉	통과 (284.76ms, 96.6MB)
 */