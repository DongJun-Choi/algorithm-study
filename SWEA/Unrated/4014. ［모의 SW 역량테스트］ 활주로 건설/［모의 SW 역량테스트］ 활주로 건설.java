import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			한줄씩 체크해야함.
//			방향은 양옆으로, 가로/세로 체크해야함
			
			int count = 0;
			
//			가로 체크
			for(int i=0; i<n; i++) {
				int check = arr[i][0];
				boolean can = true;
				boolean[] visited = new boolean[n];
				
				for(int j=1; j<n; j++) {				
//					저번것과 높이가 같을 경우 패스
					if(check == arr[i][j]) continue;
					
//					높이 차이가 1 이상일 경우 탈락
					if(Math.abs(check - arr[i][j]) > 1) {
						can = false;
						break;
					}
					
					int len;
//					높이 차이가 1이면서, 낮은쪽이 이어지는 경우가 x 이하일 경우
//					낮은쪽 체크
					if(check < arr[i][j]) {
						len = 0;
//						같은 높이의 길이 체크
						for(int l=j-1; l>=0; l--) {
							if(arr[i][l] != arr[i][j-1] || len == x) break;
							if(visited[l]) {
								can = false;
								break;
							}
							visited[l] = true;
							len++;
						}
					} else {
						len = 0;
						for(int l=j; l<n; l++) {
							if(arr[i][l] != arr[i][j] || len == x) break;
							if(visited[l]) {
								can = false;
								break;
							}
							visited[l] = true;
							len++;
						}
						
						j += len-1;
					}
					if(len < x) {
						can = false;
						break;
					}
					check = arr[i][j];					
				}
				if(can) {
					count++;
				}
			}
//			세로 체크
			for(int j=0; j<n; j++) {
				int check = arr[0][j];
				boolean can = true;
				boolean[] visited = new boolean[n];
				
				for(int i=1; i<n; i++) {
					if(check == arr[i][j]) continue;
					
//					높이 차이가 1 이상일 경우 탈락
					if(Math.abs(check - arr[i][j]) > 1) {
						can = false;
						break;
					}
					
					int len;
//					높이 차이가 1이면서, 낮은쪽이 이어지는 경우가 x 이하일 경우
//					낮은쪽 체크
					if(check < arr[i][j]) {
						len = 0;
//						같은 높이의 길이 체크
						for(int l=i-1; l>=0; l--) {
							if(arr[l][j] != arr[i-1][j] || len == x) break;
							if(visited[l]) {
								can = false;
								break;
							}
							visited[l] = true;
							len++;
						}
					} else {
						len = 0;
						for(int l=i; l<n; l++) {
							if(arr[l][j] != arr[i][j] || len == x) break;
							if(visited[l]) {
								can = false;
								break;
							}
							visited[l] = true;
							len++;
						}
						
						i += len-1;
					}
					if(len < x) {
						can = false;
						break;
					}
					
					check = arr[i][j];
				}
				if(can) {
					count++;
				}
			}
			
			
			sb.append('#').append(tc).append(' ').append(count).append("\n");
		}
		
		System.out.println(sb);
	}

}
