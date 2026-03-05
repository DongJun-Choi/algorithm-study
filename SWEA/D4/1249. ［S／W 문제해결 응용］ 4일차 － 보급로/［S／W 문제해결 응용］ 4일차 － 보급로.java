import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	static int n, min;
	static int[][] arr;
	static int[][] dir = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
	static boolean[][] visited;
	static int[][] dp;
	static final int INF = 1_000_000_000;
	
	static class Node {
        int r, c, cost;
        Node(int r, int c, int cost){
            this.r = r; this.c = c; this.cost = cost;
        }
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<n; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
//			현재 위치에서 이동시키기, 이동시킬때 앞에 0보다 크면 그 숫자만큼 time에 더하고 이동하기.
//			bfs로 돌리면 큐는 가장 빨리 도착하는 것이겠지만 최소 시간인지는 애매함 dfs로 풀어야 할 거 같은데?
//			dfs로 하니까 시간 ㅈㄴ 걸리네 지도는 100*100이야.
			
//			min = Integer.MAX_VALUE;
//			visited = new boolean[n][n];
// 			dp = new int[n][n];
//			
//			visited[0][0] = true;
//			dfs(0, 0, 0);
			
			int ans = dijkstra();
			
			sb.append('#').append(tc).append(' ').append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int dijkstra() {
		int[][] dist = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dist[i], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        dist[0][0] = 0;
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost != dist[cur.r][cur.c]) continue;
            if(cur.r == n-1 && cur.c == n-1) return cur.cost;

            for(int d=0; d<4; d++){
                int nr = cur.r + dir[d][0];
                int nc = cur.c + dir[d][1];
                if(nr<0||nc<0||nr>=n||nc>=n) continue;

                int ncost = cur.cost + arr[nr][nc];
                if(ncost < dist[nr][nc]){
                    dist[nr][nc] = ncost;
                    pq.add(new Node(nr,nc,ncost));
                }
            }
        }
        return dist[n-1][n-1];
	}
	
	static int bfs(int row, int col) {	
		
		
		return -1;
	}
		
	static void dfs(int row, int col, int time) {
		if(time > min) return;
		
		if(row == n-1 && col == n-1) {
			min = Math.min(min, time);
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = row+dir[d][0];
			int nc = col+dir[d][1];
			
			if(nr >= n || nr < 0 || nc >= n || nc < 0) continue;
			
			if(dp[nr][nc] < time && visited[nr][nc]) continue;
			if(visited[nr][nc]) continue;
			
			dp[nr][nc] = time;
			visited[nr][nc] = true;
			int val = arr[nr][nc];
			dfs(nr, nc, time+val);
			visited[nr][nc] = false;
		}
		
	}

}
