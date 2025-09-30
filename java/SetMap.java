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
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int n = Integer.parseInt(br.readLine());
        // Set<Integer> set = new HashSet<>();

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // for (int i=0; i<n; i++) {
        //     int a = Integer.parseInt(st.nextToken());
        //     set.add(a);
        // }

        // int m = Integer.parseInt(br.readLine());
        // StringBuilder sb = new StringBuilder();

        // st = new StringTokenizer(br.readLine());
        // for (int i=0; i<m; i++) {
        //     int b = Integer.parseInt(st.nextToken());
        //     if (set.contains(b)) {
        //         sb.append(1).append(" ");
        //     } else {
        //         sb.append(0).append(" ");
        //     }
        // }

        // System.out.println(sb);


        // 14425
        // 문자열 개수 N과 또 다른 문자열 개수 M이 첫줄에 입력
        // 둘째줄부터 N번째줄까지는 하나의 배열 s로 저장
        // N+1번째 줄부터 M까지는 s에 있는 문자열인지 체크 후 있는 문자열이면 count++
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());
        // Set<String> set = new HashSet<>();
        // int count = 0;

        // for (int i=0; i<n; i++) {
        //     String a = br.readLine();
        //     set.add(a);
        // }

        // for (int i=0; i<m; i++) {
        //     String b = br.readLine();
        //     if(set.contains(b)) {
        //         count++;
        //     }
        // }

        // System.out.println(count);


        // 7785
        // 첫재쭐에 출입 기록 수 N 입력
        // 다음 n개의 줄에는 출입 기록(이름)이 순서대로 주어지고 공백 이후 "enter", "leave" 출근, 퇴근 입력
        // 현재 회사에 존재하는 사람을 사전 순의 역순으로 한줄에 한명씩 출력
        // 정렬을 해야하는데 HashSet은 정렬이 안됨. 순서가 없음 대신 삽입/삭제 빠름, null 저장 가능
        // TreeSet은 자동 정렬, 오름차순이 기본이고 Comparator로 변경 가능, 정렬된 집합 필요할때 사용
        // 문자열은 == 하면 주소값 비교함. equals()로 비교해야함
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
        // int n = Integer.parseInt(br.readLine());
        // Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        // for (int i=0; i<n; i++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     String name = st.nextToken();
        //     String check = st.nextToken();
        //     if (check.equals("enter")) {
        //         set.add(name);
        //     }
        //     if (check.equals("leave")) {
        //         set.remove(name);
        //     }
        // }

        // for (String a : set) {
        //     sb.append(a).append("\n");
        // }

        // System.out.println(sb);


        // 1620
        // 첫째줄에는 도감에 수록되어있는 포켓몬 수N과 맞춰야하는 문제 개수 M 입력
        // 둘째줄부터 N개의 줄에는 포켓몬 이름이 한줄에 하나씩 들어온다. 
        // 첫글자만 대문자 나머지 소문자, 일부는 마지막 문자만 대문자일수도 있음
        // 들어온 포켓몬 순서대로 번호 1~n으로 생각해야함
        // 그 이후에는 내가 맞춰야하는 문제로 입력, 입력되는건 이름 or 번호
        // 알파벳으로 들어올 경우에는 도감 번호로 출력
        // 번호로 들어올 경우에는 그에 맞는 이름으로 출력
        // 단순히 list.indexOf()를 할 경우 시간 복잡도 O(n)으로 시간 초과 발생
        // Map은 Set과 같이 중복 허락하지 않지만 key - value 쌍으로 저장을 함.
        // 빨리 찾기 위해 O(1) 시간 복잡도 사용해야함.
        // 그러기 위해서 String, Integer쌍과 Integer, String쌍 두개를 해서 각 값마다 맞게 빨리 가져와야함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            String name = br.readLine();
            map.put(name, i);
            list.add(name);
        }
        
        for (int i=0; i<m; i++) {
            String name = br.readLine();
            char check = name.charAt(0);

            if (Character.isLetter(check)) {
                int index = map.get(name);
                sb.append(index).append("\n");
            } else {
                int number = Integer.parseInt(name);
                String value = list.get(number-1);
                sb.append(value).append("\n");
            }
        }

        System.out.println(sb);

    }
}
