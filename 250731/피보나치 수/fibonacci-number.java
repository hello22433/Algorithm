import java.util.*;

public class Main {
    static int[] fibonachi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibonachi = new int[n+1];
        // Please write your code here.
        if (n == 1 || n == 2) {
            System.out.print(1);
            return;
        }
        
        fibonachi[1] = 1;
        fibonachi[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibonachi[i] = fibonachi[i-2] + fibonachi[i-1];
        }
        
        System.out.print(fibonachi[n]);
    }
}

// 