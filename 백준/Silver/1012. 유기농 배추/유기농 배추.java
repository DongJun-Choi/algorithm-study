import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int m, n;
	static boolean[][] visited, arr;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr = new boolean[n][m];
			visited = new boolean[n][m];
			
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				arr[r][c] = true;
			}
			
			
			int cnt = 0;
			for(int r=0; r<n; r++) {
				for(int c=0; c<m; c++) {
					if(!visited[r][c] && arr[r][c]) {
						search(r, c);
						cnt += 1;
					}
				}
			}
			
			sb.append(cnt).append("\n");	
		}		
		System.out.println(sb);
		
	}
	
	static void search(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {sr, sc});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
				
				if(visited[nr][nc] || !arr[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
			}
			
		}		
		
	}
	
	

}
