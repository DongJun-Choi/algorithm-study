import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			long N = Long.parseLong(br.readLine());
			
			long count = 0;
			while(N != 2) {				
//				정수 판단법
				if (Math.sqrt(N) % 1 != 0) {
//					N과 가장 가까운 완전제곱수 찾기
					long num = (long) Math.sqrt(N);
					num = (num+1)*(num+1);
					count += num-N;
					N = num;
				} else {
					N = (long) Math.sqrt(N);
					count++;
				}
			}
			
			
			sb.append('#').append(tc).append(' ').append(count).append("\n");
		}
		
		System.out.println(sb);
	}

}
