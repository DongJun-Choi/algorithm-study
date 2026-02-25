import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, min, remain;
	static int[] arr;
	static boolean[][] graph;
	static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n]; //구역마다 인구수 저장
		graph = new boolean[n][n];
		
		remain = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			remain += arr[i];
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
//				인접한 구역들
				graph[i][num-1] = true;
				graph[num-1][i] = true;
			}
		}
		
		min = Integer.MAX_VALUE;
		
		selected = new boolean[n];

        // arr[0]은 항상 A에 포함 (중복 제거)
        selected[0] = true;

        // A에 추가로 뽑을 개수 r = 0 ~ N-2
        for (int r = 0; r <= n - 2; r++) {
            combination(1, r);
        }
		
//		조합 뽑기
		
//		그 조합으로 check하기
		
//		check 되었을때 참이라면 인구수 차이 뽑기
//		한 조합만 값 확인해서 더하고 remain에서 빼기 = 최솟값
		
        if(min == Integer.MAX_VALUE) {
        	min = -1;
        }
		
        System.out.println(min);
		
	}
	
	
//	조합 뽑는 함수
	static void combination(int start, int r) {
        if (r == 0) {
            printGroups();
            return;
        }

        for (int i = start; i < n; i++) {
            selected[i] = true;
            combination(i + 1, r - 1);
            selected[i] = false;
        }
    }
	
//	뽑은 조합을 배열에 따로 저장하는 함수
	static void printGroups() {

        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (selected[i]) groupA.add(i);
            else groupB.add(i);
        }

        // B가 비어있으면 제외 (빈 그룹 불허)
        if (groupB.size() == 0) return;

        int[] A = groupA.stream().mapToInt(Integer::intValue).toArray();
        int[] B = groupB.stream().mapToInt(Integer::intValue).toArray();

        if(check(A) && check(B)) {        	
        	int sumA = 0;
        	for (int v : A) sumA += arr[v];
        	int sumB = remain - sumA;
        	min = Math.min(min, Math.abs(sumA - sumB));


        }
    }
	
	
	
//	2차원 배열로 인접을 보고 바로 판단 하기
//	한점이 모든 점과 이어져있는게 중요한게 아니라 각 모든 정점들이 결국 다른 점과 이어지기만 하면 괜찮다. 
//	dfs나 bfs로 한줄에서 끝까지 돌아서 완전히 도는게 가능한지 확인해야함.
	private static boolean check(int[] numbers) {
		if (numbers.length == 1) return true;
		
		boolean[] inGroup = new boolean[n];
	    for (int v : numbers) inGroup[v] = true;

	    // BFS 시작점: 그룹의 아무 원소 하나
	    int start = numbers[0];

	    boolean[] visited = new boolean[n];
	    java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();
	    visited[start] = true;
	    q.add(start);

	    int visitedCount = 1;
	    int target = numbers.length;

	    while (!q.isEmpty()) {
	        int cur = q.poll();

	        // cur에서 갈 수 있는 다음 정점들
	        for (int next = 0; next < n; next++) {
	            // 그룹 내부 정점만, 아직 방문 안 한 것만
	            if (inGroup[next] && !visited[next] && graph[cur][next]) {
	                visited[next] = true;
	                q.add(next);
	                visitedCount++;
	            }
	        }
	    }

	    return visitedCount == target;
	}
	

}
