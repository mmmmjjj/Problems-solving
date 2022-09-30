import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int a = 0, b = 0;
        
        for(int[] arr: sizes) {
            a = Math.max(a, Math.max(arr[0], arr[1]));
            b = Math.max(b, Math.min(arr[0], arr[1]));
        }
        
        return a*b;
    }
}

/*
+1
정확성  테스트
테스트 1 〉	통과 (0.02ms, 70.7MB)
테스트 2 〉	통과 (0.06ms, 78.1MB)
테스트 3 〉	통과 (0.04ms, 76.8MB)
테스트 4 〉	통과 (0.04ms, 76.7MB)
테스트 5 〉	통과 (0.04ms, 73.1MB)
테스트 6 〉	통과 (0.04ms, 73.6MB)
테스트 7 〉	통과 (0.04ms, 78.3MB)
테스트 8 〉	통과 (0.03ms, 70.7MB)
테스트 9 〉	통과 (0.03ms, 82.5MB)
테스트 10 〉	통과 (0.04ms, 78MB)
테스트 11 〉	통과 (0.08ms, 86.3MB)
테스트 12 〉	통과 (0.12ms, 74.8MB)
테스트 13 〉	통과 (0.22ms, 81.9MB)
테스트 14 〉	통과 (0.40ms, 84.1MB)
테스트 15 〉	통과 (0.66ms, 83.6MB)
테스트 16 〉	통과 (0.97ms, 82.4MB)
테스트 17 〉	통과 (1.49ms, 89.2MB)
테스트 18 〉	통과 (1.62ms, 85.4MB)
테스트 19 〉	통과 (2.03ms, 93.7MB)
테스트 20 〉	통과 (2.20ms, 93.7MB)
 */