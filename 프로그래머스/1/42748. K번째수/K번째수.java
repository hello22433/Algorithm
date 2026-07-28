import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        
        for (int i = 0; i < commands.length; i++) {
            int[] cmd = commands[i];
            int startIdx = cmd[0]-1;
            int endIdx = cmd[1]-1;
            int cuttedSelectedIdx = cmd[2] - 1;
            
            // 잘라서 새로운 객체를 만들고 정렬해서 고른다.
            int[] newArr = new int[endIdx-startIdx+1];
            for (int j = 0; j < newArr.length; j++) {
                newArr[j] = array[startIdx + j];
            }
            
            Arrays.sort(newArr);
            answer[i] = newArr[cuttedSelectedIdx];
        }
        
        return answer;
    }
}