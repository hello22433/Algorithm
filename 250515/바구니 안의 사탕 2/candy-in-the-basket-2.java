import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        // int[] candies = new int[n];
        // int[] positions = new int[n];
        candyAndPosition[] candies = new candyAndPosition[n];
        for (int i = 0; i < n; i++) {
            candies[i] = new candyAndPosition(sc.nextInt(), sc.nextInt());
            // candies[i] = sc.nextInt();
            // positions[i] = sc.nextInt();
        }

        // 0~100
        // 1~200 -> 0~200
        int[] line = new int[201];
        for (int i = 0; i < n; i++) {
            candyAndPosition candyInfo = candies[i];
            line[candyInfo.position] += candyInfo.candies;
        }

        // c가 1이면 양쪽으로 하나씩 더 해야 한다.
        int maxSum = Integer.MIN_VALUE;
        for (int i = c; i <= 201-c-1; i++) {
            int sum = 0;
            for (int j = i-c; j <= i+c; j++) {
                sum += line[j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);
    }
}

class candyAndPosition {
    int candies;
    int position;

    candyAndPosition(int candies, int position) {
        this.candies = candies;
        this.position = position;
    }
}