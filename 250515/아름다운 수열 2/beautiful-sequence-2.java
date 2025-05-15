import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++)
            list.add(sc.nextInt());
        // Please write your code here.
        
        int count = 0;
        for (int i = 0; i <= N-M; i++) {
            List<Integer> listCopy = new ArrayList<>(list);
            for (int j = i; j < i+M; j++) {
                if (listCopy.contains(A[j])) {
                    listCopy.remove(Integer.valueOf(A[j]));
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