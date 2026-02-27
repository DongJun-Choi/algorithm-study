import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, min;
	static int[][] arr, dp;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //우, 하, 좌, 상
	static boolean[][][] visited;
	
	
	static class You {
		int r;
		int c;
		int count;
		int broken;
		public You(int r, int c, int count, int broken) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.broken = broken;
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m][2];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		min = Integer.MAX_VALUE;
		
//		dfs(0, 0, 0, 0, 1, true);

		
		
		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		
		System.out.println(bfs());

	}
	
	private static int bfs() {
//		어떤 구조더라? q에 하나씩 넣어서. q가 끝날때까지 돌리기 였던거 같은데
		
		Queue<You> q = new LinkedList<>();
//		r, c, count?
		q.offer(new You(0, 0, 1, 0));
		
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {			
			You cur = q.poll();
			
			if(cur.r == n-1 && cur.c == m-1) {
				return cur.count;
			}		
			
			for(int d=0; d<4; d++) {
				int nr = cur.r+dir[d][0];
				int nc = cur.c+dir[d][1];
				
				if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
				
				if(arr[nr][nc] == 0) {
					if(!visited[nr][nc][cur.broken]) {
						visited[nr][nc][cur.broken] = true;
						q.offer(new You(nr, nc, cur.count+1, cur.broken));
					}
				} else {
					if(cur.broken == 0 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						q.offer(new You(nr, nc, cur.count+1, 1));
					}
				}
			}
			
		}
		
		return -1;
	}
	
	
	private static void dfs(int br, int bc, int r, int c, int count, boolean can) {
//		가지치기 방법이 있나?
		if(r >= n || r < 0 || c >= m || c < 0) return;
		
		if(count > min) return;
		
		if(r == n-1 && c == m-1) {
			min = Math.min(count, min);
			return;
		}
		
//		if(visited[r][c]) return;
//		visited[r][c] = true;
		
		
		for(int d=0; d<4; d++) {
			int nr = r+dir[d][0];
			int nc = c+dir[d][1];
			
			if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
			
			if(nr == br && nc == bc) continue;
			
//			if(visited[nr][nc]) continue;
			
			if(arr[nr][nc] == 1 && can) {
//				System.out.println("부셨어!: "+nr+" "+nc);
				dfs(r, c, nr, nc, count+1, !can);
			} 
			
			if(arr[nr][nc] == 1) continue;
			
			dfs(r, c, nr, nc, count+1, can);
		}
		
//		System.out.println("내 마지막 좌표야!: "+ r+" "+c);
		
//		visited[r][c] = false;
		return;
	}

}
