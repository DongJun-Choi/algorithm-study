import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n, k;
	static int[][] mountain;
	static int max;
	static int start;
	static int[][] del = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			mountain = new int[n][n];
			visited = new boolean[n][n];
			max = 0;
			start = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					mountain[i][j] = Integer.parseInt(st.nextToken());
					start = Math.max(start, mountain[i][j]);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (start == mountain[i][j]) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int r, int c, int cnt, boolean use) {

		max = Math.max(cnt, max);

		for (int i = 0; i < 4; i++) {
			int nr = r + del[i][0];
			int nc = c + del[i][1];

			if (nr >= n || nr < 0 || nc >= n || nc < 0)
				continue;

			if (canMove(r, c, nr, nc)) {
				visited[nr][nc] = true;
				dfs(nr, nc, cnt + 1, use);
				visited[nr][nc] = false;
			} else if (!use) {
				for (int j = 1; j <= k; j++) {
					mountain[nr][nc] -= j;
					if (canMove(r, c, nr, nc)) {
						visited[nr][nc] = true;
						dfs(nr, nc, cnt + 1, true);
						visited[nr][nc] = false;
						mountain[nr][nc] += j;
						break;
					}
					mountain[nr][nc] += j;
				}
				continue;
			}

		}

		return;

	}

	private static boolean canMove(int r, int c, int nr, int nc) {
		if (mountain[r][c] <= mountain[nr][nc])
			return false;
		if(visited[nr][nc]) return false;
		
		return true;
	}

}
