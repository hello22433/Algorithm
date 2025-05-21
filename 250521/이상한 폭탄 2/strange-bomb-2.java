import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        // Please write your code here.
        
        int maxNumberBomb = Integer.MIN_VALUE;
        for (int i = 0; i <= n-k-1; i++) {
            int selectBomb = bombs[i];
            for (int j = i+1; j <= i+k; j++) {
                if (selectBomb == bombs[j]) {
                    maxNumberBomb = Math.max(maxNumberBomb, selectBomb);
                    break;
                }
            }
        }

        System.out.print(maxNumberBomb);
    }
}


// N개 폭탄 각자에게 번호 -> 같은 번호끼리 K거리 안에 있으면 폭발
// 폭발 할 폭탄 중 가장 큰 번호
// 