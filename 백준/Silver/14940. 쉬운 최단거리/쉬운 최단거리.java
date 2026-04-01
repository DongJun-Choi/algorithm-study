import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		int[][] dist = new int[n][m];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		int sr = 0;
		int sc = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					sr = i;
					sc = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {sr, sc});
		dist[sr][sc] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
				
				if(arr[nr][nc] != 1) continue;
				
				if(dist[nr][nc] > 0 && dist[nr][nc] <= dist[r][c]+1) continue;
				
				dist[nr][nc] = dist[r][c]+1;					
				q.add(new int[] {nr, nc});
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					sb.append(arr[i][j]).append(' ');
				} else {
					sb.append(dist[i][j]).append(' ');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
