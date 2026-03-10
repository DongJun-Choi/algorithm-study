import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000;
	
	static int n, m;
	static int[][] arr, dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] visited;
	static List<List<int[]>> list = new ArrayList<>();
	
	static int[] parent;
	
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
		
		parent[rootA] = rootB;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
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
	
	static int kal(int n, List<Edge> edges) {
		Collections.sort(edges);
		
		int cnt = 0;
		int total = 0;
		
		makeSet(n);
		
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				total += e.weight;
				cnt++;
				
				if(cnt == n-1) break;
			}
		}
		
		if (cnt != n - 1) return 0; // 연결 불가
		
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		1. 섬 확인하기(모든 좌표를 가지고 있기)
//		그러면 한 섬인지 판단하는 방법은?
//		2. 섬과 섬을 연결하는 모든 경우의 수 찾기(다리는 직선으로 닿아야함.)
//		3. 모든 경로를 가지고 kal 돌리기
		
		visited = new boolean[n][m];
		
		int size = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					List<int[]> inner = new ArrayList<>();
					list.add(inner);
					search(i, j, size);
					size++;
				}
			}
		}
		
		size = list.size();
//		섬과 연결시키면서 거리 재는 코드
		dist = new int[size][size];
		
		for(int i=0; i<size; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		for(int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				cal(i, j);
			}
		}
		
		List<Edge> edges = new ArrayList<>();
		int result = 0;
		
//		여기서 만약 연결이 안되어있는 섬이 있으면 result는 -1로 해야함.
		for(int i = 0; i < size; i++) {
		    boolean connected = false;

		    for(int j = 0; j < size; j++) {
		        if(i == j) continue;

		        if(dist[i][j] != INF) {
		            connected = true;
		            break;
		        }
		    }

		    if(!connected) {
		        result = -1;
		        break;
		    }
		}
		
		if(result == -1) {
			System.out.println(result);
			return;
		}
		
		for(int i=0; i<size; i++) {			
			for(int j=0; j<i; j++) {
				if(i == j) continue;
				
				if(dist[i][j] != INF) {
					edges.add(new Edge(i, j, dist[i][j]));
				}
			}
		}
		
		result = kal(size, edges);
		
		if(result == 0) result = -1;
		
		System.out.println(result);
	}
	
//	섬의 갯수 및 좌표 저장
	static void search(int row, int col, int some) {
		
		list.get(some).add(new int[] {row, col});
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {row, col});
		
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			visited[r][c] = true;
			list.get(some).add(new int[] {r, c});
			
			for(int d=0; d<4; d++) {
				int nr = r+dr[d];
				int nc = c+dc[d];
				
				if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;
				if(arr[nr][nc] != 1 || visited[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
			}
		}		
	}
	
	static int cal(int r1, int c1, int r2, int c2) {
		int cnt = 0;
		
		if(r1 == r2) {
			int c = Math.min(c1, c2);
			while(c < Math.max(c1, c2) -1) {
				c+=1;
				cnt++;
				if(arr[r1][c] == 1) return INF;
			}	
		} else {
			int r = Math.min(r1, r2);
			while(r < Math.max(r1, r2) -1) {
				r+=1;
				cnt++;
				if(arr[r][c1] == 1) return INF;
			}
		}
		
		return cnt;
	}
	
//	섬과 연결하는 최소의 다리 찾는 코드
	static void cal(int n1, int n2) {
//		일단 섬 좌표에서 다른 섬의 좌표 범위와 일치하는지 확인
		int min;
		
		
		for(int i=0; i<list.get(n1).size(); i++) {
			for(int[] cur : list.get(n2)) {
				if(cur[0] == list.get(n1).get(i)[0]) {
					min = cal(cur[0], cur[1], list.get(n1).get(i)[0], list.get(n1).get(i)[1]);
					if(min > 1) {
						dist[n1][n2] = Math.min(min, dist[n1][n2]);
						dist[n2][n1] = dist[n1][n2];
					}
				}
				if(cur[1] == list.get(n1).get(i)[1]) {
					min = cal(cur[0], cur[1], list.get(n1).get(i)[0], list.get(n1).get(i)[1]);
					if(min > 1) {
						dist[n1][n2] = Math.min(min, dist[n1][n2]);
						dist[n2][n1] = dist[n1][n2];
					}
				}
			}
		}		
	}

}
