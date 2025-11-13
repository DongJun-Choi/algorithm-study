package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SW_5215_햄버거다이어트 {
    static int n;
    static int maxScore;
    static int maxKal;
    static int[] score;
    static int[] kal;

    public static void main(String[] args) {
        // 입력
        // 첫째줄에 test case 갯수
        // 테스트 케이스의 첫번째 줄 재료의 수, 제한 칼로리 N, L(1 ≤ N ≤ 20, 1 ≤ L ≤ 104)가 공백으로 구분 입력
        // 두번째 줄 맛점수, 칼로리 Ti, Ki(1 ≤ Ti ≤ 103, 1 ≤ Ki ≤ 103)가 공백으로 구분 입력
        // 출력
        // 주저진 제한 칼로리 이하의 조합중에서 가장 맛의 점수가 높은 햄버거 점수 출력
        // 로직
        // 같은 재료를 여러번 사용 불가
        // 이것도 결국 백트래킹을 사용해야할 것 같은뎅?
        // 필요한 것
        // 제한 칼로리를 더 못채우는 경우의 최대 칼로리 전역 변수
        // 깊이를 칼로리로 바꿔서 사용하기 위한 칼로리 전역 변수
        // 최고 점수만 저장하기 위한 최고 점수 전역 변수
        // 점수와 칼로리 저장할 배열?
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        
        for (int test_case=1; test_case<=c; test_case++) {
            n = sc.nextInt();
            maxKal = sc.nextInt();

            score = new int[n];
            kal = new int[n];
            maxScore = 0;

            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
                kal[i] = sc.nextInt();
            }

            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    static void dfs(int idx, int sumScore, int sumKal) {
        if (sumKal > maxKal) return;
        // 모든 메뉴를 돌았을 경우
        if (idx == n) {
            maxScore = Math.max(maxScore, sumScore);
            return;
        }
        
        dfs(idx+1, sumScore+score[idx], sumKal+kal[idx]);

        dfs(idx + 1, sumScore, sumKal);

    }
}
