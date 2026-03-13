import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int ans = 0;
		
//		0, 0에서 출발해서 m-1, n-1까지 도착할려면 몇개의 벽을 부셔야 하는가?
		
		Deque<int[]> q = new LinkedList<>();
		
//		r, c, 지금까지 부신 벽
		q.add(new int[] {0, 0, 0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int wall = cur[2];
			
			if(r == m-1 && c == n-1) {
				ans = wall;
				break;
			}
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= m || nr < 0 || nc >= n || nc < 0) continue;
				
				if(visited[nr][nc]) continue;
				
				if(arr[nr][nc] == 0) {
					q.addFirst(new int[] {nr, nc, wall});
				} else {
					q.addLast(new int[] {nr, nc, wall+1});
				}
			}
			
		}
		
		System.out.println(ans);
	}

}
