import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static final int INF = Integer.MAX_VALUE;
	
	static char[][] map;
	static int n, m, startR, startC, endR, endC;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
//			악마 저장용
			List<int[]> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '*') {
						list.add(new int[] {i, j});
					} else if(map[i][j] == 'S') {
						startR = i;
						startC = j;
					} else if(map[i][j] == 'D') {
						endR = i;
						endC = j;
					}
				}
			}
			
			int[][] devil = devilmove(list);
			int result = move(devil);
			
			String s = "";
			
			if(result == INF) {
				s += "GAME OVER";
			} else {
				s += result;
			}
			
			sb.append('#').append(tc).append(' ').append(s).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[][] devilmove(List<int[]> dList) {
		int[][] devil = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(devil[i], INF);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		for(int[] d : dList) {
			pq.add(new int[] {d[0], d[1], 0});
			devil[d[0]][d[1]] = 0;
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];
			
			if(devil[r][c] < time) continue;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
				if(map[nr][nc] == 'D' || map[nr][nc] == 'X') continue;
				
				if(devil[nr][nc] > time+1) {
					devil[nr][nc] = time+1;
					
					pq.add(new int[] {nr, nc, time+1});
				}				
			}
			
		}		
		
		return devil;
	}
	
	static int move(int[][] devil) {
		int[][] dist = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		
		pq.add(new int[] {startR, startC, 0});
		dist[startR][startC] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];
			
			if(dist[r][c] < time) continue;
			if(devil[r][c] <= time) continue;
			
			if(r == endR && c == endC) break;
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
				if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;
				
				if(dist[nr][nc] > time+1) {
					dist[nr][nc] = time+1;
					
					pq.add(new int[] {nr, nc, time+1});
				}				
			}
			
			
		}
		
		return dist[endR][endC];
		
	}
}
