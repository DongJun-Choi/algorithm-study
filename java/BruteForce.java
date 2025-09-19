import java.io.*;
import java.util.StringTokenizer;

public class BruteForce {
    public static void main(String[] args) throws IOException {
        // 2798
        // 첫줄에 카드 개수 N, 최고의 합 M
        // 둘째줄에 각 카드의 값
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int m = Integer.parseInt(st.nextToken());

        // st = new StringTokenizer(br.readLine());
        // int[] arr = new int[n];
        // for (int i=0;i<n;i++) {
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }

        // int sum = 0;
        // int result = 0;
        // for (int i=0;i<n;i++) {
        //     for (int j=i+1;j<n;j++) {
        //         for (int k=j+1;k<n;k++) {
        //             sum = arr[i]+arr[j]+arr[k];
        //             if (sum <= m && result < sum) result = sum;
        //         }
        //     }
        // }
        // System.out.println(result);


        // 2231
        // 자연수 N, 분해합은 245의 분해합은 256(=245+2+4+5)
        // 이러면 245은 256의 생성자가 된다.
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        // int answer = 0;

        // for (int i = 0; i < n; i++) {
        //     int sum = i;
        //     int temp = i;

        //     while (temp > 0) {
        //         sum += temp % 10;
        //         temp /= 10;
        //     }

        //     if (sum == n) {
        //         answer = i;
        //         break;
        //     }
        // }

        // System.out.println(answer);


        // 19532
        // 연립방정식 값을 찾아라
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int a = Integer.parseInt(st.nextToken());
        // int b = Integer.parseInt(st.nextToken());
        // int c = Integer.parseInt(st.nextToken());
        // int d = Integer.parseInt(st.nextToken());
        // int e = Integer.parseInt(st.nextToken());
        // int f = Integer.parseInt(st.nextToken());

        // for (int i=-999; i<=999; i++) {
        //     for (int j=-999; j<=999; j++) {
        //         if (a*i + b*j == c && d*i + e*j == f) {
        //             System.out.println(i + " " + j);
        //             return;
        //         }
        //     }
        // }

    }
}
