import java.util.*;
import java.io.*;

public class SetMap {
    public static void main(String[] args) throws IOException{
        // 10815
        // 첫째줄에는 상근이의 가지고 있는 숫자카드 갯수 N 입력
        // 둘째줄에는 숫자 카드의 정수들 입력
        // 셋째줄에는 상근이의 숫자 카드인지 확인해야할 카드 수 M 입력
        // 넷째줄에는 숫자 카드의 정수들 입력
        // 상근의 카드 숫자들을 기억하고, 
        // 비교해야하는 카드의 숫자를 보고 같으면 1, 아니면 0을 출력
        // set은 중복을 허용하지 않는 집합, 이면서 contains()
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            set.add(a);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (set.contains(b)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
