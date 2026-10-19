class Solution {
    public int[] solution(String[] park, String[] routes) {        
        int x = 0;
        int y = 0;
        
        int mapX = park[0].length();
        int mapY = park.length;
        
        for (int i = 0; i < mapY; i++) {
            for (int j = 0; j < mapX; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = j;
                    y = i;
                }
            }
        }
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int i=0; i<routes.length; i++) {
            char op = routes[i].charAt(0);
            
            int d;
            if(op == 'N') d = 0;
            else if(op == 'S') d = 1;
            else if(op == 'W') d = 2;
            else d = 3;
            
            int n = routes[i].charAt(2) - '0';
            
            int nx = x;
            int ny = y;
            
            for(int j=1; j<=n; j++) {
                
                nx += dir[d][1];
                ny += dir[d][0];
                
                if(nx < 0 || nx >= mapX || ny < 0 || ny >= mapY) break;
                if(park[ny].charAt(nx) == 'X') break;
                
                if(j==n) {
                    x = nx;
                    y = ny;
                }
            }
            
        }
        int[] answer = {y, x};
        return answer;
    }
}