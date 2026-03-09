import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
    static int[] parents;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean flag = false;
        parents = new int[n];

        for(int i = 0; i < n; i++) parents[i] = i;

        int ans = 0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(flag == false) if(unionSet(x, y) == true){
                flag = true;
                ans = i + 1;
            } 
			
		}
		
		System.out.println(ans);
		
	}
	
	
	static int findSet(int n){
        if(parents[n] == n) return n;
        return parents[n] = findSet(parents[n]);
    } 

    static boolean unionSet(int a, int b){
        int rootA = findSet(a);
        int rootB = findSet(b);

        if(rootA == rootB) return true;

        parents[rootB] = rootA;
        return false;
    }

}
