import java.util.*;

class Solution {
    
    int n;
    int[] nums;
    boolean[] visited;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int solution(String numbers) {
//         한자리 숫자가 적힌 종이 조각 여러개, 붙여서 몇개의 소수 만들 수 있나
//         011이나 11은 같다.        
        
//         일단 String에서 숫자 추출
//         모든 숫자들을 첫 시작으로 잡고 탐색 진행
//         돌면서 끝까지 닿거나 중간마다 소수 체크하고 map 넣기
//         다 돌면 map의 key 크기만큼 나옴.
        
        n = numbers.length();
        nums = new int[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        dfs(0);        
        
        return map.size();
    }
    
    void dfs(int number) {
        if(isPrime(number)) {
            map.put(number, 1);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            dfs(number * 10 + nums[i]);

            visited[i] = false;
        }
    }
    
    boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}