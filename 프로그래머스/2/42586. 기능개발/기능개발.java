import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 기능이 완료될 때까지 걸리는 날짜 계산
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];

            // 올림 나눗셈
            int day = (remain + speeds[i] - 1) / speeds[i];

            q.offer(day);
        }

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            // 가장 앞 기능의 완료 날짜
            int deployDay = q.poll();
            int cnt = 1;

            // 뒤 기능이 앞 기능보다 일찍 또는 같은 날 완료되면 같이 배포
            while (!q.isEmpty() && q.peek() <= deployDay) {
                q.poll();
                cnt++;
            }

            list.add(cnt);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}