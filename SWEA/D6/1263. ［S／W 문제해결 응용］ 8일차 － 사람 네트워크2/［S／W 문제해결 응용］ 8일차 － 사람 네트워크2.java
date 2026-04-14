import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	
        	int[][] dist = new int[n+1][n+1];
        	
        	for(int i=1; i<=n; i++) {
        		Arrays.fill(dist[i], INF);
        		dist[i][i] = 0;
        	}
        	
        	for(int i=1; i<=n; i++) {
        		for(int j=1; j<=n; j++) {
        			int num = Integer.parseInt(st.nextToken());
        			if(num > 0) dist[i][j] = num; 
        		}
        	}
        	
        	for(int k=1; k<=n; k++) {
        		for(int i=1; i<=n; i++) {
            		for(int j=1; j<=n; j++) {
            			if(dist[i][k] == INF || dist[k][j] == INF) continue;
            			dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
            		}
            	}
        	}
        	
//        	사람 네트워크는 하나의 연결 요소(connected component)로 구성 = 다 연결되어있음
//        	사람 그래프에서 Closeness Centrality(CC):Closeness이 가장 작은 최솟값을 출력
//        	cc(i) = ∑ j dist(i,j) 단, dist(i,j)는 노드i로부터 노드 j까지의 최단 거리
//        	한 사람(노드)이 모든 사람(노드)으로 부터 최단 거리의 합?
        	
        	int min = Integer.MAX_VALUE;
        	
        	for (int i = 1; i <= n; i++) {
        		int sum = 0;
            	for (int j = 1; j <= n; j++) {
            	    sum += dist[i][j];
            	}
            	min = Math.min(min, sum);
            }
        	
        	
        	sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
	}
}
