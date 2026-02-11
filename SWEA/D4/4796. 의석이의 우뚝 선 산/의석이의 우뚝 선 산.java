import java.util.Scanner;

public class Solution {
	static int[] arr;
	static boolean[] dp;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			arr = new int[N];
			dp = new boolean[N];
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				if(i > 0) {
					dp[i] = (arr[i] > arr[i-1]);
				}
				
			}
			
//			첫번째 인덱스는 중요하지 않음
			int i = 1;
//			여기서 이제 증가 구간의 수, 감소구간의 수 찾고 증가구간, 감소구간하고 나머지 조합 구하기
			while (i < N) {

                int up = 0;
                int down = 0;

                // 증가 구간
                while (i < N && dp[i]) {
                    up++;
                    i++;
                }

                // 감소 구간
                while (i < N && !dp[i]) {
                    down++;
                    i++;
                }

                if (up > 0 && down > 0) {
                    sum += up * down;
                }
            }
			
			sb.append('#').append(tc).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
