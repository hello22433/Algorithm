import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();
        // Please write your code here.

        int maxCnt = 1;
        int boomNum = 0;
        for (int i = 0; i <= 1000000; i++) {
            
            int dist = 1;
            boolean firstI = false;
            int cnt = 0;

            for (int j = 0; j < n; j++) {

                if (firstI) {
                    if (bombs[j] == i) {
                        if (dist <= k) {
                            cnt++;
                        }
                        dist = 1;
                    } else {
                        dist++;
                    }
                } else {
                    if (bombs[j] == i) {
                        firstI = true;
                    }
                }
            }

            if (cnt >= maxCnt) {
                maxCnt = cnt;
                boomNum = i;
            }
        }

        System.out.print(boomNum);
    }
}

// 