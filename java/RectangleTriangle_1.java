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

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int x;
        int y;
        if (a == c) {
            x = e;
        } else if (a == e) {
            x = c;
        } else {
            x = a;
        }
        if (b == d) {
            y = f;
        } else if (b == f) {
            y = d;
        } else {
            y = b;
        }
        System.out.println(x+" "+y);
    }
}
