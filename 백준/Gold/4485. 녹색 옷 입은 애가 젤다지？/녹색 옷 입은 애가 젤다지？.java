import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = 1_000_000;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		while(true) {
			int n = Integer.parseInt(br.readLine()); //동굴 크기
			if(n == 0) break;
			
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dist = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(dist[i], INF);
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
			
			pq.add(new int[] {0, 0, arr[0][0]});
			dist[0][0] = arr[0][0];
			
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
					if(dist[nr][nc] > ncost) {
						dist[nr][nc] = ncost;
						pq.add(new int[] {nr, nc, ncost});
					}					
				}
			}
			cnt++;
			
			sb.append("Problem ").append(cnt).append(": ").append(dist[n-1][n-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
