class Solution {
    public int solution(int[][] sizes) {
        
        int longestOfLongs = 0;
        int longestOfShorts = 0;
        
        
        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if (w>h) {
                longestOfLongs = Math.max(longestOfLongs, w);
                longestOfShorts = Math.max(longestOfShorts, h);
            } else {
                longestOfLongs = Math.max(longestOfLongs, h);
                longestOfShorts = Math.max(longestOfShorts, w);
            }
        }
        
        return longestOfLongs * longestOfShorts;
    }
}