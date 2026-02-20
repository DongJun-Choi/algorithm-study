import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n]; 

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int rgbCnt = 0;
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j]) continue;
//				System.out.println("정상: "+i+" "+j);
				rgb(i, j, arr[i][j]);
				rgbCnt++;
			}
		}
		
		int rbCnt = 0;
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j]) continue;
//				System.out.println("색약: "+i+" "+j);
				rb(i, j, arr[i][j]);
				rbCnt++;
			}
		}
		
//		r과 g를 같이 보냐 안보냐의 차이
//		함수 2개 만들어서 하기 vs 한 함수로 끝내기
		
		System.out.println(rgbCnt+" "+rbCnt);
		
	}
	
	private static void rgb(int r, int c, char color) {
		if(visited[r][c]) return;
		visited[r][c] = true;		
		
		for(int i=0; i<4; i++) {
			int nr = r+del[i][0];
			int nc = c+del[i][1];
			
			if(nr >= n || nr < 0 || nc >= n || nc < 0) continue;
			if(arr[nr][nc] == color) {
				rgb(nr, nc, color);
			}
		}
	}
	
	private static void rb(int r, int c, char color) {
		if(visited[r][c]) return;
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r+del[i][0];
			int nc = c+del[i][1];
			
			if(nr >= n || nr < 0 || nc >= n || nc < 0) continue;
			
//			B는 B일때만
//			g, r은 같은거
			if(color == 'B' && arr[nr][nc] == 'B') {
				rb(nr, nc, color);
			} else if(color != 'B' && arr[nr][nc] != 'B') {
				rb(nr, nc, color);
			}
		}	
		
	}
	

}
