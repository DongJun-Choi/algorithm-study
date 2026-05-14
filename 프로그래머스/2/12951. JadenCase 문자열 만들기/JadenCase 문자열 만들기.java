class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        int len = s.length();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                answer += ' ';
                flag = true;
            } else if(flag) {
                answer += Character.toUpperCase(c); 
                flag = false;
            } else {
                answer += Character.toLowerCase(c);   
            }
        }
        return answer;
    }
}