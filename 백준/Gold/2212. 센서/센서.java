import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        if (N <= K) {
            System.out.println(0);
            return;
        }

        int[] censors = new int[N];
        for (int i = 0; i < N; i++) {
            censors[i] = sc.nextInt();
        }

        Arrays.sort(censors); // 오름차순 정렬

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = censors[i + 1] - censors[i];
        }

        // 내림차순 정렬을 위해 Integer[] 사용
        Integer[] diffBoxed = Arrays.stream(diff).boxed().toArray(Integer[]::new);
        Arrays.sort(diffBoxed, Collections.reverseOrder());

        int result = 0;
        for (int i = K - 1; i < diffBoxed.length; i++) {
            result += diffBoxed[i];
        }

        System.out.println(result);
    }
}
