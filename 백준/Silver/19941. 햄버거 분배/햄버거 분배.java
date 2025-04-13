
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine();
        String HP = scanner.nextLine();

        char[] arr = HP.toCharArray();
        boolean[] visited = new boolean[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int left = Math.max(0, i - K);
                int right = Math.min(N - 1, i + K);

                for (int j = left; j <= right; j++) {
                    if (!visited[j] && arr[j] == 'H') {
                        visited[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}


//