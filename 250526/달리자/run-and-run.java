import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        // Please write your code here.


        int cost = 0;
        for (int i = 0; i < n-1; i++) {
            if (b[i] - a[i] > 0) {
                a[i+1] -= Math.abs(b[i] - a[i]);
            } else if (b[i] - a[i] < 0){
                a[i+1] += Math.abs(b[i] - a[i]);
            }
            cost += Math.abs(b[i] - a[i]);
        }
        System.out.print(cost);
    }
}

// 2 4 4 0
// 가장 가까운 곳에서 받아와야 한다.
// B-A
// 비용이 양수면 그 만큼을 뒤나 앞에서 빌려와야 한다는 뜻이다.
// 그럼 그 다음 수에 -비용 한다. 동시에 비용을 누적한다. 
// 음수면 다음으로 넘치는 수를 넘긴다는 뜻이다. 다음 수에 더한다.