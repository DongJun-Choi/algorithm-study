class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder();
        
        // 1 ~ 3단계
        for (int i = 0; i < new_id.length(); i++) {
            
            // 1단계: 대문자 -> 소문자
            char c = Character.toLowerCase(new_id.charAt(i));
            
            // 2단계:
            // 알파벳 소문자, 숫자, -, _, . 만 허용
            if (!((c >= 'a' && c <= 'z') ||
                  (c >= '0' && c <= '9') ||
                  c == '-' ||
                  c == '_' ||
                  c == '.')) {
                continue;
            }
            
            // 3단계:
            // .이 연속되면 하나만 넣기
            if (c == '.' &&
                sb.length() > 0 &&
                sb.charAt(sb.length() - 1) == '.') {
                continue;
            }
            
            sb.append(c);
        }
        
        // 4단계: 처음 . 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        
        // 끝 . 제거
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // 5단계: 빈 문자열이면 a
        if (sb.length() == 0) {
            sb.append("a");
        }
        
        // 6단계: 15자까지만
        if (sb.length() >= 16) {
            sb.setLength(15);
        }
        
        // 자른 후 마지막이 .이면 제거
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // 7단계: 길이가 2 이하라면
        // 마지막 문자를 반복해서 붙임
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        return sb.toString();
    }
}