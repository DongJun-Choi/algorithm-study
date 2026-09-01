import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> totalMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            totalMap.put(genre, totalMap.getOrDefault(genre, 0) + plays[i]);

            indexMap.putIfAbsent(genre, new ArrayList<>());
            indexMap.get(genre).add(i);
        }
        
        ArrayList<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (String genre : genreList) {
            ArrayList<Integer> list = indexMap.get(genre);
            list.sort((a, b) -> plays[b] - plays[a]);
            
            result.add(list.get(0));
            
            if (list.size() >= 2) {
                result.add(list.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}