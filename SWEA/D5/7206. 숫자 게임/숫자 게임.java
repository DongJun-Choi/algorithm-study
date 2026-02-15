import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		dp = new int[100000];
		for (int i = 0; i < dp.length; i++) dp[i] = -1;
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());			
//			N이라는 숫자를 자릿수를 기준으로 최대 5개가 나오는데 이 순열을 구해야 함.
			
//			그 순열이 구해지면 그 순열만큼 돌려야 함.
			
//			돌리는 도중에 N < 10 이면
//			count 값이랑 max값 비교 해서 return
			
			int ans = solve(n);
			
			sb.append('#').append(tc).append(' ').append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	static int solve(int n) {
        if (n < 10) return 0;
        if (n < dp.length && dp[n] != -1) return dp[n];

        String s = String.valueOf(n);
        int len = s.length();

        int best = 0;

        // len-1개의 경계(자리 사이)를 끊을지 말지 선택
        // mask==0 은 "아예 안 끊음"이라서 최소 2조각 조건에 위배 -> 제외
        int total = 1 << (len - 1);
        for (int mask = 1; mask < total; mask++) {
            int product = 1;
            int start = 0;

            for (int i = 0; i < len - 1; i++) {
                if ((mask & (1 << i)) != 0) { // i와 i+1 사이를 끊는다
                    int part = Integer.parseInt(s.substring(start, i + 1));
                    product *= part;
                    start = i + 1;
                }
            }

            // 마지막 조각
            int last = Integer.parseInt(s.substring(start));
            product *= last;

            // 이번에 한 번 수행했으니 +1
            best = Math.max(best, 1 + solve(product));
        }

        if (n < dp.length) dp[n] = best;
        return best;
    }
	

}
