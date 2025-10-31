package D3;

import java.util.Scanner;

public class SW_1244_최대상금 {
    public static void main(String[] args) {
        // 입력
        // 첫 줄에 전체 테스트 케이스의 수 입력(최대 10까지)
        // 각 테스트 케이스에는 숫자판의 정보(최대 6자리), 교환 횟수(최대 10번) 입력
        // 출력
        // 각 테스트 케이스마다 첫 줄에 #C 출력, C는 테스트케이스 번호
        // 같은 줄에 빈카을 하나 두고 교환 후 받을 수 있는 가장 큰 금액 출력
        // 로직
        // 앞쪽의 작은 숫자랑 뒤쪽의 큰 숫자를 변경해야 가장 큰 이득을 본다.
        // 무조건 바꿔야하기 때문에 만약 앞보다 큰 숫자들이 없이 정렬되어있을 경우에는 가장 뒤에 있는 숫자 2개 변경해야함
        // 내가 했던 거(그리디알고리즘)로는 해결 불가능. 백트래킹 알고리즘 사용해야함.

        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        
        for (int test_case=1; test_case<=c; test_case++) {
            int num = sc.nextInt();
            int change = sc.nextInt();

            String str = String.valueOf(num);
            int[] arr = new int[str.length()];

            for (int i=0; i<str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }

            

            for (int i : arr) {
                System.out.print(i + " ");
            }
        }

    }
    
}
