import java.util.*;

// 정해진 순서로 트럭이 다리를 건넌다.
// 다리는 최대 중량이 있기 때문에 특정 무게를 넘길 수 없다.
// 1. 트럭을 다리에 올린다.
// 2. 그 다음 트럭이 올라갈 수 있는지 체크
// 3. 가능하다면 다음 트럭도 올린다.
// 4. 불가능하다면 맨 앞 트럭을 도착시킨다.

// length가 5일 때 , 1초에 다리에 오른 트럭은 1,2,3,4,5 동안 올라가 있는다.
class Solution {
    public int solution(int length, int w, int[] trucks) {
        int weight = 0;
        int sec = 1;
        Deque<Node> deque = new ArrayDeque<>();
        for(int i=0; i< trucks.length; i++) {
            
            if(!deque.isEmpty()) {
                if(deque.peekFirst().s+length == sec) {
                    Node node = deque.pollFirst();
                    weight -= node.w;
                }
            }
            
            // 중량 내라면
            if(w>=weight+trucks[i]) {
                deque.add(new Node(trucks[i], sec++));
                weight += trucks[i];
            } 
            else {
                Node node = deque.pollFirst();
                sec = node.s + length;
                weight -= node.w;
                i--;
            }
        }
        
        return length+deque.pollLast().s;
    }
    
    public static class Node{
        int w;
        int s;
        
        public Node(int w, int s) {
            this.w = w;
            this.s = s;
        }
    }
}

/*
+6
정확성  테스트
테스트 1 〉	통과 (0.22ms, 75MB)
테스트 2 〉	통과 (0.26ms, 77.9MB)
테스트 3 〉	통과 (1.28ms, 66.9MB)
테스트 4 〉	통과 (0.89ms, 77MB)
테스트 5 〉	통과 (0.95ms, 77.1MB)
테스트 6 〉	통과 (1.53ms, 83.8MB)
테스트 7 〉	통과 (0.30ms, 71.4MB)
테스트 8 〉	통과 (0.30ms, 83.5MB)
테스트 9 〉	통과 (0.81ms, 71MB)
테스트 10 〉	통과 (0.30ms, 73MB)
테스트 11 〉	통과 (0.35ms, 75.9MB)
테스트 12 〉	통과 (0.30ms, 69.9MB)
테스트 13 〉	통과 (0.51ms, 75.6MB)
테스트 14 〉	통과 (0.26ms, 99.1MB)
 */