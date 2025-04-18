import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1][2];
        for (int i = 1; i < N+1; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        dfs(1, 0);
        
        System.out.print(result);
    }

    private static void dfs(int day, int PiSum) {
        if (day == N+1) {
            result = Math.max(result, PiSum);
            return;
        }

        // 상담을 하는 경우
        if (day+arr[day][0] <= N + 1) {
            dfs(day + arr[day][0], PiSum + arr[day][1]);
        }
        
        // 상담을 안 하는 경우
        dfs(day+1, PiSum);
    }
}



// 상담을 하였을때 if (i+Narr[0] <= N + 1) 해당시간을 더해서 넘겨준다.
// i가 N+1일때 멈추고 max갱신한다.
// 상담을 안 하는 경우는 i에 1만을 더해서 넘겨준다.