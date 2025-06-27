import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];

        int totalBlocks = 0;
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
            totalBlocks += blocks[i];
        }
        int averBlocks = totalBlocks / n;

        int movingBlocks = 0;
        for (int i = 0; i < n; i++) {
            // 평균보다 많으면 덜어내야함
            if (blocks[i] > averBlocks) {
                movingBlocks += blocks[i] - averBlocks;
            }
        }

        System.out.print(movingBlocks);
    }
}

// 문제
// N개의 위치별 블럭의 개수가 주어짐
// 특정 위치를 골라 해당 위치의 블럭을 다른 위치로 옮김 -> 반복
// 모든 위치에 놓인 블럭의 개수가 동일해져야 함
// 항상 동일함이 가능한 상황이 주어짐

// 요구사항
// 움직여야 할 최소 블럭의 수

// 이해
// 평균을 구해야 한다. 