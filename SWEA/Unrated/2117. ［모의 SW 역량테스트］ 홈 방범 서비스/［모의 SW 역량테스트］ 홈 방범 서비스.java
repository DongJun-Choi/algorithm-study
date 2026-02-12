import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, max;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int k=1; k<=2*N; k++) {
						max = Math.max(max, Calculation(i, j, k));
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	private static int Calculation(int r, int c, int n) {

	    int count = 0;

	    for(int i = r - (n - 1); i <= r + (n - 1); i++) {

	        if(i < 0 || i >= N) continue;

	        int dist = Math.abs(i - r);
	        int width = n - dist;

	        int start = c - (width - 1);
	        int end   = c + (width - 1);

	        for(int j = start; j <= end; j++) {

	            if(j < 0 || j >= N) continue;

	            count += arr[i][j];
	        }
	    }

	    int cost = n * n + (n - 1) * (n - 1);

	    if(count * M >= cost) {
	        return count;
	    }

	    return 0;
	}


}
