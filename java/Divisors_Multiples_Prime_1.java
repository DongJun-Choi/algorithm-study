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

    }
}
