import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        // int[] B = new int[M];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++)
            // B[i] = sc.nextInt();
            set.add(sc.nextInt());
        // Please write your code here.
        
        int count = 0;
        for (int i = 0; i <= N-M; i++) {
            Set<Integer> setCopy = new HashSet<>(set);
            for (int j = i; j < i+M; j++) {
                if (setCopy.contains(A[j])) {
                    setCopy.remove(A[j]);
                } else {
                    break;
                }
                if (j == i+M-1) count++;
            }
        }

        System.out.print(count);
    }
}

// 