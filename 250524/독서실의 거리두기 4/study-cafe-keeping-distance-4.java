import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        // Please write your code here.


        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (seat.charAt(i) == '1') continue;
            for (int j = i+1; j < n; j++) {
                if (seat.charAt(i) == '1') continue;
                
                int minDist = Integer.MAX_VALUE;
                boolean isFirstOne = false;
                int dist = 1;
                for (int k = 0; k < n; k++) {
                    // 1이 나올때까지 기다린다. 1이 나오면 거리를 1로 초기화한다.
                    // 
                    if (isFirstOne) {
                        if (seat.charAt(k) == '1' || k == i || k == j) {
                            minDist = Math.min(minDist, dist);
                            dist = 1;
                        } else {
                            dist++;
                        }
                    } else {
                        if (seat.charAt(k) == '1') {
                            isFirstOne = true;
                        }
                    }
                }
                if (minDist == Integer.MAX_VALUE) minDist = 0;
                maxDist = Math.max(maxDist, minDist);

            }
        }
        System.out.print(maxDist);
    }
}


// 