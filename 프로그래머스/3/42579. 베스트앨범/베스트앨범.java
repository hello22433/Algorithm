import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        
        // 장르 별로 인덱스와 재생수를 모두 들고 있어야 한다. 
        Map<String, List<int[]>> sebu_map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            // sebu_map.put(genres[i], sebu_map.getOrDefault(genres[i], new ArrayList<>()).add(new int[]{i, plays[i]}));
            sebu_map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        
        for (Map.Entry<String, List<int[]>> s : sebu_map.entrySet()) {
            s.getValue().sort((a,b) -> b[1] - a[1]);
        }
        
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        
        list.sort((a,b) -> b.getValue() - a.getValue());
        
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> m : list){
            String genre = m.getKey();
            
            List<int[]> indexAndPlays = sebu_map.get(genre);
            for (int i = 0; i < Math.min(2, indexAndPlays.size()); i++) {
                int[] song = indexAndPlays.get(i);
                int index = song[0];
                int play = song[1];
                
                result.add(index);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

// 1. 많이 재생된 장르 -> 2. 장르 내에서 많이 재생 -> 3. 재생수가 같으면 고유 번호가 낮은 거 먼저
// 장르별로 map 밸류 합치면서 누적 -> 리스트로 바꿈 -> 밸류값으로 리스트를 내림차순 -> 각 리스트를 내림차순으로 정렬 -> 각 리스트를 순회 -> Math.min(2, list.size())
// 정답 리스트 만들고, 