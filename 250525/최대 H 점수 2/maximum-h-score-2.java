import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // Please write your code here.

        for (int H = n; H >= 0; H--) {

            int haveCost = l;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] < H) {
                    if (haveCost > 0) {
                        if (a[i]+1 >= H) {
                            cnt++;
                            haveCost--;
                        }
                    }
                } else {
                    cnt++;
                }

                if (i == n-1 && cnt >= H) {
                    System.out.print(H);
                    return;
                }
            }
        }
    }
}

// L개를 어떻게 고를 것인가? 코스트화한다.
// H는 0부터 100까지이다. 그러나 최대값은 N으로 하면 된다.
// H를 N부터 가정해서 0까지 내려온다.
// a를 순회한다.
// a[i]가 H보다 작으면 
// 코스트가 있으면 +1해보고(코스트-1) 그래도 작으면 넘어간다. 크면 CNT++ haveCost--
// 크면 CNT++
// 만약 끝까지 다 돌고 CNT가 H이상이면 H를 출력한다.