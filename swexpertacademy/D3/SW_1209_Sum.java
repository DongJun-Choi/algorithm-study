package D3;

import java.util.Scanner;

public class SW_1209_Sum {

    public static void main(String[] args) {
        // 입력 10개의 케이스 입력
        // 첫줄에는 테스트케이스 번호
        // 이후 100개의 줄에 각 줄마다 100개의 숫자 입력(각 행의 합은 integer 범위 안벗어남)
        // 출력
        // 각 열의 합, 각 행의 합, 각 대각선의 합 중에서 최댓값 출력
        // 로직
        // 각 열은 입력 받으면서 확인 가능
        // 각 행은 입력 받은 후 가능
        // 각 대각선도 입력 받은 후 가능
        // 각 행의 합을 구하면서 대각선의 값 구하기 가능 할듯
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case=1; test_case<=T; test_case++) {
            int n = sc.nextInt();
            int[][] arr = new int[100][100];
            int maxValue = 0;
            int row = 0;
            int column = 0;
            int Leftdiagonal = 0;
            int RightDiagonal = 0;
            for (int i=0; i<100; i++) {
                for (int j=0; j<100; j++) {
                    arr[i][j] = sc.nextInt();
                    row += arr[i][j];
                }
                maxValue = Math.max(maxValue, row);
                row = 0;
            }

            for (int i=0; i<100; i++) {
                for (int j=0; j<100; j++) {
                    column += arr[j][i];
                }
                maxValue = Math.max(maxValue, column);
                column = 0;
            }

            for (int i = 0; i < 100; i++) {
                RightDiagonal += arr[i][i];
                Leftdiagonal += arr[i][99 - i];
            }

            maxValue = Math.max(maxValue, Math.max(RightDiagonal, Leftdiagonal));

            System.out.println("#"+test_case+" "+maxValue);
        }
    }
}