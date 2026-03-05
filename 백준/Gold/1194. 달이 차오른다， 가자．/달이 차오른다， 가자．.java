import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int startR, startC, n, m;
	static char[][] arr;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][m];
		visited = new boolean[n][m][64];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == '0') {
					startR = i;
					startC = j;					
				}
			}
		}
		
//		dfs로?
//		이동을 q에 넣고 안되면 컷?
//		키 값을 가지고 있는지 체크는?
//		이동을 하면서 키 값을 가지고 있는지 체크를 해야하기 때문에 비트마스킹으로 숫자를 가지고 그 숫자로 키 뭐뭐 가지고 있는지 판단하기.
//		key를 가져오기 위해서 되돌아오는 경우도 존재해야할텐데 이건 어떻게하지? 방문처리해서 무한 루프를 못돌게 해야하는데, 그렇게 되면 되돌아가는 것도 구현 못하는데?
		
		int result = bfs(startR, startC);
		
		System.out.println(result);
	}
	
	static int bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {row, col, 0, 0});
		visited[row][col][0] = true;
		
		while(!q.isEmpty()) {
			int[] sik = q.poll();
			int r = sik[0];
			int c = sik[1];
			int k = sik[2];
			int cnt = sik[3];
			
			if(arr[r][c] == '1') return cnt;
			
			for(int d=0; d<4; d++) {
				int nr = r+dir[d][0];
				int nc = c+dir[d][1];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] == '#') continue;
				char next = arr[nr][nc];
				int nkey = k;
							
//				문이면 key 체크, k가 key 비트 마스킹
				if (next >= 'A' && next <= 'F') {
					int need = 1 << (next - 'A');
					if((nkey & need) == 0) continue;
				}
				
//				열쇠면 획득
				if (next >= 'a' && next <= 'f') {
					nkey |= 1 << (next - 'a');
				}
				
				if(visited[nr][nc][nkey]) continue;
				visited[nr][nc][nkey] = true;
				q.add(new int[] {nr, nc, nkey, cnt+1});				
				
			}
			
		}
		
		return -1;
	}

}
