import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
			}
		}
		
		while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + del[d][0];
                int nc = c + del[d][1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                if (arr[nr][nc] == 0) {
                    arr[nr][nc] = arr[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
		
		int max = 1;
		
		for (int r = 0; r < m; r++) {
           for (int c = 0; c < n; c++) {
               if (arr[r][c] == 0) {
                   System.out.println(-1);
                   return;
               }
               max = Math.max(max, arr[r][c]);
           }
		}
		
		System.out.println(max-1);
		
	}

}
