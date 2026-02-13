import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[][] bc;
	static int[] a, b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			List<Integer> A_move = new ArrayList<>();
			List<Integer> B_move = new ArrayList<>();
			bc = new int[A][4];
			a = new int[]{1, 1}; //x, y
			b = new int[]{10, 10};
			
			st = new StringTokenizer(br.readLine());
//			A의 이동 명령
			for(int i=0; i<M; i++) {
				A_move.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
//			B의 이동 명령
			for(int i=0; i<M; i++) {
				B_move.add(Integer.parseInt(st.nextToken()));
			}
			
//			BC 정보
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i][0] = Integer.parseInt(st.nextToken()); //x좌표
				bc[i][1] = Integer.parseInt(st.nextToken()); //y좌표
				bc[i][2] = Integer.parseInt(st.nextToken()); //범위 c
				bc[i][3] = Integer.parseInt(st.nextToken()); //출력 p
			}
			
//			이제 M만큼 돌리면서 만약 BC의 범위에 들어갔는지 확인하기 들어갔다면 P를 더하기(모든 체크가 끝난 후)
//			만약 한 BC에 2명이 들어갔다면 P를 각각 절반으로 나누기
//			만약 두 BC에 1명이 들어갔다면 가장 출력이 높은 BC의 P를 더하기(어느 시점에?)
//			만약 두 BC에 2명이 들어갔다면? 더 높은 출력의 반이 다른 출력보다 큰지 확인하기
//			A, B가 둘다 이동한 후에 체크해야함. BC의 범위가 맞는지 체크를 다 하고 나서 더해야함.
			int sum = 0;
			for (int time = 0; time <= M; time++) {
			    List<Integer> A_check = new ArrayList<>();
			    List<Integer> B_check = new ArrayList<>();

			    for (int j = 0; j < A; j++) {
			        if (check(a[0], a[1], j)) {
			            A_check.add(j);
			        }
			        if (check(b[0], b[1], j)) {
			            B_check.add(j);
			        }
			    }

			    int max = 0;

			    if (A_check.isEmpty()) A_check.add(-1);
			    if (B_check.isEmpty()) B_check.add(-1);

			    for (int ai : A_check) {
			        for (int bi : B_check) {

			            int temp = 0;

			            if (ai == -1 && bi == -1) {
			                temp = 0;
			            }
			            else if (ai == bi) {
			                temp = bc[ai][3];
			            }
			            else {
			                if (ai != -1) temp += bc[ai][3];
			                if (bi != -1) temp += bc[bi][3];
			            }

			            max = Math.max(max, temp);
			        }
			    }

			    sum += max;

			    // 마지막이면 이동 안 함
			    if (time < M) {
			        move(0, A_move.get(time));
			        move(1, B_move.get(time));
			    }
			}	
			
			
			sb.append('#').append(tc).append(' ').append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
	
//	bc넘버와 위치를 넣으면 bc 범위에 들어가있는지 체크 함수
	private static boolean check(int x, int y, int num) {
		int d = Math.abs(bc[num][0] - x) + Math.abs(bc[num][1] - y);
		if(bc[num][2] >= d) return true;
		
		return false;
	}
	
//	
	private static void move(int human, int order) {
		if(human == 0) { //a
			switch (order) {
			case 0:
				break;
			case 1: //상
				a[1]--;
				break;
			case 2: //우
				a[0]++;
				break;
			case 3: //하
				a[1]++;
				break;
			case 4: //좌
				a[0]--;
				break;
			}
		} else { //b
			switch (order) {
			case 0:
				break;
			case 1: //상
				b[1]--;
				break;
			case 2: //우
				b[0]++;
				break;
			case 3: //하
				b[1]++;
				break;
			case 4: //좌
				b[0]--;
				break;
			}
		}
	}

}
