import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {
	static int min, B, N;
	static int[] high;
	
	public static void main(String[] args) throws Exception {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb = new StringBuilder();
		st.nextToken();
		int t = (int) st.nval;
		
		for(int tc=1; tc<=t; tc++) {
			st.nextToken();
			N = (int) st.nval;
			st.nextToken();
			B = (int) st.nval;
			high = new int[N];
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				st.nextToken();
				high[i] = (int) st.nval;
			}
			
//			걍 점원들 조합에서 H넘으면서 높이가 가장 낮은 값을 찾으면 되는거 아님?
			
			run(0, 0);
			
			sb.append('#').append(tc).append(" ").append(min-B).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	private static void run(int idx, int sum) {		
		if(idx == N) {
			if(sum >= B) {
				min = Math.min(min, sum);
			}
			return;
		}
		
		if(sum > min) return;
		
		run(idx+1, sum+high[idx]);
		run(idx+1, sum);
		
	}

}
