import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = sc.nextInt();
        }

        // 서로 마주보는 면의 인덱스
        int[][] opposite = {{0,5}, {1,4}, {2,3}};

        // 가장 작은 한면
        int min1 = Arrays.stream(dice).min().getAsInt();

        // 인접한 두 면의 최소 합 구하기
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                if (!isOpposite(i,j)) {
                    min2 = Math.min(min2, dice[i] + dice[j]);
                }
            }
        }

        // 인접한 세 면의 최소 합 구하기
        int min3 = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (i == j || j == k || k == i) continue;
                    if (!isOpposite(i, j) && !isOpposite(j, k) && !isOpposite(k, i)) {
                        min3 = Math.min(min3, dice[i] + dice[j] + dice[k]);
                    }
                }
            }
        }
        
        if (N==1) {
            // 가장 큰 수를 제외한 나머지 합 출력
            int sum = Arrays.stream(dice).sum() - Arrays.stream(dice).max().getAsInt();
            System.out.println(sum);
        } else {
            long count3 = 4;
            // (N-2)*4  + (N-1)*4
            long count2 = 8 * N - 12; 
            // (N-2)(N-2) + 4(N-2)(N-1)
            long count1 = 5 * N * N - 16 * N + 12;
            
            long total = count3 * min3 + count2 * min2 + count1 * min1;
            System.out.println(total);
        }

    }

    private static boolean isOpposite(int i, int j) {
        return (i==0 && j==5) || (i==5 && j==0)
                || (i==1 && j==4) || (i==4 && j==1)
                || (i==2 && j==3) || (i==3 && j==2);
    }
}