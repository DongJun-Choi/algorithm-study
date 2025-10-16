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

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int k = Integer.parseInt(br.readLine());
        // List<Integer> arr = new ArrayList();
        // int count = 0;

        // for (int i=0; i<k; i++) {
        //     int n = Integer.parseInt(br.readLine());
        //     if (n == 0) {
        //         arr.remove(arr.size() - 1);
        //     } else {
        //         arr.add(n);
        //     }
        // }

        // for (int i : arr) {
        //     count = count + i;
        // }
        // System.out.println(count);


        // 9012
        // 첫째줄에는 테스트 데이터 수 T 입력
        // '(', ')'이 섞여있는 괄호 문자열이 한줄에 한줄씩 입력
        // VPS면 YES, 아니면 NO 출력
        // ()의 짝이 맞아야지 VPS
        // 스택을 만들고 거기에 넣은 후에 꺼내기
        // 꺼낼때, )의 수는 카운팅하고, (가 나오면 카운팅 -1하기.
        // 만약 카운팅의 값이 0이 아니면 NO, 0이면 YES

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        // int t = Integer.parseInt(br.readLine());
        
        // for (int i = 0; i < t; i++) {
        //     String input = br.readLine();
        //     Stack<Character> stack = new Stack<>();
        //     boolean isVPS = true;

        //     for (int j = 0; j < input.length(); j++) {
        //         char c = input.charAt(j);
        //         if (c == '(') {
        //             stack.push(c);
        //         } else if (c == ')') {
        //             if (stack.isEmpty()) {
        //                 isVPS = false;
        //                 break;
        //             }
        //             stack.pop();
        //         }
        //     }
        //     if (!stack.isEmpty()) isVPS = false;

        //     sb.append(isVPS ? "YES" : "NO").append('\n');
        // }
        // System.out.println(sb);


        //4949
        // 각 줄마다 문자열이 들어오고 문자열의 마지막은 (.)으로 끝난다.
        // 입력의 종료 조건은 (.)하나만 들어오는 것.
        // 각 줄마다 문자열이 균형을 이루고 있으면 "yes"아니면 "no" 출력
        // '(', ')'과 짝을 이뤄야하고, '[', ']'과 짝을 이뤄야한다.
        // 각각 다른 스택을 만들고, 진행하기? "([)]"처럼 위배됐을경우 판단하기 힘듬
        // 같은 스택으로 하고 그 안에서 (냐 [에 따라 판단하기.
        // 스택의 맨 위에 요소를 꺼내지 않고 확인하는 법 peek()함수

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // while (true) {
        //     String a = br.readLine();
        //     if (a.equals(".")) break;
        //     Stack<Character> stack = new Stack<>();
        //     boolean isBalanced = true;
        //     for (int j = 0; j < a.length(); j++) {
        //         char c = a.charAt(j);
        //         if (c == '(' || c == '[') {
        //             stack.push(c);
        //         } else if (c == ')') {
        //             if (stack.isEmpty() || stack.peek() != '(') {
        //                 isBalanced = false;
        //                 break;
        //             }
        //             stack.pop();
        //         } else if (c == ']') {
        //             if (stack.isEmpty() || stack.peek() != '[') {
        //                 isBalanced = false;
        //                 break;
        //             }
        //             stack.pop();
        //         }
        //     }
        //     if (!stack.isEmpty()) isBalanced = false;
        //     sb.append(isBalanced ? "yes" : "no").append('\n');
        // }
        // System.out.println(sb);


        // 12789
        // 첫째줄에는 승환이 앞에 서있는 학생의 수 N 입력, 1 ≤ N ≤ 1,000,자연수
        // 다음 줄에는 승환이 앞에 서 있는 학생들의 번호표를 앞에서부터 뒤 순서로 입력
        // 승환이가 무사히 간식을 받을 수 있으면 "Nice", 아니면 "Sad" 출력
        // 옆에 공간은 스택, 스택에 가장 최근에 들어간 수보다 큰수가 들어오지 못하게하기.
        // 그러면서 각 숫자는 없어지는지 확인하기.

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int num = 1;
        // Stack<Integer> stack = new Stack<>();

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // for (int i=0; i<n; i++) {
        //     int a = Integer.parseInt(st.nextToken());
        //     if (a == num) {
        //         num++;
        //     } else {
        //         while (!stack.isEmpty() && stack.peek() == num) {
        //             stack.pop();
        //             num++;
        //         }
        //         stack.push(a);
        //     }
        // }

        // while (!stack.isEmpty() && stack.peek() == num) {
        //     stack.pop();
        //     num++;
        // }

        // if (stack.isEmpty()) System.out.println("Nice");
        // else System.out.println("Sad");


        // 18258
        // 첫째 줄에 주어지는 명령의 수 N 입력, 1 ≤ N ≤ 2,000,000
        // 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어짐.
        // 출력해야하는 명령이 주어질때마다 한줄에 하나씩 출력.
        // 큐를 구현해야함 Queue<Integer> queue = new LinkedList<>(); 선언
        // offer(값) 큐의 맨 뒤에 요소 추가, 비어있을 때 false반환
        // add(값) 큐의 맨 뒤에 요소 추가, 비어있을 때예외발생 IllegalStateException
        // poll() 큐의 맨 앞 요소를 꺼내서 제거, 비어있을 때 null 반환
        // remove() 큐의 맨 앞 요소를 꺼내서 제거, 비어있을 때 예외발생
        // peek() 큐의 맨 앞 요소를 조회만, 비어있을 때 null 반환
        // element() 큐의 맨 앞 요소를 조회만, 비어있을 때 예외발생
        // isEmpty() 큐가 비어있는지 확인
        // size() 큐의 요소 개수 반환
        // clear() 큐의 모든 요소 제거

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size": 
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (!queue.isEmpty()) sb.append(0).append("\n"); 
                    else sb.append(1).append("\n");
                    break;
                case "front": 
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back": 
                    if (queue.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(((LinkedList<Integer>) queue).peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }
}
