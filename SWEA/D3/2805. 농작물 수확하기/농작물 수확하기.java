import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			int check = N/2;
			int sum = 0;
			for(int i=0; i<N/2; i++) {
				String s1 = br.readLine();
				for(int j=0; j<N; j++) {
					arr[i][j] = s1.charAt(j) - '0';
				}
				sum += arr[i][check];
				for(int k=1; k<i+1; k++) {
					sum += arr[i][check-k];
					sum += arr[i][check+k];
				}
			}
			
			for(int i=N/2; i<N; i++) {
				String s1 = br.readLine();
				for(int j=0; j<N; j++) {
					arr[i][j] = s1.charAt(j) - '0';
				}
				sum += arr[i][check];
				for(int k=N-1-i; k>0; k--) {
					sum += arr[i][check-k];
					sum += arr[i][check+k];
				}
			}
			
			sb.append('#').append(tc).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}

}
