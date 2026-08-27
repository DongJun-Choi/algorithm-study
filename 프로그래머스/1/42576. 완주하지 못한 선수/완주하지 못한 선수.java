import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 참가자 수 세기
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 2. 완주한 사람 빼기
        for (String name : completion) {
            int count = map.get(name) - 1;

            if (count == 0) {
                map.remove(name);
            } else {
                map.put(name, count);
            }
        }

        // 3. 1명 남아있는 사람이 미완주자
        for (String name : map.keySet()) {
            return name;
        }

        return "";
    }
}