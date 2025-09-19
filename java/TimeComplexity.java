import java.io.*; 
import java.util.StringTokenizer;

public class TimeComplexity {
    public static void main(String[] args) throws IOException {
        // 24262
        // A[], n이 들어왔을 때, A[]의 배열에서 A[n/2]값을 반환하는 알고리즘
        // n/2의 값이 정수로 안될때는 올림시킴
        // 실행횟수는 1회 고정
        // 시간 복잡도 차수는 O(1)은 차수가 0
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // System.out.println(1);
        // System.out.println(0);


        // 53
        // A[], n 들어오면
        // n번 실행하기 때문에 O(n)실행
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // System.out.println(n);
        // System.out.println(1);


        // 24264
        // A[], n 들어오면
        // n*n번 실행하기 때문에 O(n*n)으로 차수는 2
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // System.out.println((long) n*n);
        // System.out.println(2);


        // 24265
        // A[], n 들어오면
        // n*(n-i)번 실행하기 때문에 O(n*n)으로 차수는 2
        // 실제 횟수는 n(n-1) / 2
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // long total = (long)n * (n-1) / 2;

        // System.out.println(total);
        // System.out.println(2);


        // 24266
        // A[], n 들어오면
        // n*n*n번 실행하므로 O(n^3)으로 차수는 3
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // long total = (long) n*n*n;

        // System.out.println(total);
        // System.out.println(3);


        // 24267
        // A[], n 들어오면
        // (n-2)(n-i-1)(n-j)번 실행 O(n^3)으로 차수는 3
        // 반복횟수((n-1) - (i+1) +1)
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // long total = (long)n*(n-1)*(n-2)/6;

        // System.out.println(total);
        // System.out.println(3);


        // 24313
        // g(n) = f(n) <= c*g(n)인 c와 n0 존재
        // a1, a0을 줄때, c의 값과 n0을 보고 O(n)정의 만족하는지 판단 후 1, 0출력
        // 판단 방법은? f(n) = a1*n + a0, g(n)=n, c=c, n0=n0. n >= n0에 대해서
        // a1*n0 + a0 <= c*n0
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // long a1 = Long.parseLong(st.nextToken());
        // long a0 = Long.parseLong(st.nextToken());
        // long c = Long.parseLong(br.readLine());
        // long n0 = Long.parseLong(br.readLine());
        
        // if (a1 <= c && a1*n0 + a0 <= c*n0) System.out.println(1);
        // else System.out.println(0);

    }
}
