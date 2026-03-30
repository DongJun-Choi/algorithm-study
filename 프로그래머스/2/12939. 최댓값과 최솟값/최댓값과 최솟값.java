import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = st.countTokens();
        
        for(int i=0; i<size; i++) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        
        String answer = String.valueOf(min)+" "+String.valueOf(max);
        return answer;
    }
}