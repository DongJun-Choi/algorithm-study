import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, min;
	static boolean[] visited;
	static int[] home, company;
	static int[][] arr;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			
//			회사와 집의 위치, 각 고객의 위치
			StringTokenizer st = new StringTokenizer(br.readLine());
			home = new int[2];
			company = new int[2];
			
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			arr = new int[n][2];
			for(int i=0; i<n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dist = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					dist[i][j] = dis(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
					dist[j][i] = dist[i][j];
				}
			}
			
			min = Integer.MAX_VALUE;
			visited = new boolean[n];
			
//			회사에서 출발, 모든 고객 방문 후, 집으로 도착
//			출발과, 도착이 지정되어있음
//			걍 모든 경우의 수 탐색 때릴까?
			
			for(int i=0; i<n; i++) {
				int cost = dis(company[0], company[1], arr[i][0], arr[i][1]);
				visited[i] = true;
				dfs(0, cost, i);
				visited[i] = false;
			}
			
			sb.append('#').append(tc).append(' ').append(min).append("\n");			
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth, int cost, int num) {		
		if(cost >= min) return;
		
		if(depth == n-1) {
			cost += dis(home[0], home[1], arr[num][0], arr[num][1]);
			min = Math.min(cost, min);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(depth+1, cost+dist[num][i], i);
			visited[i] = false;
		}
	}
	
	static int dis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
