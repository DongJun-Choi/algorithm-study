import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static boolean[] visited = new boolean[100000];
	static int[] dp = new int[100000];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
//			어떻게 풀더라
//			순열을 구해야함. 어떤 순열? 그 수가 있다면 수를 끊는
//			어떻게 판단함? 비트마스킹? 한 숫자의 자릿수가 있으면 그 자릿수 - 1의 비트를 가진 숫자
			
//			가져서 뭐함? 그 숫자를 가지고 순열을 싹다 돌리기
//			dp는 왜 사용함? 만약 n의 숫자가 이미 했던 숫자라면 그 숫자의 최솟값 저장해서 사용? 
//			카운트 값은 어떻게 저장할까?
			
			sb.append('#').append(tc).append(' ').append(solve(n)).append("\n");
		}
		
		System.out.println(sb);
	}

	static int solve(int num) {
//		자릿수를 알기 위해서는?
		if(num < 10) return 0;
		
		if (visited[num]) return dp[num];
        visited[num] = true;
		
		String s = String.valueOf(num);
		int len = s.length();
		int max = 0;
		
//		i가 1씩 증가하니까 순열로 사용
//		(ex. num이 1234라면 2^2(자릿수-2?) = 4(100) => 1 | 2 | 3 | 4)
//		(ex. num이 12345라면 2^3(자릿수-2?) = 8(1000) => 1 | 2 | 3 | 4 | 5)
//		(ex. num이 12라면 2^0(자릿수-2?) = 1 => 1 | 2)
//		(ex. num이 123라면 2^1(자릿수-2?) = 2(10) => 1 | 2 | 3)
		for(int mask=1; mask < (1 << (len-1)); mask++) {
			long product = 1;
			int cur = 0;
			
			for(int i=0; i<len; i++) {
				cur = cur * 10 + (s.charAt(i) - '0');
				
				if(i == len-1 || (mask & (1 << i)) != 0) {
					product *= cur;
					cur = 0;
				}
			}
			
			max = Math.max(max, 1+solve((int) product));			
		}
		
		dp[num] = max;		
		return dp[num];
	}
}
