import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        if(s.charAt(0)==')') return false;
        
        for(char c: s.toCharArray()) {
            if(c=='(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}

/*
+5
정확성  테스트
테스트 1 〉	통과 (0.31ms, 80.8MB)
테스트 2 〉	통과 (0.14ms, 75.8MB)
테스트 3 〉	통과 (0.22ms, 81.3MB)
테스트 4 〉	통과 (0.27ms, 74.3MB)
테스트 5 〉	통과 (0.24ms, 76.6MB)
테스트 6 〉	통과 (0.14ms, 86.7MB)
테스트 7 〉	통과 (0.19ms, 75.7MB)
테스트 8 〉	통과 (0.21ms, 78.3MB)
테스트 9 〉	통과 (0.23ms, 75.4MB)
테스트 10 〉	통과 (0.21ms, 76.5MB)
테스트 11 〉	통과 (0.21ms, 79.6MB)
테스트 12 〉	통과 (0.31ms, 80.5MB)
테스트 13 〉	통과 (0.31ms, 77MB)
테스트 14 〉	통과 (0.36ms, 84.6MB)
테스트 15 〉	통과 (0.34ms, 73.8MB)
테스트 16 〉	통과 (0.30ms, 80.3MB)
테스트 17 〉	통과 (0.22ms, 77.3MB)
테스트 18 〉	통과 (0.25ms, 77.1MB)
효율성  테스트
테스트 1 〉	통과 (19.09ms, 52.7MB)
테스트 2 〉	통과 (18.16ms, 53.7MB)
*/