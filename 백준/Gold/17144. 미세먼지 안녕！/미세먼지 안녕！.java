import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c, t;
	static int[] startR = new int[2];
	static int[] startC = new int[2];
	
	static int[][][] arr;
	
	static int[][] dir1 = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //우 상 좌 하
	static int[][] dir2 = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //우 하 좌 상
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		arr = new int[2][r][c];
		
		int cnt = 0;
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				arr[0][i][j] = Integer.parseInt(st.nextToken());
				if(arr[0][i][j] == -1) {
					startR[cnt] = i;
					startC[cnt] = j;
					arr[1][i][j] = -1;
					cnt++;
				}
			}
		}
		
//		1초동안 미세먼지 확산 => 공기청정기 작동
//		미세먼지 = X, 미세먼지는 확산(상하좌우로, 확산되는 양은 X/5)
//		인접한 방향에 공기청정기, 칸이 없으면 확산 x
//		남은 미세먼지의 양은 X/5 + (X/5)*확산안된 칸개수
//		공기청정기 작동하면 위쪽은 반시계방향으로 순환, 아래쪽은 시계방향 순환
//		바람이 불면 바람 방향대로 모두 한 칸씩 이동
//		먼지가 공기청정기로 들어가면 정화
		cnt = 0;
		while(cnt < t) {
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(arr[0][i][j] > 0) {
						Spread(i, j);
					}
				}
			}
			
			wind();			
			
			cnt++;
		}
		
		int ans = count();
		
		System.out.println(ans);
	}
	
//	미세 먼지 확산
	static void Spread(int row, int col) {
//		arr[0]이 기존, arr[1] 확산 결과 저장
		int value = arr[0][row][col] / 5;
		int nValue = arr[0][row][col];
		
		for(int d=0; d<4; d++) {
			int nr = row+dir1[d][0];
			int nc = col+dir1[d][1];
			
			if(nr >= r || nr < 0 || nc >= c || nc < 0) continue;
			if(arr[0][nr][nc] == -1) continue;
			
			arr[1][nr][nc] += value;
			nValue -= value;
		}
		
		arr[1][row][col] += nValue;
	}
	
//	공기청정기 바람 불기
	static void wind() {
//		r1 반시계, r2 시계
		
		int r1 = startR[0];
		int r2 = startR[1];
		int c1 = startC[0];
		int c2 = startC[1];
		
		int nr1 = r1;
		int nc1 = c1;
		int nr2 = r2;
		int nc2 = c2;
		
		int old = 0;
		for(int d=0; d<4; d++) {
			while(true) {
				nr1 += dir1[d][0];
				nc1 += dir1[d][1];
				
				if(nr1 >= r || nr1 < 0 || nc1 >= c || nc1 < 0) {
					nr1 -= dir1[d][0];
					nc1 -= dir1[d][1];
					break;
				}
				
				if(arr[1][nr1][nc1] == -1) break;
				
				int temp = arr[1][nr1][nc1];
				arr[1][nr1][nc1] = old;
				old = temp;				
			}			
		}
		
		old = 0;
		for(int d=0; d<4; d++) {
			while(true) {
				nr2 += dir2[d][0];
				nc2 += dir2[d][1];
				
				if(nr2 >= r || nr2 < 0 || nc2 >= c || nc2 < 0) {
					nr2 -= dir2[d][0];
					nc2 -= dir2[d][1];
					break;
				}
				
				if(arr[1][nr2][nc2] == -1) break;
				
				int temp = arr[1][nr2][nc2];
				arr[1][nr2][nc2] = old;
				old = temp;				
			}			
		}
		
		for(int i=0; i<r; i++) {
			arr[0][i] = Arrays.copyOf(arr[1][i], c);
			Arrays.fill(arr[1][i], 0);
		}
		for(int i=0; i<2; i++) {
			arr[1][startR[i]][startC[i]] = -1;
		}
		
	}
	
//	미세먼지 숫자 세는 함수
	static int count() {
		int cnt = 0;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[0][i][j] > 0) {
					cnt += arr[0][i][j];
				}
			}
		}
		
		return cnt;
	}
	
//	방 현황 보여주는 함수
	static void print(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				sb.append(arr[n][i][j]).append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
