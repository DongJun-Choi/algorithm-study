import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
//			마을에 N명의 사람 살고 있음
//			서로 다 아는게 아님. 아는 사람끼리 하나의 무리로 묶음
//			무리의 수는?
			
//			양방향으로 해서. 연결된 모든 것을 하나의 무리
			
			p = new int[n+1];
			for(int i = 1; i <= n; i++) {
			    p[i] = i;
			}
			
			boolean[] group = new boolean[n+1];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				int px = find(x);
				int py = find(y);

				if(px != py) {
				    if(px > py) p[px] = py;
				    else p[py] = px;
				}		
			}
			
			for(int i=1; i<=n; i++) {
				int g = find(i);
				group[g] = true;	
			}
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(group[i]) {
					cnt++;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int find(int x) {		
		if(x == p[x]) return x;
	    return p[x] = find(p[x]);
	}

}
