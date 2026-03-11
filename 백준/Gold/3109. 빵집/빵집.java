import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static boolean[][] visited;
	static int[][] arr;
	
	static int[][] dir = {{-1,1}, {0,1}, {1,1}}; // 우상, 우, 우하

	static boolean dfs(int r, int c) {
        if (c == C - 1) return true;

        for (int d = 0; d < 3; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (visited[nr][nc]) continue;
            if (arr[nr][nc] == 1) continue;

            visited[nr][nc] = true;

            if (dfs(nr, nc)) return true;
        }

        return false;
    }
		
		
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				if(s.charAt(j) == '.') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < R; i++) {
            visited[i][0] = true;
            if (dfs(i, 0)) count++;
        }
		
		System.out.println(count);
	}
	
	
}
