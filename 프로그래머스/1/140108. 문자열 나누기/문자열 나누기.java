class Solution {
    public int solution(String s) {
//         첫 글자 x x와 다른 글자가 나온 횟수 세기, x나온 횟수와 함께
        
        char x = ' ';
        int x_p = 0;
        int x_m = 0;
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (x_p == 0) {
                x = c;
                x_p = 1;
                x_m = 0;
                continue;
            }
            
            if (c == x) {
                x_p++;
            } else {
                x_m++;
            }
            
            if (x_p == x_m) {
                answer++;
                x_p = 0;
                x_m = 0;
            }            
        }
        
        if (x_p != 0) {
            answer++;
        }
        
        return answer;
    }
}