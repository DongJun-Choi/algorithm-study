import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	static int n, m, x;
	
	static List<Node>[] graph;
	
	static class Node implements Comparable<Node>{
		int end, cost;

		public Node(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}		
	}
	
	static int[] dijstra(int from) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(from, 0));
		dist[from] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(dist[cur.end] < cur.cost) continue;
			
			for(Node next : graph[cur.end]) {
				int ncost = dist[cur.end]+next.cost;
				
				if(dist[next.end] > ncost) {
				    dist[next.end] = ncost;
				    pq.add(new Node(next.end, ncost));
				}
			}
			
		}
		
		return dist;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
//		N명의 학생이 X번(1~N개의 마을) 마을에 모여 파티 벌이기, M개의 단방향 도로 존재
//		필요 소요 시간 T 존재
//		왕복에 가장 많은 시간을 소비하는 학생 찾기
		
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(end, cost));
		}
		
		int max = 0;
		
//		다익스트라 왕복으로 돌려서 가장 합이 큰 친구를 max값으로 저장하기
//		x에서 시작해서 이동하는 것은 한번 돌려서 그 값을 저장해서 재사용하면 좋을 듯
//		max값 변경시 idx값도 변경
		
		int[] x_dist = dijstra(x);
		
		for(int i=1; i<=n; i++) {
			if(x == i) continue;
			
			int[] dist = dijstra(i);
			int sum = dist[x] + x_dist[i];
			max = Math.max(max, sum);
		}
		
		
		System.out.println(max);
	}
}
