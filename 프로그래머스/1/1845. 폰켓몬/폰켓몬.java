import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> poket = new HashMap<>();
        
        for(int i : nums) {
            poket.put(i, poket.getOrDefault(i, 0)+1);
        }
        
        int n = nums.length;
        int answer = 0;
        if(n/2 < poket.size()) answer = n/2;
        else answer = poket.size();
        
        return answer;
    }
}