import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int[] abilities = {a,b,c,d,e};
        int sum = a + b + c + d + e;
        // Please write your code here.
        int minDiffer = Integer.MAX_VALUE;

        // 1팀
        for (int i = 0; i < 5; i++) {
            
            // 2팀 (동시에 3팀)
            for (int j = 0; j < 4; j++) {
                for (int k = j+1; k < 5; k++) {
                    if (i == j || i == k) continue;

                    int sum1 = abilities[i];
                    int sum2 = abilities[j] + abilities[k];
                    int sum3 = sum - (sum1 + sum2);

                    if (sum1==sum2 || sum1==sum3 || sum2==sum3) continue;

                    int maxSum = Math.max(sum1, Math.max(sum2, sum3));
                    int minSum = Math.min(sum1, Math.min(sum2, sum3));

                    minDiffer = Math.min(minDiffer, maxSum - minSum);
                }
            }
        }

        if (minDiffer == Integer.MAX_VALUE) {
            minDiffer = -1;
        }
        
        System.out.print(minDiffer);
    }
}

// 능력치가 서로달라야 한다.
// (최대합 - 최소합)이 최소가 되어야 한다.
// 