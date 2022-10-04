import java.util.*;

class Solution {
    
    public String solution(String p) {
        return func(p);
    }
    
    public static String func(String s) {
        
        if(s=="") return "";
        if(check(s)) return s;
        
        // 1. u v 로 나눈다.
        int n=0;
        String u="",v="";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') n++;
            else n--;
            
            if(n==0) {
                u = s.substring(0,i+1);
                v = (i==s.length()-1) ? "" : s.substring(i+1,s.length());
                break;
            }
        }
        
        v = func(v);
        
        boolean b = check(u);
        // 2. u가 올바르면
        if(b) return u+v;
        
        // 3. 올바르지 않다면
        StringBuilder sb = new StringBuilder();
        sb.append("(" + v + ")");
        u = u.substring(1,u.length()-1);
        // 거꾸로가 아니라 괄호를 반대로 붙이기
        for(int i=0; i<u.length(); i++) {
            String str = (u.charAt(i)=='(') ? ")" : "(";
            sb.append(str);
        }
        
        return sb.toString();
    }
    
    // 올바른지 체크
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(')
                stack.push('(');
            else {
                if(stack.isEmpty())
                    return false;
                else stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}

/*
+6
정확성  테스트
테스트 1 〉	통과 (0.17ms, 70.1MB)
테스트 2 〉	통과 (6.18ms, 75.2MB)
테스트 3 〉	통과 (0.25ms, 75.8MB)
테스트 4 〉	통과 (7.30ms, 75.9MB)
테스트 5 〉	통과 (0.18ms, 72.5MB)
테스트 6 〉	통과 (7.67ms, 86.4MB)
테스트 7 〉	통과 (9.53ms, 73.9MB)
테스트 8 〉	통과 (0.19ms, 84.6MB)
테스트 9 〉	통과 (8.13ms, 78.3MB)
테스트 10 〉	통과 (7.08ms, 76.8MB)
테스트 11 〉	통과 (8.77ms, 73MB)
테스트 12 〉	통과 (6.89ms, 79.7MB)
테스트 13 〉	통과 (6.61ms, 76.2MB)
테스트 14 〉	통과 (7.96ms, 77.3MB)
테스트 15 〉	통과 (9.56ms, 77.6MB)
테스트 16 〉	통과 (7.94ms, 77MB)
테스트 17 〉	통과 (10.83ms, 78MB)
테스트 18 〉	통과 (7.81ms, 76.2MB)
테스트 19 〉	통과 (7.56ms, 70MB)
테스트 20 〉	통과 (8.30ms, 76.6MB)
테스트 21 〉	통과 (8.61ms, 76.7MB)
테스트 22 〉	통과 (7.82ms, 67.1MB)
테스트 23 〉	통과 (10.01ms, 79.2MB)
테스트 24 〉	통과 (8.55ms, 76.6MB)
테스트 25 〉	통과 (7.20ms, 75.8MB)
 */