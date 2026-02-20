import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int t = Integer.parseInt(br.readLine());
		int t = 10;
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			List<Integer>[] node = new ArrayList[v + 1];
			for(int i = 1; i <= v; i++) {
			    node[i] = new ArrayList<>();
			}
			
			int[] indegree = new int[v+1];
			Queue<Integer> q = new LinkedList<>();
			List<Integer> work = new ArrayList<>();
			
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<e; i++) {
				int a = Integer.parseInt(st.nextToken()); //시작
				int b = Integer.parseInt(st.nextToken()); //도착
				node[a].add(b);
				indegree[b]++;
			}
			
//			도착지인 것이 없는 것을 찾아야함. 어떻게?
			for(int i=1; i<=v; i++) {
				if(indegree[i] == 0) q.offer(i);
			}
			
//			현재 출력은 q한개당 돌아가는게 아니라, 도착지가 아닌것을 다 돌리고 하기 때문에 안됨.
//			한 큐에서 나온 것을 돌리고 나서 다시 돌아가서 돌려야 함.
//			그러면 q한번당 한번 돌리는데 연결리스트는
			while(!q.isEmpty()) {
				int n = q.poll();
				work.add(n);
				
				for(int i=0; i<node[n].size(); i++) {
					int next = node[n].get(i); 
					indegree[next]--;
					if(indegree[next] == 0) {
						q.offer(next);
					}
				}				
			}
			
			sb.append('#').append(tc).append(' ');
			for(int i=0; i<work.size(); i++) {
				sb.append(work.get(i)).append(' ');
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
