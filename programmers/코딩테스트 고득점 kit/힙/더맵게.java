import java.util.*;

/*
모든 스코빌 지수를 k 이상
가장 낮은 두 음식을 섞음
가장 안매운 지수 + 두번째 지수 *2
섞어야 하는 최소 횟수
*/
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int n : scoville) {
            queue.add(n);
        }
        
        while(queue.peek()<K) {
            if(queue.size() == 1) return -1;
            int n = queue.poll() + queue.poll()*2;
            queue.add(n);
            answer++;
        }
        
        return answer;
    }
}