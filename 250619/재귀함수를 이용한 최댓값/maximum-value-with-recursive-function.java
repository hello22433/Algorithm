import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int maxVal = makeMaxValue(arr, n-1); // 인덱스는 n-1 부터 시작하므로

        System.out.print(maxVal);
    }

    public static int makeMaxValue(int[] arr, int n) {
        if (n == 0) {
            return arr[n];
        } 

        int maxVal = makeMaxValue(arr, n-1);

        return Math.max(maxVal, arr[n]);
    }
}

// n번째 원소와 n-1까지의 최댓값을 비교한다.
// 마지막 원소에 도달하면 마지막 원소 값을 출력한다. 그 전의 값을 타고 하나씩 비교하며 올라온다.
// 그러려면 다음인덱스를 넘겨주면서 마지막 인덱스가 되면 멈추면 된다.
// 리턴값은 최고갱신값, 