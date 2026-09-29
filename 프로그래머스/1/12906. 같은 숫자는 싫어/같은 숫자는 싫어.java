import java.util.*;

public class Solution {
    public int[] solution(int []arr) {        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr) {
            if(stack.isEmpty()) stack.push(i);
            else if(stack.peek() == i) continue;
            else stack.push(i);
        }
        
        int size = stack.size();
        int[] answer = new int[size];
                
        for(int i=size-1; i>=0; i--) {
            answer[i] = stack.pop();
        }
        

        return answer;
    }
}