import java.util.*;

class Solution {
    static boolean[] visited;
    static String[][] ticketss;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        visited = new boolean[tickets.length];
        ticketss = tickets;
        
        for (int i = 0; i < ticketss.length; i++) {
            if (ticketss[i][0].equals("ICN")) {
                visited[i] = true;
                String[] bucket = new String[2];
                bucket[0] = ticketss[i][0];
                bucket[1] = ticketss[i][1];
                String[] result = dfs(bucket);
                visited[i] = false;
                
                if (result.length == ticketss.length + 1)
                    return result;
            }
        }
        
        return new String[]{"0"};
    }
    
    public String[] dfs(String[] bucket) {
        if (bucket.length == ticketss.length + 1) {
            return bucket;
        }
        
        for (int i = 0; i < ticketss.length; i++) {
            if (ticketss[i][0].equals(bucket[bucket.length-1]) && !visited[i]) {
                visited[i] = true;
                String[] newBucket = new String[bucket.length + 1];
                for (int a = 0; a < bucket.length; a++) {
                    newBucket[a] = bucket[a];
                }
                newBucket[newBucket.length-1] = ticketss[i][1];
                
                String[] result = dfs(newBucket);
                if (result.length == ticketss.length + 1) return result;

                visited[i] = false;  // 백트래킹 수행
            }
        }
        
        return new String[]{};
    }
}


// ICN 공항에서 출발
// 항공권 정보가 담긴 2차원 배열 tickets 
// 