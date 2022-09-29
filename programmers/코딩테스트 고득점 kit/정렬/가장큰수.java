import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< str.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        
        if(str[0].equals("0")) sb.append("0");
        else 
        for(int i=0; i<str.length; i++){
                sb.append(str[i]);
            }
        
        return sb.toString();
    }
}