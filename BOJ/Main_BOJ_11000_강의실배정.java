import java.util.*;
import java.io.*;

/*
    강의실 배정
    골드 5
    시간 : 640ms
    메모리 : 73444kb
*/

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Lecture []lectures = new Lecture[N];

        // 강의실 리스트
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.start-o2.start;
            }
        });

        queue.add(lectures[0].end);

        for (int i = 1; i < N; i++) {

            if(queue.peek()<=lectures[i].start) {
                queue.poll();
            }
            queue.add(lectures[i].end);

        }

        System.out.println(queue.size());
    }

    public static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}