import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        Arrays.sort(p);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (b - p[i] >= 0) {
                b -= p[i];
                count++;
            } else {
                if (b - p[i] / 2 >= 0) {
                    // b -= p[i];
                    count++;
                }
                break;
            }
        }
        System.out.print(count);
    }
}
 
// 오름차순으로 정렬하여 유리한 것을 먼저 산다. 
// 