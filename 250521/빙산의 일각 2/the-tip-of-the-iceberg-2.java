import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        // Please write your code here.

        int maxCount = 0;
        for (int i = 0; i <= 1001; i++) {
            
            int count = 0;
            boolean checkPreMountain = false;
            for (int j = 0; j < n; j++) {
                if (h[j] > i && !checkPreMountain) {
                    checkPreMountain = true;
                    count++;
                }

                if (h[j] <= i) {
                    checkPreMountain = false;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.print(maxCount);
    }
}

// 높이를 정한다.
// 높이보다 높고 빙산이 전에 올라와있지 않았다면 (false) true로 바꾸고 +1
// 높이보다 낮으면 false로 바꾼다.
// 높이보다 높고 올라와 있었다면 (true) 그냥 넘어간다.