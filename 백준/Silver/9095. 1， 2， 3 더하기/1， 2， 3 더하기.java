import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			cnt = 0;
			
			dfs(0);
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
	}
	
	static void dfs(int num) {
		if(num == n) {
			cnt += 1;
			return;
		}
		
		for(int i=1; i<=3; i++) {
			if(num+i > n) break; 
			dfs(num+i);
		}		
		
	}

}
