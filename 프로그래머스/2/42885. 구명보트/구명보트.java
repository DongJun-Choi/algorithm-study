import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int min_count = 0;
        int n = people.length;
        boolean[] visited = new boolean[n];
        
        for(int i=n-1; i>=0; i--) {
            if(visited[i]) continue;
            
            if(people[i] + people[min_count] <= limit) {
                visited[i] = true;
                visited[min_count] = true;
                cnt++;
                min_count++;
            } else {
                visited[i] = true;
                cnt++;
            }
        }
        
        int answer = cnt;
        return answer;
    }
}