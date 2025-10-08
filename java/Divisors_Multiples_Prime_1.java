import java.util.*;
import java.io.*;

public class Divisors_Multiples_Prime_1 {
    public static void main(String[] args) throws IOException {
        // 1934
        // 첫째줄에 테스트 케이스 수 T 입력
        // 둘째줄부터 T개의 줄에 A와 B 입력
        // A와 B의 최소 공배수를 구한 후 출력
        // 최소 공배수 구하는 법
        // b를 1~a까지 곱해서 그 안에 %a가 0이면 최소공배수라고 구했다가 오래 걸림
        // 최소공배수는 최대공약수를 구하고 a*b/최대공약수를 하면 나옴
        // 최대공약수 구하는 법
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // int t = Integer.parseInt(br.readLine());

        // for (int i=0; i<t; i++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     int a = Integer.parseInt(st.nextToken());
        //     int b = Integer.parseInt(st.nextToken());


        //     int x = a;
        //     int y = b;
        //     while (y != 0) {
        //         int tmp = x%y;
        //         x = y;
        //         y = tmp;
        //     }

        //     sb.append(a*b/x).append("\n");
        // }
        
        // System.out.println(sb);


        // 13241
        // 한 줄에 두 정수 A, B가 공백으로 분리되어 주어짐
        // 50%의 입력 중 A와 B는 1000보다 작고, 50%의 입력은 1000보다 크고 10,000,000보다 작다
        // 최소 공배수를 출력
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // long a = Long.parseLong(st.nextToken());
        // long b = Long.parseLong(st.nextToken());

        // long x = a;
        // long y = b;
        // while (y != 0) {
        //     long temp = x%y;
        //     x = y;
        //     y = temp;
        // }

        // System.out.println(a/ x *b);


        // 1735
        // 첫째줄과 둘째줄에 분수의 분자와 분모를 뜻하는 2개의 자연수가 순서대로 입력
        // 첫째줄에 구하고자 하는 기약 분수의 분자와 분모를 뜻하는 2개의 자연수 순서대로 출력
        // 즉 2개의 분수를 입력받고 2개의 분수의 합 출력
        // 하지만 약분이 되서는 안됨.
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int a1 = Integer.parseInt(st.nextToken());
        // int b1 = Integer.parseInt(st.nextToken());
        // st = new StringTokenizer(br.readLine());
        // int a2 = Integer.parseInt(st.nextToken());
        // int b2 = Integer.parseInt(st.nextToken());
        
        // int a = a1*b2+a2*b1;
        // int b = b1*b2;

        // int x = a;
        // int y = b;
        // while (y != 0) {
        //     int temp = x%y;
        //     x = y;
        //     y = temp;
        // }

        // a = a/x;
        // b = b/x;

        // System.out.println(a+" "+b);


        // 2485
        // 첫째줄에는 이미 심어져 있는 가로수의 수를 나타내는 하나의 정수 N 입력
        // 둘째줄부터는 N개의 줄에 심어져 있는 가로수의 위치가 양의 정수로 입력, 기준점으로 부터 가까운 순서대로
        // 모든 가로수가 같은 간격이 되도록 새로 심어야하는 가로수의 최소수 출력
        // 이미 존재하는 가로수의 사이에 새로 심어서 모두가 같은 간격이 되게 어떻게?
        // 1, 3, 7, 13이면 사이의 거리가 2, 4, 6이니까 5, 9, 11하면 간격이 같아짐
        // 사이의 거리가 가장 최소인것을 구하고, 그걸로 안될 경우에는 숫자를 줄여가며 가능한지 따지기
        // 너무 노가다, 두 가로수 사이 거리들의 최대 공약수를 구하고 그 간격으로 하면 수학적으로 가능

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int[] arr = new int[n];

        // for (int i=0; i<n; i++) {
        //     arr[i] = Integer.parseInt(br.readLine());
        // }

        // int[] diff = new int[n-1];
        // for (int i=0; i<n-1; i++) {
        //     diff[i] = arr[i+1] - arr[i];
        // }

        // int gcd = diff[0];
        // for (int i = 1; i < diff.length; i++) {
        //     gcd = gcd(gcd, diff[i]);
        // }

        // int total = (arr[n - 1] - arr[0]) / gcd + 1;
        // System.out.println(total - n); 


        // 4134
        // 첫째줄에 테스트 케이수 수 t 입력
        // 둘째줄부터 t개의 줄에는 정수 N 입력
        // 각 테스트 케이스의 n보다 크거나 같은 소수 중 가장 작은 소수 한줄씩 출력
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int t = Integer.parseInt(br.readLine());
        // StringBuilder sb = new StringBuilder();

        // for (int i = 0; i < t; i++) {
        //     long n = Long.parseLong(br.readLine());
        //     while (!isPrime(n)) {
        //         n++;
        //     }
        //     sb.append(n).append("\n");
        // }

        // System.out.println(sb);


        // 1929
        // 첫째줄에 자연수 m, n 빈칸 두고 입력
        // 한줄에 하나씩 증가하는 순서대로 소수 출력

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();
        // int m = Integer.parseInt(st.nextToken());
        // int n = Integer.parseInt(st.nextToken());

        // for (int i=m; i<=n; i++) {
        //     if (isPrime(i)) {
        //         sb.append(i).append("\n");
        //     }
        // }
        // System.out.println(sb);


        // 4948
        // 여러개의 테스트 케이스가 존재하는데 한줄에 한 정수가 입력
        // 마지막 입력에는 0이 입력
        // 각 테스트 케이스를 보고 n보다 크고 2n보다 작거나 같은 소수의 개수 출력
        // 1929의 다른 사람 코드를 보니 에라토스테네스의 체를 사용하니 속도가 빨라진것을 확인 사용해봄

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[123456*2+1];
        for (int i=2; i<=123456*2; i++) arr[i] = i;
        for (int i=2; i<=123456*2; i++) {
            if (arr[i] == 0) continue;
            for (int j=i*2; j<=123456*2; j+=i) arr[j] = 0;
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int count = 0;
            
            for (int i=n+1; i<=n*2; i++) {
                if (arr[i] != 0) count++;
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    // 소수인지 확인하는 함수
    // 최적화를 위해, 제곱근으로 확인, 짝수 제외
    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
