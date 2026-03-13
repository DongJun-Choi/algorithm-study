import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	static int R, C, sr, sc;
	static char[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		map = new char[R][C];
		
		List<int[]> list = new ArrayList<>();
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'F') {
					list.add(new int[] {i, j});
				} else if(map[i][j] == 'J') {
					sr = i;
					sc = j;
				}
			}
		}
		
		int[][] fire = fireMove(list);		
		int ans = move(fire);
		
		if(ans >= 0) {
			System.out.println(ans);
		} else {
			System.out.println("IMPOSSIBLE");
		}
		
	}
	
	static int[][] fireMove(List<int[]> fList) {
		int[][] fire = new int[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(fire[i], INF);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		for(int[] f : fList) {
			pq.add(new int[] {f[0], f[1], 0});
			fire[f[0]][f[1]] = 0;
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];
			
			if(fire[r][c] < cost) continue;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= R || nr < 0 || nc >= C || nc < 0) continue;
				
				if(map[nr][nc] == '#') continue;
				
				if(fire[nr][nc] > cost+1) {
					fire[nr][nc] = cost+1;
					pq.add(new int[] {nr, nc, cost+1});
				}
				
			}
		}
		
		return fire;
	}
	
	static int move(int[][] fire) {
		int[][] dist = new int[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		pq.add(new int[] {sr, sc, 0});
		dist[sr][sc] = 0;
		
		int ans = -1;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];
			
			if(r >= R-1 || r <= 0 || c >= C-1 || c <= 0) {
				ans = cost+1;
				break;
			}
			
			if(fire[r][c] <= cost) continue;
			if(dist[r][c] < cost) continue;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= R || nr < 0 || nc >= C || nc < 0) {
					ans = cost+1;
					break;
				};
				
				if(map[nr][nc] != '.') continue;
				
				if(fire[nr][nc] <= cost+1) continue;
				
				if(dist[nr][nc] > cost+1) {
					dist[nr][nc] = cost+1;
					pq.add(new int[] {nr, nc, cost+1});
				}
				
			}
		}
		
		return ans;
	}
	
	static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == INF) {
					sb.append(INF).append(' ');
				} else {
					sb.append(arr[i][j]).append(' ');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
