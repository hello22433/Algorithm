class Solution {
    static int cnt = 0;
    static int tarNum;
    static int[] numArr;
    
    public int solution(int[] numbers, int target) {
        // n개의 음이 아닌 정수들 -> 순서 안 바꾸기 -> 적절히 더하거나 빼기 -> 타겟 넘버 만들기
        // 순서에 상관있게, 더하기/빼기를 모두 탐색
        
        numArr = numbers;
        tarNum = target;
        dfs(0, 0);
        return cnt;
    }
    
    public void dfs(int sum, int start) {
        if (start == numArr.length) {
            if (sum == tarNum) cnt++;
            return;
        }
        
        dfs(sum + numArr[start], start+1);
        dfs(sum - numArr[start], start+1);
    }
    
//     public int dfs(int index, int current_sum, int[] numbers, int target) {
//         if (index == numbers.length) {
//             return (current_sum == target) ? 1 : 0;
//         }
        
//         int add = dfs(index + 1, current_sum + numbers[index], numbers, target);
//         int subtract = dfs(index + 1, current_sum - numbers[index], numbers, target);
        
//         return add+subtract;
//     }
    
//     public int solution(int[] numbers, int target) {
//         return dfs(0, 0, numbers, target);
//     }
}