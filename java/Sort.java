import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort {
    public static void main(String[] args) throws IOException {
        // 2750
        // N개의 수 들어오면 오름차 순으로 정렬 후 출력
        // 배열과 리스트 사용 차이, 배열은 입력의 크기가 정해져 있을때
        // 리스트는 입력 개수가 가변적일 때
        // Arrays.sort()가 배열 오름차순, 내림차순은 없어서 직접해야함
        // 객체 배열은 내림차순 존재 Arrays.sort(arr, Comparator.reverseOrder());
        // *기본 배열과 객체 배열 차이 : int[] 기본, Integer[] 객체=(Integer는 힙에 객체 생성되고 참조로 접근)
        // list(리스트 선언명).sort()가 리스트 오름차순, 
        // StringBuilder를 사용하면 출력이 더 빨라짐
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];

        // for (int i=0;i<n;i++) {
        //     arr[i] = Integer.parseInt(br.readLine());
        // }

        // Arrays.sort(arr);

        // StringBuilder sb = new StringBuilder();
        // for (int num : arr) {
        //     sb.append(num).append("\n");
        // }
        // System.out.println(sb);


        // 2587
        // 1줄~5줄까지 한개씩 입력, 출력의 첫째줄에는 평균, 둘째줄에는 중앙값 출력
        // Arrays.stream(arr).sum(); 총합
        // Arrays.stream(arr).average().orElse(0); 평균, orElse(0)은 배열이 비었을때의 0반환
        // Arrays.stream(arr).max().orElse(Integer.MIN_VALUE); 최댓값
        // Arrays.stream(arr).min().orElse(Integer.MAX_VALUE); 최솟값
        // Arrays.stream(arr).count(); 개수
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int[] numbers = new int[5];

        // for (int i=0; i<5; i++) {
        //     numbers[i] = Integer.parseInt(br.readLine());
        // }

        // int sum = 0;
        // for (int num : numbers) {
        //     sum += num;
        // }
        // int mean = sum / numbers.length;

        // Arrays.sort(numbers);
        // int n = numbers.length;
        // int median;
        // if (n % 2 == 1) {
        //     median = numbers[n/2];
        // } else {
        //     median = (numbers[n / 2 -1] + numbers[n / 2]) / 2;
        // }

        // System.out.println(mean);
        // System.out.println(median);
        

        // 25305
        // 응시자 수 N, 점수가 가장 높은 k명은 상 받음
        // k명 중 가장 점수가 낮은 사람을 구해라.
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int k = Integer.parseInt(st.nextToken());
        // int[] scores = new int[n];

        // st = new StringTokenizer(br.readLine());
        // for (int i=0; i<n; i++) {
        //     scores[i] = Integer.parseInt(st.nextToken());
        // }

        // Arrays.sort(scores);
        // System.out.println(scores[n-k]);


        // 2751
        // 둘째줄부터 n줄까지 한개씩 입력 = 총 n개 입력 받음
        // 첫째 줄에는 n 입력
        // 이름 오름차 순으로 정렬하는데 출력도 한줄에 1개씩
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];

        // for (int i=0; i<n; i++) {
        //     int num = Integer.parseInt(br.readLine());
        //     arr[i] = num;
        // }

        // Arrays.sort(arr);

        // for (int i : arr) {
        //     sb.append(i).append("\n");
        // }
        // System.out.println(sb);


        // 10989
        // 첫줄에 수의 갯수 N 입력, 이후 한줄에 수 한개씩 n줄 입력
        // 오름차순으로 한줄에 하나씩 출력
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];

        // for (int i=0; i<n; i++) {
        //     int a = Integer.parseInt(br.readLine());
        //     arr[i] = a;
        // }
        // Arrays.sort(arr);

        // for (int i : arr) {
        //     sb.append(i).append("\n");
        // }

        // System.out.println(sb);


        // 1427
        // 첫째줄에 N(1,000,000,000 작거나 같은 자연수) 입력
        // 각 자리수를 내림차순으로 정렬한 수 출력
        // 1. 문자열로 받은 후, 문자별로 분리 -> int로 변환
        // 배열로 집어 넣은 후 정렬 하고 거꾸로 출력
        // int num = n.charAt(i) - '0';로 int 변환 가능
        // .trim() 띄어쓰기, 탭, 개행문자 등을 제거해서 받음
        // sb.toString을 하던, sb를 하던 sb안에 toString()을 오버라이딩 함
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // String n = br.readLine();
        // int[] arr = new int[n.length()];

        // for (int i=0; i < n.length(); i++ ) {
        //     int num = n.charAt(i) - '0';
        //     arr[i] = num;
        // }

        // Arrays.sort(arr);

        // for (int i=arr.length-1; i >= 0; i--) {
        //     sb.append(arr[i]);
        // }

        // System.out.println(sb);


        // 11650
        // 2차원 평면 위의 점의 개수 N이 첫째줄에 입력
        // 둘째 줄부터 N번째 줄까지 i번째 점의 위치 x, y들이 주어짐
        // x가 증가하는 순으로 정렬하는데, x가 같으면 y좌표 증가하는 순으로 정렬
        // n을 입력 받기, for문으로 배열에 [x, y]으로 값 저장
        // Arrays.sort를 돌리고 결과에 따라서 진행해볼 예정 
        // == 2차원 배열은 첫번째 원소만 보고 정렬, 하지만 2번째 원소는 안봄 따로 지정할 필요 있음 
        // Arrays.sort(array, comparator);에서 comparator는 정렬 기준을 정의하는 함수
        // Integer.compare(a, b)는 a b비교해서 a가 작으면 음수, 크면 양수, 같으면 0 반환

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // int n = Integer.parseInt(br.readLine());
        // int[][] arr = new int[n][2];

        // for (int i=0; i<n; i++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     int x = Integer.parseInt(st.nextToken());
        //     int y = Integer.parseInt(st.nextToken());
        //     arr[i][0] = x;
        //     arr[i][1] = y;
        // }

        // Arrays.sort(arr, (a,b) -> {
        //     if (a[0] == b[0]) {
        //         return Integer.compare(a[1], b[1]);
        //     }
        //     return Integer.compare(a[0], b[0]);
        // });

        // for (int i=0; i<n; i++) {
        //     sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        // }

        // System.out.println(sb);


        // 11651
        // 2차원 평면 위의 점의 개수 N이 첫째줄에 입력
        // 둘째 줄부터 N번째 줄까지 i번째 점의 위치 x, y들이 주어짐
        // y가 증가하는 순으로 정렬하는데, y가 같으면 x좌표 증가하는 순으로 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, (a,b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i=0; i<n; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
