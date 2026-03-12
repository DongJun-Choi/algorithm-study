import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	
	static final int INF = 1_000_000;
	static int n;
	static int[][] dist, arr;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
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
			
			dist = new int[n][n];
			
			for(int i=0; i<n; i++) {
				Arrays.fill(dist[i], INF);
			}
			
//			0, 0에서 출발해서 n-1, n-1까지 가야함.
//			맵에 적힌 값이 걸리는 시간
			
			dijstra(0, 0);
			
			int ans = dist[n-1][n-1];
			
			sb.append('#').append(tc).append(' ').append(ans).append("\n");			
		}
		System.out.println(sb);
	}
	

	static void dijstra(int sr, int sc) {		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] {sr, sc, 0});
		
		dist[sr][sc] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];
			
			if(r == n-1 && c == n-1) break;
			
			if(dist[r][c] < cost) continue;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= n || nr < 0 || nc >= n || nc < 0) continue;
				
				int ncost = cost + arr[nr][nc];
				if(dist[nr][nc] <= ncost) continue;
				dist[nr][nc] = ncost;
				
				pq.add(new int[] {nr, nc, ncost});
			}
		}
	}
}
