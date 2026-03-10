import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {	
	static int[] parent;
	
	static long distance(int x1, int y1, int x2, int y2) {		
		long dx = x1 - x2;
	    long dy = y1 - y2;
		return dx*dx + dy*dy;
	}
	
	static void makeSet(int n) {
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
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
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}	
	}
	
	static long kal(int n, List<Edge> edges) {
		Collections.sort(edges);
		
		int cnt = 0;
		long total = 0;
		
		makeSet(n);
		
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				total += e.weight;
				cnt++;
				
				if(cnt == n-1) break;
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n];
			int[] y = new int[n];
			double e = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			e = Double.parseDouble(br.readLine());
			
			List<Edge> list = new ArrayList<>();
//			모든 간선을 넣어야함.
//			처음 것은 모든것과, 이후 전거 빼고 다.
			for(int i=0; i<n; i++) {			
				for(int j=i+1; j<n; j++) {
					long weight = distance(x[i], y[i], x[j], y[j]);
					list.add(new Edge(i, j, weight));
				}
			}
			
			long ans = kal(n, list);
			ans = Math.round(ans*e);
			
			sb.append('#').append(tc).append(' ').append(ans).append("\n");			
		}
		
		System.out.println(sb);
	}
	

}
