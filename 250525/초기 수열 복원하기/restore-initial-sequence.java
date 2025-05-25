import java.util.Scanner;
public class Main {
    static int[] a;
    static int[] b;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n - 1];
        b = new int[n];
        for (int i = 0; i < n - 1; i++)
            a[i] = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            b[0] = i;
            boolean[] used = new boolean[n+1];
            used[b[0]] = true;

            boolean isValiad = true;
            for (int j = 0; j < n-1; j++) {
                b[j+1] = a[j] - b[j];
                if (b[j+1] < 1 || b[j+1] > n || used[b[j+1]]) {
                    isValiad = false;
                    break;
                }
                used[b[j+1]] = true;
            }

            if (isValiad) {
                for (int j = 0; j < n; j++) {
                    System.out.print(b[j] + " ");
                }
            }
        }
    }
}

// N개를 가진 수를 하나씩 다 가정해본다.
// dfs로 