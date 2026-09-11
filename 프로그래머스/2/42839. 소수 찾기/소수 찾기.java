import java.util.*;

class Solution {
    
    int n;
    boolean[] visited;
    int[] nums;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        n = numbers.length();
        nums = new int[n];
        visited = new boolean[n];
        
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        dfs(0);
        
        for(int num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }

    void dfs(int num) {
        set.add(num);

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            
            dfs(num * 10 + nums[i]);

            visited[i] = false;
        }
    }
    
    boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i=2; i*i<=num; i++) {
            if(num%i == 0) return false;
        }
        
        return true;
    }
}