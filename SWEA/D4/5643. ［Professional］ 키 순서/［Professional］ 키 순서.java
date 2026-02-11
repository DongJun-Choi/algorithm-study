import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static List<Integer>[] big;
	static List<Integer>[] small;
	static boolean[] visited;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int count = 0;
			big = new ArrayList[N+1];
			small = new ArrayList[N+1];
			
			for(int i = 1; i <= N; i++) {
			    big[i] = new ArrayList<>();
			    small[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
//				a < b
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				big[a].add(b);
				small[b].add(a);
			}
			
//			자기보다 큰 사람의 수+자기보다 작은 사람의 수 = N-1 이면 알 수 있음
//			dfs로 찾기? 
//			N번 돌리는데 각 idx에서 order의 0인덱스에 있던 위치 값, 그러면 1의 위치에 있던 값이 0에 있던 적이 있나 탐색한 값 +
//			1에 있던 값이면 0에 있던 값이 1에 있던 적이 있나 탐색한 값
//			visited를 만들어서 N에서 어떤 위치를 참고했으면 중복 안되게 하기?
			
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				visited[i] = true;
				int bigCnt = findBig(i);
				
				visited = new boolean[N+1];
				visited[i] = true;
				int smallCnt = findSmall(i);
				
				if(bigCnt+smallCnt == N-1) count++;
			}
			
			sb.append('#').append(tc).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb);
	}
	
//	자기보다 큰 값 거슬러 올라가면서 개수 체크하는 함수
	private static int findBig(int num) {
		int cnt = 0;
		
		for(int i : big[num]) {
			if(visited[i]) continue;
			visited[i] = true;
			cnt += 1;
			cnt += findBig(i);
		}
		
		return cnt;
	}
	
	private static int findSmall(int num) {
		int cnt = 0;
		
		for(int i : small[num]) {
			if(visited[i]) continue;
			visited[i] = true;
			cnt += 1;
			cnt += findSmall(i);
		}
		
		return cnt;
	}
}
