import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 하나만 다른 경우, 큐에 넣는다.
        // 큐를 뽑고, words를 돌면서 각각이 poll 과 하나만 다른지 확인.
        // cnt 1씩 증가
        // 만약 같은 걸 찾는다면 cnt 반환
        // 큐가 비었으면 0 반환
        // 
        
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        boolean[] visited = new boolean[words.length];
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            
            for (int i = 0; i < qSize; i++) {
                String poller = q.poll();
                
                if (poller.equals(target)) return cnt;
                
                for (int j = 0; j < words.length; j++) {
                    if (isDifferOnlyOneAlphabet(words[j], poller) && !visited[j]) {
                        visited[j] = true;
                        q.add(words[j]);
                    }
                }
            }
            cnt++;
            
        }
        
        return 0;
        
//         int answer = 0;
        
//         // words에 target이 없으면 0반환
//         ArrayList<String> words_list = new ArrayList<>(Arrays.asList(words));
//         if (!words_list.contains(target)) {return 0;}
        
//         // BFS로 구할것. queue, visited(방문여부, 방문순서 [맵])
//         Queue<String> words_queue = new LinkedList<>();
//         words_queue.offer(begin);
//         HashMap<String, Integer> visited = new HashMap<>();
//         visited.put(begin, 0);
        
//         while (!words_queue.isEmpty()) {
//             String current_word = words_queue.poll();
//             // 현재단어의 현재방문순서
//             int current_visited = visited.get(current_word);
            
//             for (String next_word : words) {
//                 // 알파벳이 하나만 다른지 판별
//                 // 큐에서 꺼낸 단어가 만약 방문하지 않았고 알파벳이 하나만 다르다면 큐에 넣고 방문에 추가
//                 if (one_alphabet(current_word, next_word) && !visited.containsKey(next_word)) {
//                     words_queue.offer(next_word);
//                     visited.put(next_word, current_visited + 1);   
//                     if (next_word.equals(target)) {return current_visited + 1;}
//                 }
//                 // 만약 타겟과 같으면 현재방문횟수 +1 리턴
//             }
//         }
//         return 0;
//     }
    
//     public boolean one_alphabet(String cur, String next) {
//         int different = 0;
//         for(int i = 0; i < cur.length(); i++) {
//             if (cur.charAt(i) != next.charAt(i)) {
//                 different++;
//             }
//             if (different > 1) {return false;}
//         }
//         return different != 0;
    }
    
    public boolean isDifferOnlyOneAlphabet(String a, String b) {
        boolean isDiffer = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!isDiffer) {
                    isDiffer = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

// words에 target이 없으면 0반환

// 알파벳이 하나만 다른지 판별
// 현재단어의 현재방문횟수
// BFS로 구할것. queue, visited(방문여부, 방문횟수 [맵])
// 큐에서 꺼낸 단어가 만약 방문하지 않았고 알파벳이 하나만 다르다면 큐에 넣고 방문에 추가
// 만약 타겟과 같으면 현재방문횟수 +1 리턴