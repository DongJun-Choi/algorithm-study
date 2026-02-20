import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int t = Integer.parseInt(br.readLine());
		int t = 10;
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			Queue<int[]> q = new LinkedList<>();
			
			for(int i=0; i<100; i++) {
				String s = br.readLine();
				for(int j=0; j<100; j++) {
					arr[i][j] = s.charAt(j) - '0';
					if(arr[i][j] == 2) {
						q.offer(new int[] {i, j});
					}
				}
			}
			
			int can = 0;
			
			while(!q.isEmpty()) {
				int[] num = new int[2];
				num = q.poll();
				int r = num[0];
				int c = num[1];
				
				for(int d=0; d<4; d++) {
					int nr = r+del[d][0];
					int nc = c+del[d][1];
					
					if(nr >= 100 || nr < 0 || nc >= 100 || nc < 0 || arr[nr][nc] == 1) {
						continue;
					}
					
					if(arr[nr][nc] == 3) {
						can = 1;
						break;
					} else if(arr[nr][nc] == 0) {
						arr[nr][nc] = 1;
						q.offer(new int[]{nr, nc});
					}
				}
			}			
			
			sb.append('#').append(tc).append(' ').append(can).append("\n");
		}
		
		System.out.println(sb);
	}

}
