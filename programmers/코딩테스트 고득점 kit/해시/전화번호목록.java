import java.util.*;

// 접두어 존재 여부 있음 : false
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}

/*
+7
정확성  테스트
테스트 1 〉	통과 (0.35ms, 71MB)
테스트 2 〉	통과 (0.24ms, 78.6MB)
테스트 3 〉	통과 (0.19ms, 76.8MB)
테스트 4 〉	통과 (0.27ms, 71.7MB)
테스트 5 〉	통과 (0.21ms, 77.3MB)
테스트 6 〉	통과 (0.28ms, 72.3MB)
테스트 7 〉	통과 (0.21ms, 77.4MB)
테스트 8 〉	통과 (0.17ms, 76.6MB)
테스트 9 〉	통과 (0.18ms, 74.1MB)
테스트 10 〉	통과 (0.17ms, 73.2MB)
테스트 11 〉	통과 (0.21ms, 74.3MB)
테스트 12 〉	통과 (0.17ms, 73.4MB)
테스트 13 〉	통과 (0.23ms, 73.6MB)
테스트 14 〉	통과 (2.45ms, 79.7MB)
테스트 15 〉	통과 (2.82ms, 82.4MB)
테스트 16 〉	통과 (2.65ms, 77MB)
테스트 17 〉	통과 (3.89ms, 83.6MB)
테스트 18 〉	통과 (4.58ms, 92.3MB)
테스트 19 〉	통과 (6.45ms, 78.4MB)
테스트 20 〉	통과 (5.23ms, 83.1MB)
효율성  테스트
테스트 1 〉	통과 (29.14ms, 56.3MB)
테스트 2 〉	통과 (17.83ms, 55.7MB)
테스트 3 〉	통과 (408.98ms, 96.8MB)
테스트 4 〉	통과 (282.46ms, 95.6MB)
 */