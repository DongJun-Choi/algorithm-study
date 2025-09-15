import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        // 15964
        // A, B가 들어오면 A@B로 계산 = (A+B)*(A-B)
        
        // Scanner sc = new Scanner(System.in);
        // int A = sc.nextInt();
        // int B = sc.nextInt();

        // int result = customOperator(A, B);
        // System.out.println(result);
    }
    public static long customOperator(int a, int b) {
        return (long)(a + b) * (a - b);
    }
}
