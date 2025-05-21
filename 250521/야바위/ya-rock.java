import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 1; i < 4; i++) {
            boolean[] cup = new boolean[4];
            cup[i] = true;

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                boolean temp = cup[b[j]];
                cup[b[j]] = cup[a[j]];
                cup[a[j]] = temp;

                if (cup[c[j]]) cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.print(maxCnt);
    }
}

// 어디에 넣어야 가장 높은 점수?
// 1,2,3 중에 하나에 넣는다. 
// 종이컵 상태는 유지되어야 한다.
// 종이컵을 어떻게 구현하여 위치를 바꾸고 오픈할 것인가?
// cup[4]
// cup[1] [2] [3] 
// tmp = cup[b[i]]
// cup[b[i]] = cup[a[i]]
// cup[a[i]] = tmp
// if cup[c[i]]