import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, max;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	
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
					max = Math.max(max, arr[i][j]); 
				}
			}
			
			max = 1;
			for(int d=1; d<=100; d++) {
				visited = new boolean[n][n];
				int count = 0;
				
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(arr[i][j] <= d) {
							visited[i][j] = true;
							continue;
						}
					}
				}
				
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(!visited[i][j]) {
							check(i, j);
							count+=1;
						}
					}
				}
				
				max = Math.max(max, count);
			}
			
			
			
			sb.append('#').append(tc).append(' ').append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
//	덩어리 판단 시키기
//	visited로 이미 덩어리 판단 했는지 확인하기.
	private static void check(int r, int c) {
		
		if(visited[r][c]) return;
		
		visited[r][c] = true;
		
		
		for(int i=0; i<4; i++) {
			int nr = r+del[i][0];
			int nc = c+del[i][1];
			
			if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
				check(nr, nc);
			}			
		}
		
	}

}
