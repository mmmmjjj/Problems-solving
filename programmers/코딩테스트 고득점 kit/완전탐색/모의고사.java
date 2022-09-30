import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            
            if((i+1)%5 == answers[i]%5)
                score[0]++;
            
            if(answers[i] == s2[i%8])
                score[1]++;
            
            if(answers[i] == s3[i%10])
                score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1],score[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(score[i] == max)
                list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}

/*
+5
정확성  테스트
테스트 1 〉	통과 (0.05ms, 73.1MB)
테스트 2 〉	통과 (0.06ms, 77.8MB)
테스트 3 〉	통과 (0.05ms, 74MB)
테스트 4 〉	통과 (0.07ms, 73.5MB)
테스트 5 〉	통과 (0.08ms, 72.2MB)
테스트 6 〉	통과 (0.06ms, 75.2MB)
테스트 7 〉	통과 (0.34ms, 75.3MB)
테스트 8 〉	통과 (0.19ms, 74.4MB)
테스트 9 〉	통과 (0.53ms, 71.4MB)
테스트 10 〉	통과 (0.29ms, 83.9MB)
테스트 11 〉	통과 (0.64ms, 78.6MB)
테스트 12 〉	통과 (0.64ms, 71.9MB)
테스트 13 〉	통과 (0.13ms, 74.2MB)
테스트 14 〉	통과 (1.09ms, 77.4MB)
 */