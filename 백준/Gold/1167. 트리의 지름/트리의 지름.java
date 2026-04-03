import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Node>[] graph;
	
	static class Node implements Comparable<Node> {
		int to;
		long cost;
		
		public Node(int to, long cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(o.cost, this.cost);
		}		
		
	}
	
	static boolean[] visited;
    static long maxDist;
    static int farNode;

    static void dfs(int cur, long dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farNode = cur;
        }

        for (Node next : graph[cur]) {
            if (!visited[next.to]) {
                visited[next.to] = true;
                dfs(next.to, dist + next.cost);
            }
        }
    }
	
	static long prim(int start, int v) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v+1];
		
		pq.add(new Node(start, 0));
		
		long total = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.to]) continue;
			
			visited[cur.to] = true;
			total += cur.cost;
			count++;
			
			if(count == v) break;
			
			for(Node next : graph[cur.to]) {
				if(!visited[next.to]) {
					pq.offer(next);
				}
			}
		}
		
		
		return total;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int v = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[v+1];
		
		for(int i=1; i<=v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				graph[from].add(new Node(to, cost));
			}
		}
		
//		MST가 최소 신장 트리니까 MST의 반대로 돌리기?
//		실패
//		long ans = prim(1, v);

		// 1번 정점에서 가장 먼 정점 찾기
        visited = new boolean[v + 1];
        visited[1] = true;
        maxDist = 0;
        dfs(1, 0);

        // farNode에서 다시 가장 먼 거리 찾기
        visited = new boolean[v + 1];
        visited[farNode] = true;
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
	}

}
