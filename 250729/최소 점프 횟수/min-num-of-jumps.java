import java.util.Scanner;
public class Main {
    static int n;
    static int[] arr;
    static int minJump = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        dfs(0, 0);

        if (minJump != Integer.MAX_VALUE) 
            System.out.print(minJump);
        else 
            System.out.print(-1);
    }

    public static void dfs(int curIdx, int jumpCnt) {
        if (curIdx >= n-1) {
            // System.out.println(curIdx + " " + jumpCnt);
            minJump = Math.min(minJump, jumpCnt);
            return;
        } else {
            if (arr[curIdx] == 0) {
                return;
            }
        }

        for (int i = 1; i <= arr[curIdx]; i++) {
            dfs(curIdx + i, jumpCnt+1);
        }
    }
}



// 0이 나오는 곳으로 갈 수밖에 없다면, -1를 출력해야 한다.
// 마지막 위치에 도달할때마다 이동 횟수를 최소값 갱신한다.

// 현재 있는 위치(인덱스0에서 시작)의 값을 현재 인덱스에 차례로 더한다. 
// 만약, 마지막 인덱스 이상이면 이동값을 최소값 갱신한다.
// 