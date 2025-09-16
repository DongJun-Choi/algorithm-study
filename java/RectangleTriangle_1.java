import java.util.Scanner;

public class RectangleTriangle_1 {
    public static void main(String[] args) {
        // 1085
        // (x, y) (w, h) 입력받음
        // x의 값와 y의 값이 w와 h 범위에 포함이 되냐 안되냐에 따라 달라짐
        // x < w이고 y < h일 경우에는 중심점 기준으로 가까운 쪽으로
        // x > w, y > h일경우에는 x,y와 w,h 거리
        // x<w,y>h or x>w,y<h일 경우에는 w-x or h-y 값이 최솟값
        // 그냥 직사각형 안에 있다는 가정이었네
        // Math.min(x, y)를 사용하면 자동으로 작은 값 가져온다.

        // Scanner sc = new Scanner(System.in);
        // int x = sc.nextInt();
        // int y = sc.nextInt();
        // int w = sc.nextInt();
        // int h = sc.nextInt();
        
        // int min = Math.min(Math.min(x, w-x), Math.min(y, h-y));
        // System.out.println(min);
        
        // int sortx = 0;
        // int sorty = 0;
        // if (x < w-x) {
        //     sortx = x;
        // } else {
        //     sortx = w-x;
        // }
        // if (y < h-y) {
        //     sorty = y;
        // } else {
        //     sorty = h-y;
        // }
        // if (sortx < sorty) {
        //     System.out.println(sortx);
        // } else {
        //     System.out.println(sorty);
        // }


        // 3009
        // (a, b) (c, d) (e, f)를 받을 때 직사각형 만들기 위한 (x, y)찾기
        // a, c, e중에 같은게 있는지 찾기
        // b, d, f중에 같은게 있는지 찾기
        // 짝이 안맞는 값들을 x, y로 설정
        // xor를 사용하면 if 사용안해도 가능

        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();
        // int d = sc.nextInt();
        // int e = sc.nextInt();
        // int f = sc.nextInt();

        // int x;
        // int y;
        // if (a == c) {
        //     x = e;
        // } else if (a == e) {
        //     x = c;
        // } else {
        //     x = a;
        // }
        // if (b == d) {
        //     y = f;
        // } else if (b == f) {
        //     y = d;
        // } else {
        //     y = b;
        // }

        // int x = a ^ c ^ e;
        // int y = b ^ d ^ f;

        // System.out.println(x+" "+y);


        // 15894
        // 제일 아래부분의 정사각형 개수 n을 주면 둘레 길이 구하기
        // n(아래변의 길이)+2n(옆면의 길이)+n(윗면의 길이)
        // Scanner sc = new Scanner(System.in);
        // long n = sc.nextLong();
        // System.out.println(4*n);


        // 9063
        // 점의 개수 N, 각 점의 좌표값 제공
        // 1개만 들어오면 0 출력
        // 들어온 좌표에 따라서 x와 y 가장 작은 값과 큰값들 저장해서
        // 그걸로 
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int x=10000;
        // int y=10000;
        // int w=0;
        // int h=0;

        // for (int i=0;i<n;i++) {
        //     int a = sc.nextInt();
        //     int b = sc.nextInt();
        //     if (x > a) {
        //         x = a;
        //     }
        //     if (y > b) {
        //         y = b;
        //     }
        //     if (w < a) {
        //         w = a;
        //     }
        //     if (h < b) {
        //         h = b;
        //     }
        // }
        // int result = (w-x)*(h-y);
        // System.out.println(result);


        // 10101
        // Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();

        // if (a+b+c == 180) {
        //     if (a==60 && b==60 && c==60) System.out.println("Equilateral");
        //     else if (a==b || b==c || a==c) System.out.println("Isosceles");
        //     else System.out.println("Scalene"); 
        // } else {
        //     System.out.println("Error");
        // }
    }
}
