import java.util.*;
import java.io.*;

public class DP_1 {
    public static void main(String[] args) throws IOException {
        // 1904
        // 자연수 N 입력
        // 길이가 N인 모든 2진 수역 개수를 15746으로 나눈 나머지 출력
        // 00으로 하나의 묶음 처리, 1은 자유롭게
        // n=1 1, n=2 2, n=3 3, n=4 5, n=5 8, n=6 13, n=7 21
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[n]);
    }
}
