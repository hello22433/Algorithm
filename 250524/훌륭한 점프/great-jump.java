import java.util.Scanner;
public class Main {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minValue = Integer.MAX_VALUE;
        for (int a = 100; a >= Math.max(arr[0], arr[n-1]); a--) {
            if (isPossible(a)) {
                minValue = Math.min(minValue, a);
            }
        }

        System.out.print(minValue);
    }

    public static boolean isPossible(int a) {
        // a가 최대값이다.
        // a보다 작은 값들만 배열에 인덱스를 저장한다.
        // 저장된 값(인덱스)의 차이를 계산하여 k보다 크면 false
        int[] availableIdx = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= a) {
                availableIdx[cnt++] = i;
            }
        }

        for (int i = 1; i < cnt; i++) {
            int dist = availableIdx[i] - availableIdx[i-1];
            if (dist > k) return false;
        }

        return true;
    }
}

// 최대값이 최소가 되어야 한다.
// 최대값을 하나씩 지정한다.
// 