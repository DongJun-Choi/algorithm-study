package D2;

import java.util.*;
import java.io.*;

public class SW_1859_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        // 입력
        // 첫 번째 줄에 테스트 케이스 수 T입력
        // 각 테스트 케이스의 첫 줄에는 자연수 N 초깃값 입력,(2<=N<=1,000,000)
        // 둘째 줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 입력, 매매가(10,000이하)
        // 출력
        // 각 테스트 케이스마다 #x(x는 테스트케이스 번호, 1부터 시작)을 출력하고 최대 이익 출력
        // 로직
        // 가장 팔았을 때 이득 보는 날짜에 판매
        // 하루에 살 수 있는 양은 1개로 제한
        // 첫날부터 가격이 떨어지기만 하면 안사는게 최대 이익

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int profit = 0;
            int max = Arrays.stream(arr).max().getAsInt();

            for (int j = 0; j < n; j++) {
                if (arr[j] < max) {
                    profit += max - arr[j];
                } else {
                    if (j + 1 < n) {
                        max = Arrays.stream(Arrays.copyOfRange(arr, j + 1, n))
                                    .max().orElse(max);
                    }
                }
            }

            sb.append("#").append(i).append(" ").append(profit).append("\n");
        }

        System.out.println(sb);
    }

}