import java.util.*;

public class Main {

    static Sep[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] p = new int[n];
        arr = new Sep[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            p[i] = sc.nextInt();

            arr[i] = new Sep(s[i], e[i], p[i]);
        }

        int[] dp = new int[n];

        Arrays.sort(arr, (a,b) -> a.s - b.s);

        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i].p;

            for (int j = 0; j < i; j++) {
                
                if (arr[j].e < arr[i].s)
                    dp[i] = Math.max(dp[i], arr[i].p + dp[j]);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }

        System.out.print(maxVal);
    }
}

class Sep {
    int s;
    int e;
    int p;

    Sep() {

    }

    Sep(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }
}


// N개 알바 정보, 
// 적절하게 알바 선택
// 일하는 기간이 겹치지 않게 하라
// 2개 이상의 알바를 하는 것은 불가능
// 
// 겹치지 않게 하면서 돈이 최대
// 
// dp[i] : i를 마지막으로 할 때의 벌 수 있는 최대 돈
// 