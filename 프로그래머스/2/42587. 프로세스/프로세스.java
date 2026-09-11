import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = priorities.length;
        
        for(int i=0; i<n; i++) {
            q.offer(new int[] {priorities[i], i});
            pq.offer(priorities[i]);
        }
        
        int[] run = new int[n];
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int val = pq.poll();
            
            while(!q.isEmpty()) {
                int[] cur = q.poll();
            
                if(cur[0] == val) {
                    run[cnt] = cur[1];
                    cnt++;
                    break;                    
                }
                q.offer(cur);
            }
        }        
        
        int answer = 0;
        for(int i=0; i<run.length; i++) {
            if(run[i] == location) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}