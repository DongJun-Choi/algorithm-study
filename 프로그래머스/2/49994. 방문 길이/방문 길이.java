import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++) {
            char op = dirs.charAt(i);
            
            int d;
            if(op == 'U') d = 0;
            else if(op == 'D') d = 1;
            else if(op == 'L') d = 2;
            else d = 3;
            
            int nx = x+dir[d][1];
            int ny = y+dir[d][0];
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            String path1 = x+","+y+","+nx+","+ny;
            String path2 = nx+","+ny+","+x+","+y;
            
            set.add(path1);
            set.add(path2);
            x = nx;
            y = ny;
        }
        
        answer = set.size()/2;
        
        return answer;
    }
}