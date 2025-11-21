package D3;

import java.util.Scanner;

public class SW_1240_단순2진암호코드 {
    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
//			입력
//			처음에는 전체 케이스의 수 입력
//			각 테스트 케이스의 첫줄에는 두 자연수가들어오는데 각각 배열의 세로 크기 N, 가로크기 M (1≤N≤50, 56≤M≤100)
//			그 다음의 N개의 줄에 N*M 크기의 직사각형 배열 입력
//			출력
//			각 테스트의 답을 순서대로 표준 출력
//			주어진 암호코드가 올바른 암호코드일 경우, 암호코드에 포함된 숫자의 합을 출력,
//			잘못된 암호코드일 경우 대신 0을 출력
//			로직
//			암호코드는 8개의 숫자,
//			암호 코드의 숫자 하나는 7개의 비트로 암호화된다. 그래서 암호코드의 가로 길이는 56
//			56초과의 암호코드는 주어지지 않음
//			올바른 암호 코드는 (홀수자리의 합*3)+(짝수자리의 합)이 10의 배수가 되어야 한다.
//			암호코드 이외의 부분은 전부 0으로
//			해결 방법
//			암호코드 줄을 찾고
//          가로의 뒤에서부터 1이 발견되면 그때부터 앞자리 56자리가 암호코드
//			그리고 조건에 맞게 숫자로 치환 후 올바른 암호코드인지 확인하기
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][M];
			String[] code = new String[8];
			int[] codeNum = new int[8];
			
			for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }

            int row = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) row = i;
                }
            }

            int end = -1;
            for (int j = M - 1; j >= 0; j--) {
                if (arr[row][j] == 1) {
                    end = j;
                    break;
                }
            }

            String bits = "";
            for (int j = end - 55; j <= end; j++) {
                bits += arr[row][j];
            }

            for (int i = 0; i < 8; i++) {
                code[i] = bits.substring(i * 7, (i + 1) * 7);
            }
			
            for (int i = 0; i < 8; i++) {
			    switch (code[i]) {
			        case "0001101":
			            codeNum[i] = 0;
			            break;
			        case "0011001":
			            codeNum[i] = 1;
			            break;
			        case "0010011":
			            codeNum[i] = 2;
			            break;
			        case "0111101":
			            codeNum[i] = 3;
			            break;
			        case "0100011":
			            codeNum[i] = 4;
			            break;
			        case "0110001":
			            codeNum[i] = 5;
			            break;
			        case "0101111":
			            codeNum[i] = 6;
			            break;
			        case "0111011":
			            codeNum[i] = 7;
			            break;
			        case "0110111":
			            codeNum[i] = 8;
			            break;
			        case "0001011":
			            codeNum[i] = 9;
			            break;
			    }
			}
			
            int result = 0;
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                if (i % 2 == 0) result += codeNum[i] * 3;
                else result += codeNum[i];
                sum += codeNum[i];
            }
            result += codeNum[7];
            sum += codeNum[7];

            if (result % 10 != 0) sum = 0;
			
			System.out.println("#"+test_case+" "+sum);
        }
    }
}