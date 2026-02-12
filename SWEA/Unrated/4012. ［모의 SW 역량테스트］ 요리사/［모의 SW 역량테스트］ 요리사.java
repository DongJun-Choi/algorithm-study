import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visited;
	static int N, min;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
//			완전 탐색으로는
//			음식의 조합(N/2, N/2 개씩 나눠 가지는 모든 조합)을 구하고 그 조합의 요리 점수 모아서 점수 차 얻기
//			가장 작은 값만 출력
//			줄이는 방법? 나중에 생각
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			combi(0, 0);
			
			sb.append('#').append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void combi(int start, int cnt) {
//		조합도 절반으로 줄일 수 있을 거 같은데?
//		어떻게 줄일까?
		if(cnt == N/2) {
			int[] arr1 = new int[N/2];
			int[] arr2 = new int[N/2];
			int cnt1 = 0;
			int cnt2 = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					arr1[cnt1++] = i;
				} else {
					arr2[cnt2++] = i;
				}
			}
			min = Math.min(min, Math.abs(synergy(arr1)-synergy(arr2)));			
			return;
		}
		
		for(int i=start; i<N; i++) {
			visited[i] = true;
			combi(i+1, cnt+1);
			visited[i] = false;
		}
	}
	
	private static int synergy(int[] numbers) {
		int sum = 0;
		for(int i=0; i<numbers.length; i++) {
			for(int j=0; j<numbers.length; j++) {
				sum += arr[numbers[i]][numbers[j]];
			}
		}
		
		return sum;
	}

}
