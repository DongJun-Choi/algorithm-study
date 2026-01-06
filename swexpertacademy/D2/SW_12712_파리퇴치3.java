package D2;

import java.util.*;
import java.io.*;

public class SW_12712_파리퇴치3 {
    public static void main(String[] args) throws IOException {
        // 입력
        // 가장 첫줄에는 테스트 케이스 T 입력
        // 각 테스트 케이스의 첫번째 줄에는 N, M 입력 (5<=N<=15), (2<=M<=N)
        // 다음 N줄에는 N*N 행렬 입력
        // 출력
        // 각 테스트 번호(#1) 후 공백 이후 한번에 잡을 수 있는 최대 파리수 출력
        // 로직
        // 그냥 다 계산하기

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][N];

            int[] dxPlus = {0, 0, -1, 1};
            int[] dyPlus = {-1, 1, 0, 0};
            int[] dxDiag = {-1, 1, -1, 1};
            int[] dyDiag = {-1, -1, 1, 1};

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    
                    // +모양
                    int sumPlus = arr[i][j];
                    // x모양
                    int sumDiag = arr[i][j];

                    for (int d = 1; d < M; d++) {
                        // + 모양
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = i + dyPlus[dir] * d;
                            int nx = j + dxPlus[dir] * d;

                            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                                sumPlus += arr[ny][nx];
                            }
                        }

                        // X 모양
                        for (int dir = 0; dir < 4; dir++) {
                            int ny = i + dyDiag[dir] * d;
                            int nx = j + dxDiag[dir] * d;

                            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                                sumDiag += arr[ny][nx];
                            }
                        }

                        max = Math.max(max, Math.max(sumPlus, sumDiag));
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);

        }
    }
}
