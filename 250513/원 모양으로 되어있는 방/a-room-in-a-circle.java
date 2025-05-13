import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int bucketDistanceSum = 0;
            int distance = 0;
            for (int j = i; j < n + i; j++) {
                bucketDistanceSum += arr[j%n] * distance++;
            }
            minDistance = Math.min(minDistance, bucketDistanceSum);
        }

        System.out.print(minDistance);
    }
}

// 하나의 방을 정한다 -> 하나의 방의 전 방까지 순회한다.
// %n (n-1까지 돌으므로 n으로 나눠줘야 함)
// i로 순회하면서 하나씩 방을 정한다 (인덱스로). 이중탐색으로 i부터 시작하여 j < n+i(i가 돌아간 만큼 더 돌아가야 하므로)
// 