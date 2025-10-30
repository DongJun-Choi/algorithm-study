package D3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_1206_View {
    public static void main(String[] args) {
        // 입력
        // 테스트케이스의 수 10
        // 각 테스트 케이스의 첫번째 줄에는 건물의 개수 N 입력(4<=N<=1000)
        // 다음 줄에는 N개의 건물의 높이 입력, " "을 기준으로 구별, (0<=높이<=255)
        // 출력
        // #부호와 함께 테스트케이스 번호 출력, 공백 이후 조망권 확보된 세대의 수 출력
        // 로직
        // 오른쪽 왼쪽 2칸이내로 같은 높이에 건물이 없다면 조망권 확보
        // 맨왼쪽 2칸, 맨오른쪽 2칸 건물은 항상 높이가 0
        // 각각 왼쪽, 오른쪽 2칸이내로 가장 큰 값을 꺼내서
        // 그 값들보다 내가 크면 조망권 확보
        // 낮으면 확보 불가

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        int high = 0;

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=2; i<n-2; i++) {
            int max = Math.max(
                Math.max(arr[i+1], arr[i+2]),
                Math.max(arr[i-1], arr[i-2]));
            if (arr[i] > max) {
                high = arr[i] - max + high;
            } 
        }

        System.out.println(high);
        
    }
}
