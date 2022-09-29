import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] arr: clothes) 
            map.put(arr[1], map.getOrDefault(arr[1], 1) +1);
        
        for(String key: map.keySet()) 
            answer *= map.get(key);
        
        return answer-1;
    }
    
}

/*
+5
정확성  테스트
테스트 1 〉	통과 (0.06ms, 77.4MB)
테스트 2 〉	통과 (0.05ms, 81.6MB)
테스트 3 〉	통과 (0.05ms, 77MB)
테스트 4 〉	통과 (0.11ms, 72.9MB)
테스트 5 〉	통과 (0.11ms, 69.4MB)
테스트 6 〉	통과 (0.06ms, 87.1MB)
테스트 7 〉	통과 (0.07ms, 82.9MB)
테스트 8 〉	통과 (0.10ms, 76.1MB)
테스트 9 〉	통과 (0.06ms, 74.2MB)
테스트 10 〉	통과 (0.05ms, 75.8MB)
테스트 11 〉	통과 (0.06ms, 73.8MB)
테스트 12 〉	통과 (0.10ms, 74.3MB)
테스트 13 〉	통과 (0.07ms, 78.8MB)
테스트 14 〉	통과 (0.05ms, 77.3MB)
테스트 15 〉	통과 (0.07ms, 73.2MB)
테스트 16 〉	통과 (0.06ms, 77MB)
테스트 17 〉	통과 (0.07ms, 64.3MB)
테스트 18 〉	통과 (0.05ms, 74.2MB)
테스트 19 〉	통과 (0.07ms, 76.5MB)
테스트 20 〉	통과 (0.07ms, 75.4MB)
테스트 21 〉	통과 (0.04ms, 77.9MB)
테스트 22 〉	통과 (0.04ms, 75.8MB)
테스트 23 〉	통과 (0.03ms, 76.4MB)
테스트 24 〉	통과 (0.09ms, 75.3MB)
테스트 25 〉	통과 (0.04ms, 74.9MB)
테스트 26 〉	통과 (0.08ms, 71.9MB)
테스트 27 〉	통과 (0.07ms, 74.3MB)
테스트 28 〉	통과 (0.10ms, 76MB)
 */