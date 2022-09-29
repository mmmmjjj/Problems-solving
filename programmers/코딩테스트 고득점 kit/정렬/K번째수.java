import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] cmds) {
        int[] answer = new int[cmds.length];
        int n = 0;
        
        for(int[] cmd: cmds) {
            
            int[] arr = Arrays.copyOfRange(array,cmd[0]-1,cmd[1]);
            
            Arrays.sort(arr);
            answer[n++] = arr[cmd[2]-1];
            
        }
        
        return answer;
    }
}
