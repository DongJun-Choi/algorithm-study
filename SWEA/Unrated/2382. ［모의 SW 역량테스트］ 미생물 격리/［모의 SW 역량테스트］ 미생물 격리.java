import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Micro {
	    int r, c, num, d;
	    Micro(int r, int c, int num, int d) {
	        this.r = r; this.c = c; this.num = num; this.d = d;
	    }
	}
	
	static int[][] dir = {{0, 0}, {-1,0}, {1,0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); //돌리는 시간
			int k = Integer.parseInt(st.nextToken()); //군집의 개수
			int size = n;
			int[][] arr = new int[size][size];
			
			Micro[] groups = new Micro[k];
			
//			칸을 2배로 늘려, 미생물의 이동을 0.5초 단위로 실행 이에 맞춰 받는 좌표값도 수정 필요
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken()); //미생물 수
				int d = Integer.parseInt(st.nextToken()); //방향
				groups[i] = new Micro(r, c, num, d);
			}
			
			int cnt = 0;
			while(cnt < m) {
//				미생물 이동 다 시키기
				for(int i=0; i<k; i++) {
					int r = groups[i].r;
					int c = groups[i].c;
					int num = groups[i].num;
					int d = groups[i].d;
					
					if(num == 0) {
						continue;
					}
					
					int nr = r+dir[d][0];
					int nc = c+dir[d][1];
					
					if(nr == 0 || nr == size-1 || nc == 0 || nc == size-1) {
						if(d == 1 || d == 3) groups[i].d += 1;
						if(d == 2 || d == 4) groups[i].d -= 1;
						
						groups[i].num = num / 2;
						
						if(groups[i].num == 0) continue;
					}
					
					groups[i].r = nr;
					groups[i].c = nc;	
				}
				
				
//				미생물 이동에서 좌표 같은 것이 있는지 확인하기
//				어떻게 같은지 확인할까? 무식하게 다 확인해버릴까?
				
				
//				좌표 같은지 확인작업
				List<List<Integer>> list = new ArrayList<>();
				
				for(int i=0; i<k; i++) {
					int r = groups[i].r;
					int c = groups[i].c;
					int num = groups[i].num;
					list.add(new ArrayList<>());
					
					if(num == 0) {
						continue;
					}
					
					
					for(int j=i+1; j<k; j++) {
						if(groups[i].num == 0) continue;
						int nr = groups[j].r;
						int nc = groups[j].c;
						
						if(r == nr && c == nc) {
							list.get(i).add(j);
						}
					}
				}
				
//				같은 좌표 처리
				for (int i = 0; i < k; i++) {
				    if (groups[i].num == 0) continue;
				    if (list.get(i).isEmpty()) continue;

				    int sum = groups[i].num;
				    int max = groups[i].num;
				    int keepDir = groups[i].d;

				    for (int j : list.get(i)) {
				        if (groups[j].num == 0) continue;

				        sum += groups[j].num;

				        if (groups[j].num > max) {
				            max = groups[j].num;
				            keepDir = groups[j].d;
				        }

				        groups[j].num = 0;
				    }

				    groups[i].num = sum;
				    groups[i].d = keepDir;
				}				
				
				cnt++;
			}
			
			int sum = 0;
			for(int i=0; i<k; i++) {
				sum += groups[i].num;							
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
