import java.util.Scanner;

public class StringProblems {
    public static void main(String[] args) {
        // 11654
        // nextLine()은 문자열로 받음
        // 아스키코드로 변경하는 법 char문자 앞에 (int)
        // Scanner sc = new Scanner(System.in);
        // char alpabat = sc.next().charAt(0);
        
        // System.out.println((int) alpabat);


        // 2743
        // Scanner sc = new Scanner(System.in);
        // String word = sc.nextLine();

        // System.out.println(word.length());


        // 2744
        // isUpperCase()를 사용하면 대문자 확인, toUpperCase()을 사용하면 대문자로 변경
        // Scanner sc = new Scanner(System.in);
        // String word = sc.nextLine();
        // String change = "";

        // for (int i = 0; i < word.length(); i++) {
        //     char c = word.charAt(i);

        //     if (Character.isUpperCase(c)) {
        //         change += Character.toLowerCase(c);
        //     } else {
        //         change += Character.toUpperCase(c);
        //     }
        // }

        // System.out.println(change);


        // 2754
        // Scanner sc = new Scanner(System.in);
        // String score = sc.nextLine();
        // double avg = 0.0;

        // if (score.charAt(0) == 'A') {
        //     avg = 4.0;
        // } else if (score.charAt(0) == 'B') {
        //     avg = 3.0;
        // } else if (score.charAt(0) == 'C') {
        //     avg = 2.0;
        // } else if (score.charAt(0) == 'D') {
        //     avg = 1.0;
        // } else {
        //     avg = 0.0;
        // }

        // if (score.length() == 2) {
        //     if (score.charAt(1) == '+') {
        //         avg = avg + 0.3;
        //     } else if (score.charAt(1) == '-') {
        //         avg = avg - 0.3;
        //     }
        // }
        // System.out.println(avg);
    }
}
