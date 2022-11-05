import java.util.*;

// N과 기호를 사용해서 number를 만든다.
// N을 최소한으로 사용
// 8보다 크면 -1 return
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<9; i++)
            list.add(new HashSet<Integer>());
        
        list.get(1).add(N);
        
        if(N==number) return 1;
        
        for(int i=2; i<9; i++) {
            Set<Integer> set = list.get(i);
            
            for(int j=1; j<=i; j++) {
                Set<Integer> pre = list.get(j);
                Set<Integer> post = list.get(i-j);
                
                for(int preNum : pre) {
                    for(int postNum : post) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        
                        if(preNum != 0 && postNum != 0)
                            set.add(preNum / postNum);
                    }
                }
            }
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            if(set.contains(number))
                return i;
        }
        
        return -1;
    }
}

/*
+9
정확성  테스트
테스트 1 〉	통과 (6.94ms, 78.3MB)
테스트 2 〉	통과 (0.07ms, 77.2MB)
테스트 3 〉	통과 (0.22ms, 73.3MB)
테스트 4 〉	통과 (52.23ms, 80.6MB)
테스트 5 〉	통과 (16.32ms, 81.7MB)
테스트 6 〉	통과 (0.76ms, 77MB)
테스트 7 〉	통과 (1.02ms, 76.7MB)
테스트 8 〉	통과 (20.06ms, 76MB)
테스트 9 〉	통과 (0.03ms, 79.9MB)
 */