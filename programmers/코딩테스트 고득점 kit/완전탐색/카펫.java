import java.util.*;

// 가로 >= 세로
// 테두리 : 갈색 | 안쪽 : 노란색

// 1. 곱했을 때 brown+yellow가 되는 쌍 구하기
// 2. 그 중 yellow = (a-2) * (b-2) 가 성립하는 쌍 리턴
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = yellow + brown;
        
        for(int i= 3; i<area; i++) {
            if(area%i==0) {
                int a = area/i;
                int b = i;
                
                if(yellow == (a-2)*(b-2)) {
                    answer[0] = a;
                    answer[1] = b;
                    break;
                }
            }
        }
        
        return answer;
    }
}

/*
+4
정확성  테스트
테스트 1 〉	통과 (0.02ms, 79.4MB)
테스트 2 〉	통과 (0.02ms, 76.8MB)
테스트 3 〉	통과 (0.04ms, 76.7MB)
테스트 4 〉	통과 (0.02ms, 74.4MB)
테스트 5 〉	통과 (0.02ms, 77.1MB)
테스트 6 〉	통과 (0.03ms, 74.2MB)
테스트 7 〉	통과 (0.02ms, 75.4MB)
테스트 8 〉	통과 (0.04ms, 73MB)
테스트 9 〉	통과 (0.04ms, 76MB)
테스트 10 〉	통과 (0.03ms, 73.7MB)
테스트 11 〉	통과 (0.03ms, 67.3MB)
테스트 12 〉	통과 (0.02ms, 76.6MB)
테스트 13 〉	통과 (0.02ms, 75MB)
 */