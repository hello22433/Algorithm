import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visitedComputer;
    
    public int solution(int n, int[][] computers) {
        visitedComputer = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visitedComputer[i]) {
                answer++;
                // dfs(i, computers);
                bfs(i, computers);
            }
        }
        
        return answer;
    }
    
    private void bfs(int cmpIdx, int[][] computers) {
        
        Deque<Integer> q = new ArrayDeque<>(); 
        q.offer(cmpIdx);
        visitedComputer[cmpIdx] = true;
        
        while (!q.isEmpty()) {
            
            int curCmpIdx = q.poll();
            
            for (int i = 0; i < computers[curCmpIdx].length; i++) {
                if (computers[curCmpIdx][i] == 1 && !visitedComputer[i]) {
                    visitedComputer[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    
//     private void dfs(int cmpIdx, int[][] computers) {
//         // 컴퓨터 순환이 끝났을 때 || 이미 방문한 컴퓨터일 때
//         if (visitedComputer[cmpIdx]) {
//             return;
//         }
        
//         // 순회하되, 이전 루트가 있으면 answer++안함.
//         visitedComputer[cmpIdx] = true;
        
//         for (int i = 0; i < computers[cmpIdx].length; i++) {
//             if (computers[cmpIdx][i] == 1 && i != cmpIdx) {
//                 dfs(i, computers);
//             }
//         }
//     }
}

// 01 -> 12 -> 23 24.. 방문했는지 안했는지 체크해나가면 될 것 같다. 
// 방문을 안했다면 무조건 네트워크 수가 증가한다고 보기는 어렵다. 이전 루트가 있었는지의 여부가 중요하다.
// 루트가 없었으면 해당 노드가 시작점이므로 네트워크수+1
// 
// 컴퓨터를 순회하여 방문한다
// 하나의 컴퓨터를 순회할때 그 컴퓨터 자체에 대한 방문 여부를 체크하면 된다.
// 