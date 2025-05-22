import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        // Please write your code here.

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            if (seat.charAt(i) == '1') continue;

            int minDistance = Integer.MAX_VALUE;

            int distance = 1;
            for (int j = 1; j < n; j++) {
                if (seat.charAt(j) == '1' || i==j) {
                    minDistance = Math.min(minDistance, distance);
                    distance = 1;
                } else {
                    distance++;
                }
            }

            result = Math.max(result, minDistance);
        }
        System.out.print(result);
    }
}

// 문자열을 탐색하면서 0이 아니면 continue
// 0이면 해당 자리에 1을 넣는다고 가정하고 
// j로 i를 지나치면서 처음부터 다시 탐색,
// 1을 만나면 거리를 1으로 초기화한다. 
// 0을 만나면 거리+=1 
// i를 만나면 거리를 최소값 갱신한다. break;
// 반대로 마지막에서 시작하고 1을 만나면 거리를 1으로 초기화하고, 0을 만나면 +=1
// i를 만나면 거리를 최소값 갱신한다.
// 최소값들을 최대값 갱신한다.