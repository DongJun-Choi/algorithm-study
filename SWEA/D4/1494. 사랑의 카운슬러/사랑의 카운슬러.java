import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n;
	static long min, totalX, totalY;
	
	static int[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][2];

			totalX = 0;
			totalY = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				totalX += arr[i][0];
				totalY += arr[i][1];
			}
			
//			조합 만들기(랜덤으로 2개씩 짝 지어서 벡터 구하기)
			
//			각 조합에 따라서 벡터 계산 및 더하기
			
//			최솟값 비교하고 최신화

			min = Long.MAX_VALUE;
			
			dfs(1, 1, arr[0][0], arr[0][1]);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}

		System.out.print(sb);
	}
	
	static void dfs(int start, int cnt, long sumX, long sumY) {

		if (cnt == n / 2) {
	        long vx = 2 * sumX - totalX;
	        long vy = 2 * sumY - totalY;
	        long sum = vx * vx + vy * vy;
	        min = Math.min(min, sum);
	        return;
	    }

		for (int i = start; i < n; i++) {
	        dfs(i + 1, cnt + 1, sumX + arr[i][0], sumY + arr[i][1]);
	    }
	}

}
