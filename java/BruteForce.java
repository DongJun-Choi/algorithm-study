import java.io.*;
import java.util.StringTokenizer;

public class BruteForce {
    public static void main(String[] args) throws IOException {
        // 2798
        // 첫줄에 카드 개수 N, 최고의 합 M
        // 둘째줄에 각 카드의 값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int result = 0;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                for (int k=j+1;k<n;k++) {
                    sum = arr[i]+arr[j]+arr[k];
                    if (sum <= m && result < sum) result = sum;
                }
            }
        }
        System.out.println(result);
    }
}
