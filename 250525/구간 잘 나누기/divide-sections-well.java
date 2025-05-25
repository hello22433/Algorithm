import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            maxValue = Math.max(maxValue, nums[i]);
        }

        int haveCost = m-1;

        
    }
}

// 구간합의 최댓값이 최소가 되게 하라.

// n개의 수에 m-1개의 칸막이를 넣어야 한다.
// n+m-1 크기의 배열을만든다.
// 
// 최대구간합을 가정한다.
// haveCost를 m-1로 설정한다.
// 처음부터 누적합을 구한다.
// 누적합이 최대구간합과 같으면 지금 수 바로 다음에 칸막이를 세울 것이고 (즉 누적합을 0으로 한다. 마지막인 경우에 코스트가 없어도 된다.)
// 크면 바로 전에다가 칸막이를 세울 것이다. (즉 누적합을 현재 값으로 바꾼다. 마지막인 경우여도 코스트가 있어야 한다.) (가장 큰 값부터 시작하게 하게 모순을 없앤다.)
// 만약 같은 경우는 valid를 true로 만든다.
// 돌다가 칸막이를 세울 코스트가 부족하면 break을 하며 valid를 false로 만든다.
// 반복문 이후 valid가 true이면 최대구간합으로 최소화 한다.