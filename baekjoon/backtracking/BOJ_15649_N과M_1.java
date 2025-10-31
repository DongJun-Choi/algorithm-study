package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15649_N과M_1 {
    static int n, m;
    static boolean[] used;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 입력
        // 첫째 줄에 자연수 N과 M 입력(1<=M<=N<=8)
        // 출력
        // 한줄에 하나씩 문제의 조건을 만족하는 수열 출력
        // 로직
        // 중복되는 수열은 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
        // 수열은 사전 순으로 증가하는 순서로 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        used = new boolean[n+1];
        result = new int[m];

        dfs(0);
        System.out.println(sb.toString());
        
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i=0; i<m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!used[num]) {
                used[num] = true;
                result[depth] = num;

                dfs(depth+1);

                used[num] = false;
            }
        }
    }
}