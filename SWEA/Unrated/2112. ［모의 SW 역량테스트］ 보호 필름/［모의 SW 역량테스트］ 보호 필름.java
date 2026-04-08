import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int d, w, k;
	static int[] drug;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();

	        int t = Integer.parseInt(br.readLine());

	        for (int tc = 1; tc <= t; tc++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	d = Integer.parseInt(st.nextToken());
	        	w = Integer.parseInt(st.nextToken());
	        	k = Integer.parseInt(st.nextToken());
	        	
	        	drug = new int[d];
	        	Arrays.fill(drug, -1);
	        	
	        	map = new int[d][w];
	        	for(int i=0; i<d; i++) {
	        		st = new StringTokenizer(br.readLine());
	        		for(int j=0; j<w; j++) {
	        			map[i][j] = Integer.parseInt(st.nextToken());
	        		}
	        	}
	        	
	        	result = d;
	        	
	        	bfs(0, 0);
	        	
	        	
	        	sb.append("#").append(tc).append(" ").append(result).append("\n");
	        }

	        System.out.print(sb);
	}
	
	static void bfs(int idx, int count) {
		if(idx == d) {
			if(isPass()) {
//				drug의 -1이 아닌 갯수 찾기
				result = Math.min(result, count);
			}
			return;
		}
		
		drug[idx] = -1;
		bfs(idx+1, count);
		
		drug[idx] = 0;		
		bfs(idx+1, count+1);
		
		drug[idx] = 1;		
		bfs(idx+1, count+1);		
	}
	
	static boolean isPass() {
		for(int i=0; i<w; i++) {
			int cnt = 1;
			boolean colPass = false;
			for(int j=1; j<d; j++) {
				int priv = drug[j-1] == -1 ? map[j-1][i] : drug[j-1];
				int cur = (drug[j] == -1) ? map[j][i] : drug[j];
				
				if(priv == cur) cnt++;
				else cnt = 1;
				
				if(cnt >= k) {
					colPass = true;
					break;
				}
			}
			if(!colPass) {
				return false;
			}
		}
		
		return true;
	}
}
