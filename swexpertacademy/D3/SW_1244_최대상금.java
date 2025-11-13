package D3;

import java.util.HashSet;
import java.util.Scanner;

public class SW_1244_최대상금 {
    static int maxValue;
    static int changeCount;
    static char[] numbers;
    static HashSet<String> visited;

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
        // 최선의 수를 찾아야함

        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        
        for (int test_case=1; test_case<=c; test_case++) {
            String numStr = sc.next();
            changeCount = sc.nextInt();
            numbers = numStr.toCharArray();
            maxValue = 0;

            visited = new HashSet<>();

            dfs(0);

            System.out.println("#" + test_case + " " + maxValue);
        }

    }

    static void dfs(int depth) {
        if (depth == changeCount) {
            int value = Integer.parseInt(new String(numbers));
            maxValue = Math.max(maxValue, value);
            return;
        }

        String state = new String(numbers) + depth;
        if (visited.contains(state)) return;
        visited.add(state);

        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(i, j);
                dfs(depth + 1);
                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
}
