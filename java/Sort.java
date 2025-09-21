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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[5];

        for (int i=0; i<5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        int mean = sum / numbers.length;

        Arrays.sort(numbers);
        int n = numbers.length;
        int median;
        if (n % 2 == 1) {
            median = numbers[n/2];
        } else {
            median = (numbers[n / 2 -1] + numbers[n / 2]) / 2;
        }

        System.out.println(mean);
        System.out.println(median);
        
    }
}
