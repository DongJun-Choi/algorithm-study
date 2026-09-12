import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
//         트리형태 => 무조건 사이클이 없음
//         graph에 넣는데 연결이 안되있으면 넣지 않기
        graph = new ArrayList[n+1];
        
        for(int i=1; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }      
        
        for(int i=0; i<wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++) {
            int cutA = wires[i][0];
            int cutB = wires[i][1];
            
            int count = bfs(1, n, cutA, cutB);
            int other = n-count;
            
            answer = Math.min(answer, Math.abs(count-other));            
        }
           
        return answer;
    }
    
    int bfs(int start, int n, int cutA, int cutB) {

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited[start] = true;

        int count = 0;

        while(!q.isEmpty()) {

            int cur = q.poll();
            count++;

            for(int next : graph[cur]) {
                if((cur == cutA && next == cutB) || (cur == cutB && next == cutA)) {
                    continue;
                }

                if(visited[next]) continue;

                visited[next] = true;
                q.offer(next);
            }
        }

        return count;
    }
}