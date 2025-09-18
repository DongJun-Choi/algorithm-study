import java.io.*; 
import java.util.StringTokenizer;

public class TimeComplexity {
    public static void main(String[] args) throws IOException {
        // 24262
        // A[], n이 들어왔을 때, A[]의 배열에서 A[n/2]값을 반환하는 알고리즘
        // n/2의 값이 정수로 안될때는 올림시킴
        // 실행횟수는 1회 고정
        // 시간 복잡도 차수는 O(1)은 차수가 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(1);
        System.out.println(0);

    }
    
}
