import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int H, W;
	static char[][] arr;
	static int[] tank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			
			tank = new int[2];
			
			for(int i=0; i<H; i++) {
				String s = br.readLine();  
				for(int j=0; j<W; j++) {
					arr[i][j] = s.charAt(j);
					if(arr[i][j] == '^' || arr[i][j] == 'v' || arr[i][j] == '<' || arr[i][j] == '>') {
						tank[0] = i;
						tank[1] = j;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				input(c);				
			}
			
//			. : 평지, 전차 이동 가능
//			* : 벽돌 벽, 포탄으로 파괴 가능 파괴 시 평지
//			# : 강철 벽, 못 부심
//			- : 물, 전차 못 지나감
//			^, v, <, > : 전차, 상하좌우 바라보는 표시
//			전차는 평지만 이동 가능, 이동시 바라보는 방향을 이동하는 방향으로 변경, 맵 밖으로 못 나감
//			U : 위로 이동
//			D : 아래로 이동
//			L : 왼쪽으로 이동
//			R : 오른쪽으로 이동
//			S : 바라보는 방향으로 포탄 발사
//			포탄은 벽돌 벽을 만나면 파괴(평지로 변경) 하고 소멸, 맵밖으로 나가도 소멸, 강철 벽을 만나도 소멸			
			
			sb.append('#').append(tc).append(" ");
			
			for(int i=0; i<H; i++) { 
				for(int j=0; j<W; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	private static void input(char C) {
		int r = tank[0];
		int c = tank[1];
		int nr = 0;
		int nc = 0;
		switch (C) {
		case 'U':
			arr[r][c] = '^';
			nr = r + del[0][0];
			nc = c + del[0][1];
			if(nr >= 0 && nr < H && nc >= 0 && nc < W && arr[nr][nc] == '.') {
				arr[r][c] = '.';
				arr[nr][nc] = '^';
				tank[0] = nr;
				tank[1] = nc;
			}
			break;
		case 'D':
			arr[r][c] = 'v';
			nr = r + del[1][0];
			nc = c + del[1][1];
			if(nr >= 0 && nr < H && nc >= 0 && nc < W && arr[nr][nc] == '.') {
				arr[r][c] = '.';
				arr[nr][nc] = 'v';
				tank[0] = nr;
				tank[1] = nc;
			}
			break;
		case 'L':
			arr[r][c] = '<';
			nr = r + del[2][0];
			nc = c + del[2][1];
			if(nr >= 0 && nr < H && nc >= 0 && nc < W && arr[nr][nc] == '.') {
				arr[r][c] = '.';
				arr[nr][nc] = '<';
				tank[0] = nr;
				tank[1] = nc;
			}
			break;
		case 'R':
			arr[r][c] = '>';
			nr = r + del[3][0];
			nc = c + del[3][1];
			if(nr >= 0 && nr < H && nc >= 0 && nc < W && arr[nr][nc] == '.') {
				arr[r][c] = '.';
				arr[nr][nc] = '>';
				tank[0] = nr;
				tank[1] = nc;
			}
			break;
		case 'S':
			shot(arr[r][c]);
			break;
		}
	}
	
	private static void shot(char C) {
		int nr = tank[0];
		int nc = tank[1];
		switch (C) {
		case '^':
			while(true) {
				nr = nr + del[0][0];
				nc = nc + del[0][1];
				if(nr >= H || nr < 0 || nc >= W || nc < 0 || arr[nr][nc] == '#') {
					break;
				}
				
				if(arr[nr][nc] == '*') {
					arr[nr][nc] = '.';
					break;
				}				
			}
			break;
		case 'v':
			while(true) {
				nr = nr + del[1][0];
				nc = nc + del[1][1];
				if(nr >= H || nr < 0 || nc >= W || nc < 0 || arr[nr][nc] == '#') {
					break;
				}
				
				if(arr[nr][nc] == '*') {
					arr[nr][nc] = '.';
					break;
				}				
			}
			break;
		case '<':
			while(true) {
				nr = nr + del[2][0];
				nc = nc + del[2][1];
				if(nr >= H || nr < 0 || nc >= W || nc < 0 || arr[nr][nc] == '#') {
					break;
				}
				
				if(arr[nr][nc] == '*') {
					arr[nr][nc] = '.';
					break;
				}				
			}
			break;
		case '>':
			while(true) {
				nr = nr + del[3][0];
				nc = nc + del[3][1];
				if(nr >= H || nr < 0 || nc >= W || nc < 0 || arr[nr][nc] == '#') {
					break;
				}
				
				if(arr[nr][nc] == '*') {
					arr[nr][nc] = '.';
					break;
				}			
			}
			break;
		}
	}
	

}
