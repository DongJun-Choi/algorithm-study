package D2;

import java.util.Scanner;

public class SW_1959_두개의숫자열 {
    // 입력
    // 가장 첫줄에는 테스트 케이스 개수 T 입력
    // 각 테스트 케이스의 첫번째 줄에 N과 M 입력(3 <= N, M <= 20)
    // 두 번째 줄에는 A배열
    // 세 번째 줄에는 B배열
    // 출력
    // 출력의 각 줄은 '#t' 공백 한칸 두고 정답 출력
    // 로직
    // N은 A배열의 크기
    // M은 B배열의 크기
    // A와 B 배열의 마주 보는 것끼리 곱한 뒤 모두 더한 값이 최댓값을 구하라
    // 중간에 -값이 존재
    // 더 작은 배열의 시작 위치를 바꿔서 마주보는 것을 변경 가능
    // 단, 가장 긴쪽의 양끝을 벗어날 수 없음.
    // 그냥 짧은 쪽을 맨 긴쪽에서 한칸씩 움직이게 해서 가장 큰 값 구하기!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[20];
            int[] B = new int[20];

            for (int i=0; i<N; i++) {
                A[i] = sc.nextInt();
            }
            for (int i=0; i<M; i++) {
                B[i] = sc.nextInt();
            }

            int max_sum = 0;
            int count = 0;

            boolean A_shorter = (N <= M);
            int limit = Math.abs(M - N);
            
            while (count <= limit) {
                int sum = 0;

                if (A_shorter) {
                    for (int i = 0; i < N; i++) {
                        sum += A[i] * B[i + count];
                    }
                } else {
                    for (int i = 0; i < M; i++) {
                        sum += B[i] * A[i + count];
                    }
                }

                max_sum = Math.max(max_sum, sum);
                count++;
            }

            System.out.println("#"+test_case+" "+max_sum);
        }   
    }
}
