import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[100001];
		Arrays.fill(dist, -1);
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == target) {
				System.out.println(dist[cur]);
				break;
			}
			
			int[] next = {cur-1, cur+1, cur*2};
			
			for(int nx : next) {
				if(nx < 0 || nx > 100000) continue;
				if(dist[nx] != -1) continue;
				dist[nx] = dist[cur] + 1;
				
				q.add(nx);
			}
			
		}
		
		
		
	}
	

}
