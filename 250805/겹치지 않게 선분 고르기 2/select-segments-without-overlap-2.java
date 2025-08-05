import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        // int[] line = new int[1001];

        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        Arrays.sort(segments, (a,b) -> a[1]-b[1]);

        int selectLine = 1;

        int curEndPoint = segments[0][1];

        for (int i = 1; i < n; i++) {
            if (segments[i][0] > curEndPoint) {
                curEndPoint = segments[i][1];
                selectLine++;
            }
        }

        System.out.print(selectLine);
    }
}


// N개의 선분
// 겹치지 않게 가장 많은 수의 선분을 고르시오.
// 끝점 공유 : 겹친 것

// 
// 끝점을 기준으로 오름차순 정렬한다.
// 처음부터 고르면서, 만약 시작점이 현재 끝점을 초과하면 끝점을 갱신하고, 
// 선분 수를 +1 한다.
// 