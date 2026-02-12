import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] arr;
	static int N, max, num;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());  
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			모든 위치에서 시작하게 하기.
//			정확히 1 더 커야지 이동 가능함.
			
			max = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int count = run(i, j, 1);
					if(count > max) {
						max = count;
						num = arr[i][j];
					} else if(count == max && arr[i][j] < num) {
						num = arr[i][j];
					}
				}
			}
			
			sb.append('#').append(tc).append(" ").append(num).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
//	모든 위치에서 움직일 수 있게 하기.
	private static int run(int r, int c, int count) {		
		for(int d=0; d<4; d++) {
			int nr = r+del[d][0];
			int nc = c+del[d][1];
			
			if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;
			
			if(arr[nr][nc] == (arr[r][c]+1)) {				
				return run(nr, nc, count+1);
			}
		}
		
		return count;
	}
	


}
