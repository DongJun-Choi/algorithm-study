class Solution {
    
    static int[] parent;
    
    static void set(int n) {
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }
    }
    
    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
	}
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<n-1; i++) {
            int a = 0;
            int b = 0;
            
            set(n);
            for(int j=0; j<n-1; j++) {
                if(i == j) continue;
                union(wires[j][0], wires[j][1]);  
            }
            
            int flag = find(1);
            a++;
            
            for(int j=2; j<=n; j++) {
                if(find(j) == flag) a++;
                else b++;
            }
            
            answer = Math.min(answer, Math.abs(a-b));
        }
        
        
        
//         현재 트리는 다 연결되어있는 상태(순환 사이클은 없음)
//         전선들 중 하나를 끊어서 하기(전선의 개수는 n-1개)
        
//         전선 한개 끊고 돌려서 서로 비교 시키기
        
        
        
        return answer;
    }
}