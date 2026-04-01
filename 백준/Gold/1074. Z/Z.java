import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
//		r, c가 몇번째 방문일까?
//		방문 순서는 4등분 후 좌상 우상 좌하 우하
//		이걸 계속 반복(ex) 16칸짜리면 4칸짜리로 잘라서 하기, 64칸이면 16칸 -> 4칸으로 잘라서 진행)
		
		int sum = 0;
		
		while(n > 0) {
			int half = 1 << (n-1);
			int area = half*half;
			
			if (r < half && c < half) {
                // 좌상
            } else if (r < half && c >= half) {
            	sum += area;
                c -= half;
            } else if (r >= half && c < half) {
            	sum += area * 2;
                r -= half;
            } else {
            	sum += area * 3;
                r -= half;
                c -= half;
            }

            n--;
		}
		
		System.out.println(sum);
	}
}
