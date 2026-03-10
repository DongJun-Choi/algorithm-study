import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}		
	}
	
	static void makeSet(int n) {
		parent = new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i] = i;
		}		
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		parent[rootB] = rootA;
		return true;
	}
	
	static long kruskal(int n, List<Edge> edges) {
		Collections.sort(edges);
		
		int cnt = 0;
		long totalCost = 0;
		
		makeSet(n);
		
		for(Edge e : edges) {			
			if(union(e.from, e.to)) {
				totalCost += e.weight;
				cnt++;
				
				if(cnt == n-1) break;
			}
		}
		
		return totalCost;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			List<Edge> list = new ArrayList<>();
			for(int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list.add(new Edge(a, b, c));
			}
			
			long ans = kruskal(v, list);
			
			sb.append('#').append(tc).append(' ').append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
