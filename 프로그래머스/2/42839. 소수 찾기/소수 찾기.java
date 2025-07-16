import java.util.*;

class Solution {
    static int cnt = 0;
    static char[] arr;
    static boolean[] visited;
    static Set<Integer> checkNum;
    
    public int solution(String numbers) {
        // 모든 num을 배열에 넣어놓는다.
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        checkNum = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        
        // 조합한다.(어떻게? ) 
        mixAndCalculateCnt("");
        
        return cnt;
    }
    
    public void mixAndCalculateCnt(String str) {
        if (str.length() == arr.length) {
            return;
        }
        
        // 조합한다. (재귀)
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String preStr = new String(str);
                str += arr[i];
                // 숫자로 바꾼다
                int num = Integer.parseInt(str);
                
                // System.out.println(num);
                // 소수인지 판별한다.
                // 소수이면 cnt++
                if (isPrimeNum(num) && !checkNum.contains(num)) cnt++;
                checkNum.add(num);
                
                mixAndCalculateCnt(str);
                str = preStr;
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrimeNum(int num) {
        if (num == 0 || num == 1) return false; 
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

// 조합 : 재귀로 방문한 곳을 제외하고 숫자를 더한다.
        // 만약 끝까지 더했다면 return;
        // 더할때마다 검사해야함
        // ex. 1234
        // 1 / 1 2
        // 1 2 3 / 1234
        // 124 13
        // 

// class Solution {
//     int answer = 0;
//     Set<String> visited = new HashSet<>();
    
//     public int solution(String numbers) {
        
//         HashMap<String, Integer> numbersCount = new HashMap<>();
//         for (int i = 0; i < numbers.length(); i++) {
//             String charNum = String.valueOf(numbers.charAt(i));
//             numbersCount.put(charNum, numbersCount.getOrDefault(charNum, 0) + 1);
//         }
        
//         dfs(numbers, "", numbersCount);
        
//         return answer;
//     }
    
//     public void dfs(String numbers, String num, HashMap<String, Integer> numbersCount) {
//         // 원소를 중복으로 쓰는걸 체크
//         HashMap<String, Integer> count = new HashMap<>();
//         for (int i = 0; i < num.length(); i++) {
//             String charNum = String.valueOf(num.charAt(i));
//             count.put(charNum, count.getOrDefault(charNum, 0) + 1);
//         }
//         for (Map.Entry<String, Integer> map : count.entrySet()) {
//             if (numbersCount.get(map.getKey()) < map.getValue()) {
//                 return;
//             }
//         }
//         // 공백이 아니고, 소수이고, 2이상이고, 방문하지 않았으면
//         // 0이 여러개일 수 있으므로 숫자로 바꾸어주어야 함.
//         if (!num.equals("") && soSoo(num) && 2 <= Integer.parseInt(num) && !visited.contains(String.valueOf(Integer.parseInt(num)))) {
//             answer += 1;
//         } 
//         // 방문한 곳 표시
//         if (!num.equals("")) {
//             visited.add(String.valueOf(Integer.parseInt(num)));
//         }
//         // 길이가 다되어 리턴
//         if (num.length() == numbers.length()) {return;}
        
//         for (int i = 0; i < numbers.length(); i++) {
//             dfs(numbers, num + String.valueOf(numbers.charAt(i)), numbersCount);
//         }
//     }
    
//     public boolean soSoo(String num) {
//         int number = Integer.parseInt(num);
//         for (int i = 2; i <= Math.sqrt(number); i++) {
//             if (number % i == 0) {return false;}
//         }
        
//         return true;
//     }
// }

// 재귀를 통해 
// 