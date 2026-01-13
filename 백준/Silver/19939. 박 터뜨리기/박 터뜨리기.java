import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // 최소 1개는 넣어야 하고, 모두 달라야 한다. 
        // 만약 이 조건을 만족시킬 수 없다면, -1을 출력한다. 
        if (n <= k) {
            System.out.print(-1);
            return;
        }

        // 가장큰수 하나가 올라감에 따라 다른 것들도 딸려 올라가야 한다.
        // 그렇게 되야 중복없이 연속적으로 올라가며 차이가 가장 작아진다.
        int[] buckets = new int[k];
        for (int i = 0; i < k; i++) {
            int num = i + 1;
            n -= num;
            if (n < 0) {
                System.out.print(-1);
                return;
            }
            buckets[i] = num;
        }

        outer : while (true) {
            for (int i = k-1; i >= 0; i--) {
                if (n == 0) {
                    break outer;
                }
                n -= 1;
                buckets[i] += 1;
            }
        }

        System.out.print(buckets[k-1] - buckets[0]);
    }
}