import java.util.*;

public class Main {
    static int maxCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.

        Arrays.sort(segments, (a,b) -> {
            return a[1] - b[1];
        });

        int curEndPoint = segments[0][1];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (segments[i][0] > curEndPoint) {
                cnt++;
                curEndPoint = segments[i][1];
            }
        }
        System.out.print(cnt);
    }
}




// N개의 선분
// 서로 겹치지 않고 가장 많이 골라야 한다.
// 끝점 공유도 겹친 것임!

// 개수 N
// N줄에 걸쳐, 각 선분의 정보 
// 
// 조합으로 골라야 한다. (순서는 상관 x)
// A의 시작점이 B의 끝점보다 커야 한다. 
// 또는 A의 끝점이 B의 시작점보다 작아야 한다.  <=> B의 시작점이 A의 끝점보다 커야 한다. 


// 몇 개를 고르던, 일단 골랐으면 겹치지 않는 선분이 최대 몇 개인지 체크하고 최대값을 갱신한다.
// 

// 끝점에 따라 오름차순하고 앞에서부터 고르면 최대값이 아니겠는가?