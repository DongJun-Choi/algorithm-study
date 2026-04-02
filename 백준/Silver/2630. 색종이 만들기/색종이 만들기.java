import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int w, b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		w = 0;
		b = 0;
		
		solve(0, 0, n);
		
		System.out.println(w);
		System.out.println(b);
	}
	
	static void solve(int r, int c, int size) {
//		칸내에 색이 모두 같은지 체크
//		맞다면 숫자 체크하고 return
		
		int color = arr[r][c];
		if(isColor(r, c, size, color)) {
			if(color == 1) b++;
			else w++;
			return;
		}
		
		
		
//		아니라면 재귀 더 돌리기		
		int half = size / 2;
		
		solve(r, c, half);
		solve(r+half, c, half);
		solve(r, c+half, half);
		solve(r+half, c+half, half);
		
	}
	
	static boolean isColor(int r, int c, int size, int color) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(color != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
 