import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] human = {
            {1, 2, 3, 4, 5}, 
            {2, 1, 2, 3, 2, 4, 2, 5}, 
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] math = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int num0 = i % 5;
            int num1 = i % 8;
            int num2 = i % 10;
            
            if (answers[i] == human[0][num0]) math[0]++;
            if (answers[i] == human[1][num1]) math[1]++;
            if (answers[i] == human[2][num2]) math[2]++;
        }
        
        int max = Math.max(math[0], Math.max(math[1], math[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (math[i] == max) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}