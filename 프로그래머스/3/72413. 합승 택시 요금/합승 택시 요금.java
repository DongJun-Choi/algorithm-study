import java.util.*;

class Solution {
    
    final int INF = 1_000_000_000;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n + 1][n + 1];

        // 1. 거리 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 2. 간선 정보 입력
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            dist[from][to] = cost;
            dist[to][from] = cost;
        }

        // 3. 모든 노드 간 최단거리 계산
        floydWarshall(dist, n);

        // 4. 갈라지는 지점 i를 모두 확인
        int answer = INF;

        for (int i = 1; i <= n; i++) {
            if (dist[s][i] == INF ||
                dist[i][a] == INF ||
                dist[i][b] == INF) {
                continue;
            }

            int totalCost =
                dist[s][i] +
                dist[i][a] +
                dist[i][b];

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }
    
    void floydWarshall(int[][] dist, int n) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) {
                        continue;
                    }

                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                    );
                }
            }
        }
    }
}