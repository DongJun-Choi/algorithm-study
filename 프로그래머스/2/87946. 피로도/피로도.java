class Solution {
    
    int max;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        max = 0;
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return max;
    }
    
    void dfs(int visit, int k, int[][] dungeons) {
        
        max = Math.max(max, visit);
        
        for(int i = 0; i < dungeons.length; i++) {
            
            if(!visited[i] && dungeons[i][0] <= k) {
                
                visited[i] = true;
                
                dfs(visit + 1, k - dungeons[i][1], dungeons);
                
                visited[i] = false;
            }
        }
    }
}