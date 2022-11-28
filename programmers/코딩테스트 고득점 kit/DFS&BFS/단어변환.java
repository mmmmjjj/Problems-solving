import java.util.*;

/*
한 번에 한개의 알파벳 변환 가능
words에 있는 단어로만 변환 가능

최소 몇단계를 거쳐야 begin -> target이 되는지
*/

class Solution {
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        
        dfs(begin, target, words, new boolean[words.length],0);
        
        return answer;
    }
    
    public static void dfs(String begin, String target, String[] words, boolean[] v,int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!v[i]) {
                int n = 0;
                for(int j=0; j<words[i].length(); j++) {
                    if(words[i].charAt(j)!=begin.charAt(j))
                        n++;
                    if(n>1) break;
                }
                if(n==1) {
                    v[i] = true;
                    dfs(words[i], target, words, v, cnt+1);
                    v[i] = false;
                }
            } 
        }
        
        return;
    }
}

/*
+3
정확성  테스트
테스트 1 〉	통과 (0.03ms, 71.9MB)
테스트 2 〉	통과 (0.05ms, 72.9MB)
테스트 3 〉	통과 (0.16ms, 76.5MB)
테스트 4 〉	통과 (0.03ms, 78.6MB)
테스트 5 〉	통과 (0.03ms, 75.3MB)
 */