import java.util.*;

// 가장 앞 문서 꺼냄
// 더 중요한 문서가 있다면 뒤로 보냄
// 목표 : location번째의 문서가 몇번째로 인쇄되는지

// 대기목록이 최대 100개 이기 때문에 그냥 노가다로 다 뒤로 보내야겠다.
// 큐에 모두 삽입 (삽입하면서 숫자 체크 (최대값을 기억하기 위해))
class Solution {
  public int solution(int[] p, int location) {
    ArrayList<Integer> list = new ArrayList<>();
    Queue<Paper> queue = new LinkedList<>();

    for (int i = 0; i < p.length; i++) {
      queue.add(new Paper(i, p[i]));
      list.add(p[i]);
    }

    list.sort(Comparator.reverseOrder());
    int cnt = 1;
    while (!queue.isEmpty()) {
      int max = list.get(0);

      if (queue.peek().p < max)
        queue.add(queue.poll());
      else {
        if (queue.peek().l == location)
          return cnt;
        else {
          queue.poll();
          list.remove(0);
          cnt++;
        }
      }
    }

    return 0;
  }

  public static class Paper {
    int l;
    int p;

    public Paper(int l, int p) {
      this.l = l;
      this.p = p;
    }
  }
}


/*
+4
정확성  테스트
테스트 1 〉	통과 (0.91ms, 75.6MB)
테스트 2 〉	통과 (2.06ms, 74.6MB)
테스트 3 〉	통과 (0.93ms, 78.8MB)
테스트 4 〉	통과 (0.73ms, 79.1MB)
테스트 5 〉	통과 (0.67ms, 76.6MB)
테스트 6 〉	통과 (0.93ms, 74.4MB)
테스트 7 〉	통과 (0.92ms, 81.3MB)
테스트 8 〉	통과 (1.61ms, 75.2MB)
테스트 9 〉	통과 (0.60ms, 73.7MB)
테스트 10 〉	통과 (0.98ms, 72.7MB)
테스트 11 〉	통과 (1.49ms, 77.8MB)
테스트 12 〉	통과 (0.67ms, 74.5MB)
테스트 13 〉	통과 (1.51ms, 77.8MB)
테스트 14 〉	통과 (1.01ms, 78.5MB)
테스트 15 〉	통과 (1.39ms, 79.7MB)
테스트 16 〉	통과 (1.31ms, 79MB)
테스트 17 〉	통과 (1.43ms, 75.4MB)
테스트 18 〉	통과 (0.81ms, 84.6MB)
테스트 19 〉	통과 (1.31ms, 79.1MB)
테스트 20 〉	통과 (1.43ms, 79MB)
 */