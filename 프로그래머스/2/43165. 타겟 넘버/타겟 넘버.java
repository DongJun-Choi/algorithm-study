import java.util.*;

class Solution {
    static int[] arr;
    static int count, len, n;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
//         target의 수가 되게 하는 방법의 수
        
        len = numbers.length;
        n = target;
        
        arr = Arrays.copyOf(numbers, len);
        
        count = 0;
        
        dfs(0, 0);
        
        answer = count;
        
        return answer;
    }
    
    static void dfs(int depth, int num) {
        if(depth == len) {
            if(num == n) count++;
            return;
        }
        
        dfs(depth+1, num+arr[depth]);
        dfs(depth+1, num-arr[depth]);
    }
}