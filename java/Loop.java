import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Loop {
    public static void main(String[] args) throws IOException {
        // 2741
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // for (int i=1; i<=a; i++) {
        //     System.out.println(i);
        // }


        // 10872
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // long total = 1;
        // for (int i=a; i>=1; i--) {
        //     total = total * i;
        // }
        // System.out.println(total);


        // 11021
        // Scanner sc = new Scanner(System.in);
        // int T = sc.nextInt();
        // for (int i=1; i<=T; i++) {
        //     int A = sc.nextInt();
        //     int B = sc.nextInt();
        //     System.out.println("Case #"+i+": "+(A+B));
        // }

        
        // 15552
        // 빠르게 입출력 하는 방법
        // BufferedReader 빠른 한줄 입력을 위해 사용하는 클래스
            // 빠른 한줄 입력을 위해 한줄씩 변환하는 것이 아닌 한 줄을 가져와서 한번에 읽고 저장
            // 이후에 버퍼에서 꺼내서 사용하니 입출력 횟수 줄어들어 훨씬 빨라짐
        // InputStreamReader System.in을 문자 스트림으로 연결해주는 어댑터 클래스
            // System.in은 바이트 스트림으로 1byte씩 읽으면서 byte단위로 다룸
            // 문자 단위 스트림으로 바꾸기(= UTF-16기반 자바 문자로 변환) 
        // IOException 입력 처리 중 발생할 수 있는 예외 타입
            // BufferedReader.readLine()이 IOException 던질 수 있어서 처리 필요
        // StringTokenizer 공백 기준으로 문자열을 빠르게 토큰 단위로 분리하는 유틸
        // StringBuilder 여러 출력 결과를 메모리에 보관을 사용하기 위해 사용

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        // int t = Integer.parseInt(br.readLine());
        // for (int i = 0; i < t; i++) {
        //     StringTokenizer st = new StringTokenizer(br.readLine());
        //     int a = Integer.parseInt(st.nextToken());
        //     int b = Integer.parseInt(st.nextToken());
        //     sb.append(a + b).append('\n');
        // }

        // System.out.print(sb);
    }
}
