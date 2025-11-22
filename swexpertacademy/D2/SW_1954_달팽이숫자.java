package D2;

import java.util.Scanner;

class SW_1954_달팽이숫자 {

    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
//			입력
//			첫줄에는 테스트 케이스의 개수 T입력
//			각 테스트 케이스에는 N이 입력(1<=N<=10)
//			출력
//			#T로 시작하고 다음줄 부터 빈칸을 사이에 두고 달팽이 숫자 출력
//			로직
//			N*N의크기의 달팽이를 출력하는데
//			1 2 3
//			8 9 4
//			7 6 5
//			이런식으로 되어야 함
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int count = 1;
			int top = 0; //맨 위에서의 줄
			int bottom = N - 1;  //맨 아래에서의 줄
			int left = 0; //맨 왼쪽의 줄
			int right = N - 1; // 맨 오른쪽의 줄
			while(count <= N*N) {
//				오른쪽으로
				for (int i=left; i<=right && count <= N*N; i++) {
					arr[top][i] = count++;
				}
				top++;
				
//				아래로
				for (int i=top; i<= bottom && count <= N*N; i++) {
					arr[i][right] = count++;
				}
				right--;
				
//				왼쪽으로
				for (int i=right; i>= left && count <= N*N; i--) {
					arr[bottom][i] = count++;
				}
				bottom--;
				
//				위로
				for (int i=bottom; i>= top && count <= N*N; i--) {
					arr[i][left] = count++;
				}
				left++;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println("#"+test_case+" ");
			System.out.print(sb);
		}
	}
}