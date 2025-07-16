class Solution {
    static int N;
    static int[][] computerss;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        // 간접적인 네트워크를 직접적인 네트워크로 이어줘야 한다.
        // computers[0] 1번 컴퓨터에 이어진 컴퓨터들
        // computers[0][1] 이 1이라면 1번컴퓨터가 2번컴퓨터에 이어진것
        // 그럼 2번 컴퓨터로 가서, 2번 컴퓨터에 이어진 것을 체크한다.
        // 만약, 2번컴퓨터에서 이어진 것을 1번 컴퓨터와 이어준다.
        // 즉, 만약 computers[1][2]이 1이라면 2번 컴퓨터가 3번 컴퓨터에 이어진것이므로
        // computers[0][2] 를 1로 바꾼다.
        // 이후 computers[2]에 대해서 또 탐색한다.
        // computers[2]를 [0][1][2] 탐색하면서 
        // 즉, 계속해서 파고들어야 하므로 dfs를 활용한다.
        // 파고들다가 끝까지 탐색했는데 더이상 1인 게 없으면, 종료한다.
        // 
        // 
        N = n;
        computerss = computers;
        visited = new boolean[N];
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(i, i);
            }
        }
        return cnt;
    }
    
    public void dfs(int start, int idx) {
        
        for (int i = 0; i < N; i++) {
            if (computerss[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                computerss[start][i] = 1;
                dfs(start, i);
            }
        }
    }
    
//     public int solution(int n, int[][] computers) {
//         int network = 0;
//         boolean[] visited = new boolean[n];
        
//         for (int i = 0; i < computers.length; i++) {
//             if (!visited[i]) {
//                 dfs(i, computers, visited);
//                 network += 1;
//             }
//         }
//         return network;
//     }
    
//     public void dfs(int node, int[][] computers, boolean[] visited) {
//         visited[node] = true;
        
//         for (int i = 1; i < computers[node].length; i++) {
//             if (computers[node][i] == 1 && !visited[i]) {
//                 dfs(i, computers, visited);
//             }
//         }
        
//     }
}

// 각각의 노드를 만들어서 연결시키면 될까?
// 모든 노드에 대한 연결 => DFS. 
// '하나의 컴퓨터'에 대해서 DFS -> 연결된 컴퓨터들의 '방문의 여부'를 지속적으로 탐구 -> 
// 연결되어있으면 방문했으로 상태변경.