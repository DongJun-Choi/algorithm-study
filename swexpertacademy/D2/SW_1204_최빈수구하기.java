package D2;

import java.util.*;

public class SW_1204_최빈수구하기 {
    public static void main(String[] args) {
        // 입력
        // 첫 번째 줄에 테스트 케이스 T 입력
        // 각 테스트 케이스의 첫 줄에는 테스트 케이스 번호가 주어지고 입력
        // 그 다음 줄부터는 점수 입력, (0<=점수의 크기<=100), (점수의 갯수=학생 수 1000)
        // 출력
        // 부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력
        // 로직
        // 최빈수를 출력하는 프로그램 잡성
        // 최빈수가 여러개일때는 가장 큰 점수 출력

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t; i++) {
            int[] arr = new int[101];
            for (int j=1; j<=100; j++) arr[j] = 0;
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int j=0; j<1000; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;
            }

            int max = 0;
            int index = 0;
            for (int j=0; j<=100; j++) {
                if (arr[j] >= max) {
                    max = arr[j];
                    index = j;
                }
            }

            sb.append("#").append(i+1).append(" ").append(index).append("\n");
        }

        System.out.println(sb);
    }
}