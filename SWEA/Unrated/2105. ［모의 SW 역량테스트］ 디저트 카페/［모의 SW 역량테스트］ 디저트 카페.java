import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int n, startR, startC, max;
	static int[][] arr;
//	왼쪽 아래, 오른쪽 아래, 오른쪽 위, 왼쪽 위 
	static int[][] del = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
	static boolean[] value;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			value = new boolean[101];
			max = -1;
			
//			왼쪽 밑으로 시작(왼쪽 밑 방향이 가능한지 판단 후 함수에 넣기)
//			함수
//			왼쪽 밑으로 더 가능한지 확인 하고 안되면 다음 방향(다음 방향에서 안되면 바로 컷)
//			왼쪽 밑으로 가능하면서 다음 방향도 가능한 경우는 갈림길로 저장
//			하면서 q에 넣는데 q에 같은 값이 존재하는지 체크 후 있으면 컷
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					int nr = i+del[0][0];
					int nc = j+del[0][1];
					
					if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
					
					value[arr[i][j]] = true;
					startR = i; 
					startC = j;
					can(nr, nc, 0, 1);
					value[arr[i][j]] = false;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void can(int r, int c, int d, int cnt) {
		
		if(r == startR && c == startC && d == 3) {
			max = Math.max(max, cnt);
			return;
		}
		
		if(value[arr[r][c]]) return;
		value[arr[r][c]] = true;

		int nr = r+del[d][0];
		int nc = c+del[d][1];
		
		if(nr >= 0 && nr < n && nc >= 0 && nc < n && !value[arr[nr][nc]]) {			
			can(nr, nc, d, cnt+1);
		} else if(nr >= 0 && nr < n && nc >= 0 && nc < n && nr == startR && nc == startC) can(nr, nc, d, cnt+1);
		
		if(d+1 < 4) {
			int nr2 = r+del[d+1][0];
			int nc2 = c+del[d+1][1];
			
			if(nr2 >= 0 && nr2 < n && nc2 >= 0 && nc2 < n && !value[arr[nr2][nc2]]) {
				can(nr2, nc2, d+1, cnt+1);
			} else if(nr2 >= 0 && nr2 < n && nc2 >= 0 && nc2 < n && nr2 == startR && nc2 == startC) can(nr2, nc2, d+1, cnt+1);
		}
		
		value[arr[r][c]] = false;
		
	}
	
}
