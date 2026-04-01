import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
		    if (a[1] == b[1]) {
		        return a[0] - b[0];
		    } else {
		        return a[1] - b[1];
		    }
		});
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			pq.add(new int[] {arr[i][0], arr[i][1]});
		}
		
//		끝나는 시간 기준으로 정렬해서 + 끝나는 시간이 같으면 시작시간이 빠른걸로
		
		int cnt = 0;
		int time = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int start = cur[0];
			int end = cur[1];
			
			if(start < time) continue;
			
			cnt++;
			time = end;			
		}
		
		System.out.println(cnt);
		
	}
}
