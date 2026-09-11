class Solution {
    
    boolean[] visited;
    int n;
    int cnt;
    
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        visited = new boolean[n];
        cnt = 0;
        
        bfs(0, 0, numbers, target);
        
        int answer = cnt;
        return answer;
    }
    
    void bfs(int num, int depth, int[] numbers, int target) {
        if(depth == n) {
            if(num == target) cnt++;
            return;
        }
        
        bfs(num+numbers[depth], depth+1, numbers, target);
        
        bfs(num-numbers[depth], depth+1, numbers, target);
        
    }
}