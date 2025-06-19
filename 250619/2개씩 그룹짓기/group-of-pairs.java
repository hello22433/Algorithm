import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;

        // 0부터 2n-1까지
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]+nums[2*n-1-i]);
        }
        System.out.print(max);
    }
}


// 각 그룹 원소의 합 중에서 가장 큰 값이 최소가 되어야 한다.
// 큰것들끼리 붙여 놓으면 안된다. 가장 큰 것과 가장 작은 것이 합쳐져야 함.
// 가장 작게 만드려면 가장 큰 값과 가장 작은 값을 붙여놔야 한다. 그 후 차례로 큰값과 작은 값을 포개야 한다.
// 