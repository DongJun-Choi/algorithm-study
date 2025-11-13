package D3;

import java.util.Arrays;
import java.util.Scanner;

public class SW_1208_Flatten {
    public static void main(String[] args) {
        // 입력
        // 첫번째 줄에는 덤프 횟수 입력
        // 두번째 줄에는 100개의 각 상자의 높이들이 입력
        // 출력
        // 테스트 케이스의 최고점과 최저점의 높이 차를 출력
        // 로직
        // 최고로 높은 곳의 높이를 줄이고 최고로 낮은 높이를 올리는 행위를 1번의 행위
        // 카운팅으로 하기?
        Scanner sc = new Scanner(System.in);
		int T = 10;
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int count = sc.nextInt();
            int[] boxs = new int[100+1];
            for (int i=0; i<100; i++) {
                int high = sc.nextInt();
                boxs[high]++;
            }

            int max = 100;
            while (boxs[max] == 0) max--;

            int min = 1;
            while (boxs[min] == 0) min++;

            while (count-- > 0) {
                if (max - min <= 1) break;

                boxs[max]--;
                boxs[max - 1]++;
                if (boxs[max] == 0) max--;

                boxs[min]--;
                boxs[min + 1]++;
                if (boxs[min] == 0) min++;

            }


            System.out.println("#"+test_case+" "+(max - min));
        }
    }

    static void Sort() {
        // int count = sc.nextInt();
        // int[] boxs = new int[100];
        // for (int i=0; i<100; i++) {
            // boxs[i] = sc.nextInt();
        // }

        // Arrays.sort(boxs);

        // while (count-- > 0) {
        //     Arrays.sort(boxs);
        //     boxs[99]--;
        //     boxs[0]++;

        //     if (boxs[99] - boxs[0] <= 1) break;
        // }

        // Arrays.sort(boxs);
        // int result = boxs[99]-boxs[0];

        // return;
    }
}
