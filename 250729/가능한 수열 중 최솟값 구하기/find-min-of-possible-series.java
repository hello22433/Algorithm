import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr, one, two;
    static boolean check = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        
        arr = new int[n];
        dfs(0);
    }

    public static boolean isPossible(int len) {
        // 시작점
        for (int i = 0; i < len; i++) {

            // 길이
            outer2: for (int j = 1; j <= len/2; j++) {
                
                // 첫번째 배열
                for (int k = i; k < i+j; k++) {
                    // 남은 길이보다 설정한 길이가 크다면 넘긴다. (인덱스 기준)
                    if (k+j >= len || j-1 > k+j) continue outer2; 
                    
                    if (arr[k] != arr[k+j]) continue outer2;
                }
                return false;
            }
        }
        return true;
    }

    public static void dfs(int depth) {
        if (check) return;

        if (depth == n) {
            check = true;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
            }
            return;
        }

        for (int num = 4; num <= 6; num++) {
            arr[depth] = num;
            if (isPossible(depth+1)) {
                dfs(depth+1);
            }
        }
    }
}



// N
// 4 5 6
// 두 개의 인접한 연속 부분 수열이 동일 -> 불가능
// 가능한 N수열 중, 사전순으로 가장 앞선 수열을 출력

// 만들어놓고
// 검사해야지, 동일한 연속 부분 수열이 존재하는지
// 