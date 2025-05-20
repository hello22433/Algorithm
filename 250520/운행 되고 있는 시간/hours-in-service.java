import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            
            // 1시간부터 1000시간까지
            int[] line = new int[1001];
            for (int j = 0; j < N; j++) {
                if (i == j) continue; // 한 명(i)를 제외하고 라인에 운행 시간을 표시함.

                for (int k = A[j]; k < B[j]; k++) {
                    line[k] = 1;
                }
            }

            int count = 0;
            for (int j = 0; j < line.length; j++) {
                if (line[j] != 0) count++;
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.print(maxCount);
    }
}


// 한 명 해고 -> 운행 되고 있는 시간이 최대
// 