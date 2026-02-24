import java.io.*;
import java.util.*;

public class Solution {
    static int N, W, H;
    static int min;
    static int[][] dir = { {-1,0},{1,0},{0,-1},{0,1} };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            int[][] arr = new int[H][W];
            int remain = 0; // 초기 벽돌 개수

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] != 0) remain++;
                }
            }

            min = Integer.MAX_VALUE;
            dfs(0, arr, remain);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }

    // depth번째 구슬 떨어뜨리기
    static void dfs(int depth, int[][] arr, int remain) {
        if (remain == 0) {
            min = 0;
            return;
        }
        if (depth == N) {
            min = Math.min(min, remain);
            return;
        }

        boolean emptyCalled = false; // 빈 열(-1)로 동일 상태 dfs 중복 호출 방지

        for (int c = 0; c < W; c++) {
            int r = firstBrickRow(arr, c);

            // 이 열은 아무것도 없음: 맵 변화 없으니 remain 그대로 (한 번만 호출)
            if (r == -1) {
                if (!emptyCalled) {
                    emptyCalled = true;
                    dfs(depth + 1, arr, remain);
                }
                continue;
            }

            int[][] next = new int[H][W];
            for (int i = 0; i < H; i++) {
                next[i] = Arrays.copyOf(arr[i], W);
            }

            // 부순 개수 받아서 remain에서 빼기
            int broken = boom(next, r, c);

            gravity(next);
            dfs(depth + 1, next, remain - broken);

            if (min == 0) return;
        }
    }

    // 해당 열의 가장 위의 벽돌 찾는 함수
    static int firstBrickRow(int[][] map, int c) {
        for (int r = 0; r < H; r++) {
            if (map[r][c] != 0) return r;
        }
        return -1;
    }

    // 폭발 처리(BFS): 부순 개수 리턴
    static int boom(int[][] map, int sr, int sc) {
        int broken = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int start = map[sr][sc];
        if (start == 0) return 0;

        // 시작 벽돌 제거
        if (start > 1) q.add(new int[]{sr, sc, start});
        map[sr][sc] = 0;
        broken++;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], power = cur[2];

            for (int d = 0; d < 4; d++) {
                int nr = r, nc = c;
                for (int k = 1; k < power; k++) {
                    nr += dir[d][0];
                    nc += dir[d][1];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;
                    if (map[nr][nc] == 0) continue;

                    int v = map[nr][nc];
                    if (v > 1) q.add(new int[]{nr, nc, v});

                    map[nr][nc] = 0;
                    broken++;
                }
            }
        }
        return broken;
    }

    // 중력: 각 열마다 아래에서부터 채우기
    static void gravity(int[][] map) {
        for (int c = 0; c < W; c++) {
            int write = H - 1;
            for (int r = H - 1; r >= 0; r--) {
                if (map[r][c] != 0) {
                    int v = map[r][c];
                    map[r][c] = 0;
                    map[write][c] = v;
                    write--;
                }
            }
        }
    }
}