import java.util.*;

// 한 자리 숫자들을 조합해 만들 수 있는 소수 갯수
class Solution {
    static boolean[] arr;
    static int answer = 0;

    public int solution(String numbers) {
        arr = new boolean[10000000];
        
        arr[0]  = arr[1] = true;
        for(int i=2; i<5000000; i++) {
            if(arr[i]) continue;
            
            int n = i+i;
            while(n<10000000) {
                arr[n] = true;
                n += i;
            }
        }
        
        for(int i=1; i<=numbers.length(); i++)
            perm(0,i,new boolean[numbers.length()],"",numbers);
        
        return answer;
    }
    
    public static void perm(int cnt,int r, boolean[] v,String num, String numbers) {
        if(cnt == r) {
            int n = Integer.valueOf(num);
            if(!arr[n]) {
                answer++;
                arr[n] = true;
            }
            return;
        }
        
        for(int i=0; i < numbers.length(); i++) {
            if(v[i]) continue;
            
            v[i] = true;
            perm(cnt+1,r,v, num+numbers.charAt(i), numbers);
            v[i] = false;
        }
    }
}

/*
+6
정확성  테스트
테스트 1 〉	통과 (111.89ms, 84.6MB)
테스트 2 〉	통과 (107.32ms, 102MB)
테스트 3 〉	통과 (131.40ms, 87.3MB)
테스트 4 〉	통과 (107.52ms, 104MB)
테스트 5 〉	통과 (100.37ms, 97.1MB)
테스트 6 〉	통과 (95.28ms, 86.5MB)
테스트 7 〉	통과 (113.53ms, 97.8MB)
테스트 8 〉	통과 (107.08ms, 99.8MB)
테스트 9 〉	통과 (86.53ms, 95.3MB)
테스트 10 〉	통과 (92.76ms, 84.7MB)
테스트 11 〉	통과 (106.22ms, 95.9MB)
테스트 12 〉	통과 (89.68ms, 102MB)
 */