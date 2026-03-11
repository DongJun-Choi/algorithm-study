import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] graph;
	static boolean[] visited;
	
	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}		
	}
	
	static long prim(int start, int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[n+1];
		
		
		long total = 0;
		int cnt = 0;		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			total += cur.weight;
			cnt++;
			
			if(cnt == n+1) break;
			
			for(Node next : graph[cur.to]) {
				if(!visited[next.to]) {
					pq.add(new Node(next.to, next.weight));
				}
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
//		우물을 파는 경우
		for(int i=1; i<=n; i++) {
			int weight = Integer.parseInt(br.readLine());
			graph[0].add(new Node(i, weight));
			graph[i].add(new Node(0, weight));
		}
		
//		우물을 판곳과 연결하는 것
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int weight = Integer.parseInt(st.nextToken());
				if(weight != 0) {
					graph[i].add(new Node(j, weight));
				}
			}
		}		
		
		long ans = prim(0, n);
		
		System.out.println(ans);
	}
	
	 

}
