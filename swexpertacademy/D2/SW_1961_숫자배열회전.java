package D2;

import java.util.*;
import java.io.*;

public class SW_1961_숫자배열회전 {
    public static void main(String[] args) throws IOException {
        // 입력
        // 가장 첫줄에는 테스트 케이스 T 입력
        // 각 테스트 케이스의 첫번째 줄에는 N 입력 (3<=N<=7)
        // 다음 N줄에는 N*N 행력
        // 출력
        // N줄에 거쳐서 90도, 180도, 270도 회전한 모양을 출력
        // 각 회전한 모양 사이에만 공백 존재
        // 로직
        // 돌리는 방법은? 
        // N번

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int[][] arr90 = new int[N][N];
            int[][] arr180 = new int[N][N];
            int[][] arr270 = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr90[i][j] = arr[N-1-j][i];
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr180[i][j] = arr[N-1-i][N-1-j];
                }
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr270[i][j] = arr[j][N-1-i];
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");
                for(int j=0; j<N; j++) {
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");
                for(int j=0; j<N; j++) {
                    sb.append(arr270[i][j]);
                }
                sb.append("\n");
            }

            System.out.println("#"+test_case);
            System.out.print(sb.toString());
        }


    }
}