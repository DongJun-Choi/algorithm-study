import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String s = clothes[i][1];
            map.put(s, map.getOrDefault(s, 1) + 1);
        }
        
        int answer = 1;
        
        for(Integer value : map.values()) {
            answer *= value;
        }
        
        return answer-1;
    }
}