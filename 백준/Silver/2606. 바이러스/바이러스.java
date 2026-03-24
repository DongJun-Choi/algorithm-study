import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); // 컴터 수
		int m = Integer.parseInt(br.readLine()); // 노드 수
		
		boolean[][] node = new boolean[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());			
			
			node[from][to] = true;
			node[to][from] = true;
		}

		Queue<Integer> q = new LinkedList<>();
		
		visited = new boolean[n+1];
		
		q.add(1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			
			for(int i=1; i<=n; i++) {
				if(visited[i]) continue;
				
				if(node[cur][i]) q.add(i);				
			}			
		}
		
		int cnt = 0;
		for(int i=2; i<=n; i++) {
			if(visited[i]) cnt+=1;
		}
		
		System.out.println(cnt);
	}

}
