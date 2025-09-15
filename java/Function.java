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


        // 2475
        // Scanner sc = new Scanner(System.in);
        // int[] nums = new int[5];        
        
        // for (int i = 0; i < 5; i++) {
        //     nums[i] = sc.nextInt();
        // }

        // System.out.println(checkOperator(nums));
    }
    public static long customOperator(int a, int b) {
        return (long)(a + b) * (a - b);
    }
    public static int checkOperator(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n * n;
        }
        return sum % 10;
    }
}
