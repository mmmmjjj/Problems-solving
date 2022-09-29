import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++) 
            set.add(nums[i]);
        
        if(n/2 < set.size())
            return n/2;
        
        else return set.size();
    }
}