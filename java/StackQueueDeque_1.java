import java.io.*;
import java.util.*;

public class StackQueueDeque_1 {
    public static void main(String[] args) throws IOException {
        // 28278
        // 첫줄 에 명령의 수 N 입력, 1 ≤ N ≤ 1,000,000
        // 둘째줄부터 n개의 줄에 명령이 하나씩 입력
        // 출력을 요구하는명령은 하나 이상 주어짐.
        // 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
        // 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
        // 3: 스택에 들어있는 정수의 개수를 출력한다.
        // 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
        // 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        // isEmpty() : 컬렉션(list, stack, queue, set 등)이 비어있는지 확인하는 메서드

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        // int n = Integer.parseInt(br.readLine());
        // List<Integer> stack = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     int command = Integer.parseInt(st.nextToken());
        //     if (command == 1) {
        //         int x = Integer.parseInt(st.nextToken());
        //         stack.add(x);
        //     } 
        //     else if (command == 2) {
        //         if (stack.isEmpty()) sb.append(-1).append('\n');
        //         else sb.append(stack.remove(stack.size() - 1)).append('\n');
        //     } 
        //     else if (command == 3) {
        //         sb.append(stack.size()).append('\n');
        //     } 
        //     else if (command == 4) {
        //         if (stack.isEmpty()) sb.append(1).append('\n');
        //         else sb.append(0).append('\n');
        //     } 
        //     else if (command == 5) {
        //         if (stack.isEmpty()) sb.append(-1).append('\n');
        //         else sb.append(stack.get(stack.size() - 1)).append('\n');
        //     }
        // }
        // System.out.print(sb);


        // 10773
        // 첫번째 줄에 정수 k 입력, 1 ≤ K ≤ 100,000
        // 이후 k의 줄에 정수가 하나씩 입력, 0에서 1,000,000 사이의 값
        // 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우기, 0은 지울 수 있는 수가 존재한다는 가정에만 나옴
        // 아니면 해당 수 쓰기
        // 최종적으로 적어낸 수의 합 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList();
        int count = 0;

        for (int i=0; i<k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                arr.remove(arr.size() - 1);
            } else {
                arr.add(n);
            }
        }

        for (int i : arr) {
            count = count + i;
        }

        System.out.println(count);

    }
}
