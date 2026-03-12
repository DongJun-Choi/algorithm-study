import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, w, h, min;
	static int[][][] arr;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			arr = new int[n+1][h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[0][i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			벽돌을 쏘는 조합 w에서 골라 N번 중복 허용
			min = Integer.MAX_VALUE;
			
			perm(0);
			
			
//			벽돌을 쏘면 그 위치에서 어디부터 어디까지 터지는지 판단
//			터지는 것 확인하고, 정렬하는 함수
//			남은 벽돌 개수 세는 함수
		
			sb.append('#').append(tc).append(' ').append(min).append("\n");			
		}
		System.out.println(sb);
	}
	
//	1~n번까지 선택된 수를 돌려야함.
//	개인적으로 0, 0, 0, 0, 0 => 0, 0, 0, 0, 1 이런식으로 맨 마지막 선택부터 바꾸는 조합
	static void perm(int idx) {
	    if(idx == n) {
	        min = Math.min(min, count());
	        return;
	    }

	    for(int i = 0; i < w; i++) {
	        boom(idx + 1, i);
	        perm(idx + 1);
	    }
	}
	
	
//	몇번째인가, 어디를 터칠건가
	static void boom(int num, int start) {
		for(int i=0; i<h; i++) {
			arr[num][i] = Arrays.copyOf(arr[num-1][i], w);
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {search(num, start), start});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			int cnt = arr[num][r][c] - 1;
			arr[num][r][c] = 0;
			
			for(int d=0; d<4; d++) {
				int nr = r;
				int nc = c;
				for(int i=0; i<cnt; i++) {
					nr += dr[d];
					nc += dc[d];
					
					if(nr >= h || nr < 0 || nc >= w || nc < 0) continue;
					
					if(arr[num][nr][nc] == 0) continue;
					
					q.add(new int[] {nr, nc});
				}
			}				
		}
		
		sort(num);
		
	}
	
	static void print(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num+"번째 맵").append("\n");
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				sb.append(arr[num][i][j]).append(' ');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
//	정렬하는 함수
	static void sort(int num) {
		for(int i=0; i<w; i++) {
			int block = 0;
			for(int j=h-1; j>=0; j--) {
				if(arr[num][j][i] != 0) {
					arr[num][h-1-block][i] = arr[num][j][i];
					
					if((h-1-block) != j) arr[num][j][i] = 0;
					
					block++;
				}
			}
		}

	}
	
//	그 줄에 가장 첫번째 블록 찾기
	static int search(int num, int start) {
		int idx = 0;
		
		for(int i=0; i<h; i++) {
			if(arr[num][i][start] != 0) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	
//	맵에 블록 갯수 세는 함수
	static int count() {
		int count = 0;
		
		for(int i=0; i<w; i++) {
			for(int j=h-1; j>=0; j--) {
				if(arr[n][j][i] == 0) break;
				count++;
			}
		}
		
		return count;
	}

}
