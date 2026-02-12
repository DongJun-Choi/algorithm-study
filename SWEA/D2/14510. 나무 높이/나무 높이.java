import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			
//			어떻게 하더라?
//			2로 나누고 1이 남는지 체크
//			이제 그걸 만족하는지 while문으로 day로 해서 빼기?
			
			int day2 = 0;
			int day1 = 0;
			
			for(int i=0; i<N; i++) {
				day2 += (max-arr[i]) / 2;
				if((max-arr[i]) % 2 == 1) {
					day1 += 1;
				}
			}		
			int count = dayCnt(day2, day1);
			
			
			day2 = 0;
			day1 = 0;
			max += 1;
			for(int i=0; i<N; i++) {
				day2 += (max-arr[i]) / 2;
				if((max-arr[i]) % 2 == 1) {
					day1 += 1;
				}
			}
			int count1 = dayCnt(day2, day1);
			
			
			count = Math.min(count, count1);
			
			sb.append('#').append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
//	값 만큼 돌리기?
	private static int dayCnt(int day2, int day1) {
		int D = 0;
		while(true) {
		    int odd = (D + 1) / 2;
		    int even = D / 2;

		    if (odd >= day1) {
		        int remainOdd = odd - day1;
		        int totalEven = even + remainOdd / 2;

		        if (totalEven >= day2) break;
		    }

		    D++;
		}
		return D;
	}
}
