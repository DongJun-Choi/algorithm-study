import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (s, o) -> {
            if(s.charAt(n) == o.charAt(n)) {
                return s.compareTo(o);
            }

            return s.charAt(n) - o.charAt(n);
        });
    
    
        return strings;
    }
}