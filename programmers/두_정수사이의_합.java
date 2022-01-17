class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        int B = Math.max(a,b);
        int A = Math.min(a,b);

        for(int i = A; i<=B; i++) {
            answer += i;
        }

        return answer;
    }
}
