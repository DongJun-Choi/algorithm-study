import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		if (n >= k) {
            System.out.println(n - k);
            return;
        }
		
//		n에서 k로 가는 최소의 시간, 현재위치 = X
//		1초 걸려서 X-1, X+1 이동 가능
//		0초 걸려서 2*X 위치로 이동 가능	
		
		int MAX = 200000;
		
		dist = new int[200000];
		Arrays.fill(dist, INF);
		
		Deque<Integer> dq = new LinkedList<>();
		
//		위치, 시간
		dq.add(n);
        dist[n] = 0;
		
		while (!dq.isEmpty()) {
            int x = dq.pollFirst();

            if (x == k) {
                System.out.println(dist[x]);
                return;
            }

            // 0초 이동: 순간이동
            int nx = x * 2;
            if (nx < MAX && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.addFirst(nx);
            }

            // 1초 이동: x - 1
            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            // 1초 이동: x + 1
            nx = x + 1;
            if (nx < MAX && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }
		
	}

}
