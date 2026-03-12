import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //숫자의 개수
			int k = Integer.parseInt(st.nextToken()); // 크기 순서
			
//			구조가 n을 4개로 나눈 값 만큼 진행하면서 값을 생성함
			
//			생성되는 값들을 다 저장하고 정렬하면 될듯, 근데 중복되는 값은 없어야함.(중복을 없앨려면 set? map?)			
//			생성되는 값은 16진수이므로 String 값을 어떻게 16진수로 바꾸고, 16진수 값을 10진수로 바꿔야할지 생각해야함.
			Set<String> set = new HashSet<>();
			
			String s = br.readLine();
			int len = s.length() / 4;
//			어떻게 할까? 완료
			for(int j=0; j<len; j++) {
				for(int i=0; i<4; i++) {
					int start = (i*len + j);
					int end = ((i+1)*len + j);
					if(end >= s.length()) {
						String s1 = s.substring(start, s.length()) + s.substring(0, end - s.length());
						set.add(s1);
					} else {
						String s1 = s.substring(start, end);
						set.add(s1);
					}
				}
			}
			
//			중복 되는 값 없이 저장해야하고, 정렬하고, k번째 값 출력
//			중복 허용안하고 알아서 정렬되는 거 자료구조 하나 있었는데 뭐였지?
//			일단 스스로 해결해보고 찾기 set은 중복만 제거하는구나
//			진수 바꾸는 함수는 뭐였지?
			
			int[] arr = new int[set.size()];
			
			int cnt = 0;
			for(String val : set) {
				int total = 0;
				for(int i=0; i<val.length(); i++) {
					int value = 0;
					char c = val.charAt(i);
					if(c >= 'A') {
						value = c - 'A' + 10;
					} else {
						value = c -'0';
					}
					total += value*(Math.pow(16, len -1 -i));
					
				}				
				arr[cnt++] = total;
			}
			
			Arrays.sort(arr);
			

			k = arr.length - k;
			
			sb.append('#').append(tc).append(' ').append(arr[k]).append("\n");			
		}
		System.out.println(sb);
	}
	

}
