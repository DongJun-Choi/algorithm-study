import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static List<int[]> humans;
    static int[][] stairs; // [2][3] => x, y, len
    static int[][] dist;   // dist[i][0], dist[i][1]
    static int[] select;   // 각 사람이 어느 계단을 선택했는지
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());

            humans = new ArrayList<>();
            stairs = new int[2][3];

            int sIdx = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(st.nextToken());

                    if (val == 1) {
                        humans.add(new int[] { i, j });
                    } else if (val > 1) {
                        stairs[sIdx][0] = i;
                        stairs[sIdx][1] = j;
                        stairs[sIdx][2] = val;
                        sIdx++;
                    }
                }
            }

            int hLen = humans.size();
            dist = new int[hLen][2];
            select = new int[hLen];
            answer = Integer.MAX_VALUE;

            // 사람별 각 계단까지 거리 미리 계산
            for (int i = 0; i < hLen; i++) {
                int x = humans.get(i)[0];
                int y = humans.get(i)[1];

                dist[i][0] = distance(x, y, stairs[0][0], stairs[0][1]);
                dist[i][1] = distance(x, y, stairs[1][0], stairs[1][1]);
            }

            dfs(0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    // 사람마다 0번 계단 / 1번 계단 선택
    static void dfs(int depth) {
        if (depth == humans.size()) {
            answer = Math.min(answer, simulate());
            return;
        }

        select[depth] = 0;
        dfs(depth + 1);

        select[depth] = 1;
        dfs(depth + 1);
    }

    static int simulate() {
        List<Integer> stair0 = new ArrayList<>();
        List<Integer> stair1 = new ArrayList<>();

        // 선택된 계단 기준으로 도착시간 분리
        for (int i = 0; i < humans.size(); i++) {
            if (select[i] == 0) {
                stair0.add(dist[i][0]);
            } else {
                stair1.add(dist[i][1]);
            }
        }

        int time0 = calcStairTime(stair0, stairs[0][2]);
        int time1 = calcStairTime(stair1, stairs[1][2]);

        return Math.max(time0, time1);
    }

    static int calcStairTime(List<Integer> arrivals, int stairLen) {
        if (arrivals.isEmpty()) return 0;

        Collections.sort(arrivals);

        int size = arrivals.size();
        int[] finish = new int[size];

        for (int i = 0; i < size; i++) {
            // 계단 입구 도착 후 1분 뒤에 내려가기 시작
            int start = arrivals.get(i) + 1;

            // 이미 3명이 내려가고 있으면, 가장 먼저 끝나는 사람 이후에 시작
            if (i >= 3 && finish[i - 3] > start) {
                start = finish[i - 3];
            }

            finish[i] = start + stairLen;
        }

        return finish[size - 1];
    }

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}