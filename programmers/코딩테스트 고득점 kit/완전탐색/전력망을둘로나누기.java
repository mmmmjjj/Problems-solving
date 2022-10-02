import java.util.*;

// 두 전력망이 갖는 송전탑의 개수를 최대한 비슷하게
// 이 때의 갯수 차이
// 인접리스트
class Solution {
    static List<Integer>[] adjList;
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        adjList = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] w: wires) {
            adjList[w[0]].add(w[1]);
            adjList[w[1]].add(w[0]);
        }
        
        // 와이어 하나씩 끊기
        for(int[] w: wires)
            answer = Math.min(bfs(w[0],w[1],n),answer);
        
        return answer;
    }
    
    public static int bfs(int a, int b,int n) {
        
        boolean[] v = new boolean[n+1];
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        
        v[1] = true;
        queue.add(1);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(Integer to: adjList[now]) {
                if(!v[to]) {
                    if((to==a&&now==b) || (to==b&&now==a)) continue;
                    
                    v[to] = true;
                    queue.add(to);
                    cnt++;
                }
            }
        }
        
        return Math.abs(n-2*cnt);
    }
}

/*
+6
정확성  테스트
테스트 1 〉	통과 (8.41ms, 71.4MB)
테스트 2 〉	통과 (6.82ms, 81.3MB)
테스트 3 〉	통과 (6.27ms, 79.9MB)
테스트 4 〉	통과 (6.17ms, 79.9MB)
테스트 5 〉	통과 (7.55ms, 78.8MB)
테스트 6 〉	통과 (0.27ms, 67.2MB)
테스트 7 〉	통과 (0.27ms, 73.3MB)
테스트 8 〉	통과 (0.88ms, 78.4MB)
테스트 9 〉	통과 (0.59ms, 88.7MB)
테스트 10 〉	통과 (4.61ms, 77.1MB)
테스트 11 〉	통과 (5.42ms, 70MB)
테스트 12 〉	통과 (4.46ms, 81.3MB)
테스트 13 〉	통과 (6.11ms, 72.4MB)
 */