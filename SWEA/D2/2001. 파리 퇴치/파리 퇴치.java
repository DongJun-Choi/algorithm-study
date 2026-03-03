import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m, max;
	static int[][] arr;
	static int[][] dir = {{0, 1}, {1, 0}}; //우, 하
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			
			for(int i=0; i<n-m+1; i++) {
				for(int j=0; j<n-m+1; j++) {
					run(i, j);
					
				}
			}
			
			sb.append('#').append(tc).append(' ').append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void run(int row, int col) {
		int sum = 0;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				sum += arr[row+i][col+j];
			}
		}
		
		max = Math.max(max, sum);
	}

}
