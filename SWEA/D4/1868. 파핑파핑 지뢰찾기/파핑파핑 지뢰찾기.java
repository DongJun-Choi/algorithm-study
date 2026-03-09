import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int n;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; //상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	static boolean[][] visited;
	static int[][] arr;
	

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
					char c = s.charAt(j);
					if(c == '*') arr[i][j] = -1;
					else arr[i][j] = 0;					
				}
			}
			
//			클릭된 곳으로부터 지뢰를 만날때까지 이동시켜야함.(그 자리의 숫자가 0이면 다른 곳으로 이동해서 찾기, 0이 아니면 멈추기)
//			최소 숫자를 찾기 위해서 그냥 0으로 되어 있는 큰 조합들을 찾아서 그 조합 수 가 최소 수이다.
			
			
//			맵 초기 세팅
			for (int i = 0; i < n; i++) {
			    for (int j = 0; j < n; j++) {
			        if (arr[i][j] == -1) continue;

			        for (int d = 0; d < 8; d++) {
			            int nr = i + dr[d];
			            int nc = j + dc[d];

			            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
			            if (arr[nr][nc] == -1) arr[i][j]++;
			        }
			    }
			}
			
			
			int cnt = 0;
			visited = new boolean[n][n];
			
//			0 덩어리 찾기
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if (arr[i][j] == 0 && !visited[i][j]) {
						cnt++;
						run(i, j);
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j] != -1 && !visited[i][j]) {
						cnt++;
					}
				}
			}
			
			
			sb.append('#').append(tc).append(' ').append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

	static void run(int x, int y) {
		if(visited[x][y]) return;
		visited[x][y] = true;

	    if (arr[x][y] != 0) return;

	    for (int d = 0; d < 8; d++) {
	        int nr = x + dr[d];
	        int nc = y + dc[d];

	        if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
	        if (arr[nr][nc] == -1 || visited[nr][nc]) continue;

	        run(nr, nc);
	    }
	    
	}
}
