import java.util.*;

class Solution {
    
    List<String> path = new ArrayList<>();
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        path.add("ICN");
        dfs(tickets, 0);
        
        return path.toArray(new String[0]);
    }
    
    private boolean dfs(String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            return true;
        }
        
        // 
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && path.get(path.size()-1).equals(tickets[i][0])) {
                visited[i] = true;
                
                path.add(tickets[i][1]);

                if (dfs(tickets, cnt+1)) {
                    return true;
                }

                path.remove(path.size()-1);
                visited[i] = false;
            }
            
        }
        return false;
    }
}

// 모든 경우의 수를 따져봐야한다
// 백트래킹으로 티켓을 모두 쓰는 경우를 찾아나간다.