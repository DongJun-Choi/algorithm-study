import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int min;
	static int[] price;
	static int[] month;
	static int[] dp = new int[13];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			month = new int[13];
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int i=0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
//			월의 일권*일수 <= 1달이용권 이면 1달 이용권
//			월이 3개 이상이면 각 월의 조합(가격들, 연속된 값, 0일인 달도 포함 가능)에서 3달 이용권보다 비싼 경우의 수가 있으면 3달 이용권으로 변경
//			이후 모든 가격과 1년 이용권 가격 비교
			
			min = Integer.MAX_VALUE;
			run(1);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void run(int idx) {
		if(idx == 13) {			
			if(dp[idx-1] > price[3]) {
				dp[idx-1] = price[3];
			}
			min = Math.min(min, dp[idx-1]);
			return;
		}
		
		int day = month[idx]*price[0];
		if(day > price[1]) {
			day = price[1];
		}
		if(idx == 1) {
			dp[idx] = day;
		} else if(idx == 2) {
			dp[idx] = dp[idx-1]+day;
		} else {
			dp[idx] = dp[idx-1]+day;
			dp[idx] = Math.min(dp[idx], dp[idx-3]+price[2]);
		}
		
		run(idx+1);
	}

}
