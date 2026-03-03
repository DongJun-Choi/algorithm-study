import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
//        첫번째 줄에는 LED 개수
		int n = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			int flag = Integer.parseInt(st.nextToken());
			if(flag == 1) {
				arr[i] = true;
			}
//			System.out.print(flag+" ");
		}
//		System.out.println();
		
//		켜져있으면 1, 꺼져 있으면 0
		
//		셋째줄에는 학생 수
//		남학생 1, 여학생 2
		int s_num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<s_num; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				for(int j=1; j<=n; j++) {
					if(j % num == 0) {
						arr[j] = !arr[j];
//						System.out.println("남, idx "+j);
					}
				}
			} else {
//				로직이 이상하네
//				index값 기준으로 양옆을 확인함
				arr[num] = !arr[num];
				for(int j=1; j<n/2; j++) {
					
					if(num-j < 1 || num+j > n) break;
					if(arr[num-j] == arr[num+j]) {
						arr[num-j] = !arr[num-j];
						arr[num+j] = !arr[num+j];
					} else {
						break;
					}
				}
			}			
			
		}
		
		int count = 1;
		while(count <= n) {
			int t = 0;
			if(arr[count]) {
				t = 1;
			}
			sb.append(t).append(' ');
            if(count % 20 == 0) {
				sb.append("\n");
			}
			count++;
		}
		
//		로직
//		학생은 자신의 성별과 받은 수에 따라서 LED 조작
//		남학생은 자기가 받은 수의 배수이면 led상태 변경(모든 배수들을)
//		여학생은 자기가 받은 수와 같은 번호가 붙은 led를 중심으로 좌우가 대칭이면서 가장 많은 led를 포함하는 구간을 찾아서
//		그 구간의 led 상태를 모두 변경
		
		
		System.out.println(sb);
	}

}
