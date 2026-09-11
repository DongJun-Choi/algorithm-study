import java.util.*;

class Solution {
//     캐릭터는 좌측 상단인 (1, 1) , 상대방 진영은 우측 하단인 (n, m) 위치
    
    public int solution(int[][] maps) {
        
        int answer = dfs(maps);
        return answer;
    }
    
    int dfs(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        int[][] dp = new int[m][n];
        int INF = 100*100+1;
        
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};        
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0, 0, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cost = cur[2];
            
            if(r == m-1 && c == n-1) continue;
            
            for(int i=0; i<4; i++) {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];
                
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                
                if(maps[nr][nc] == 0 || dp[nr][nc] <= cost+1) continue;
                dp[nr][nc] = cost+1;
                q.offer(new int[]{nr, nc, cost+1});
            }
            
            
        }
        
        if(dp[m-1][n-1] == INF) return -1;
        
        return dp[m-1][n-1];
        
    }
}