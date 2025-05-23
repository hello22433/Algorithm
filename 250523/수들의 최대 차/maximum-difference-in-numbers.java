import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int maxCnt = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {

            int cnt = 0;
            int maxNum = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] <= arr[j] && arr[j] - arr[i] <= k) {
                    cnt++;
                    maxNum = Math.max(maxNum, arr[j]);
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.print(maxCnt);
    }
}

// 적절하게 뽑는다 -> 최솟값을 정하고 최댓값을 고른다.
// 1개부터 N개를 뽑아야 한다.
// 그 중에 최소값과 최대값을 갱신한다.
// 그 차가 K이하라면 i를 maxCnt에 저장한다.

// 최소값을 배열의 하나로 정한다.
// 만약 최소값 큰 값이 나오면 뽑은숫자개수+1(초기값은1)
// 동시에 최대값 갱신
// 반복끝나면 최대값과 최소값의 차를 구하고 K이하가 된다면 뽑은숫자개수로 최대값을 갱신한다.
