import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    private int[][] dp;
    private boolean[][] puddleMap;

    private final int[][] dir = {
        {0, 1},   // 오른쪽
        {1, 0}    // 아래
    };

    public int solution(int m, int n, int[][] puddles) {

        dp = new int[n + 1][m + 1];
        puddleMap = new boolean[n + 1][m + 1];

        // 아직 계산하지 않은 상태를 -1로 표시
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // 웅덩이 위치 저장
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            puddleMap[y][x] = true;
        }

        return dfs(1, 1, m, n);
    }

    private int dfs(int y, int x, int m, int n) {

        // 범위를 벗어난 경우
        if (y > n || x > m) {
            return 0;
        }

        // 웅덩이인 경우
        if (puddleMap[y][x]) {
            return 0;
        }

        // 학교 도착
        if (y == n && x == m) {
            return 1;
        }

        // 이미 계산한 위치
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        long count = 0;

        for (int[] d : dir) {
            int ny = y + d[0];
            int nx = x + d[1];

            count += dfs(ny, nx, m, n);
        }

        dp[y][x] = (int) (count % MOD);

        return dp[y][x];
    }
}