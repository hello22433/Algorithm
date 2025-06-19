import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        int result = findLCM(n-1, arr);
        System.out.print(result);
    }

    public static int findLCM(int n, int[] arr) {
        if (n==0) return arr[n];

        return calLCM(arr[n], findLCM(n-1, arr));
    }

    public static int calLCM(int arrn, int preLCM) {
        int GCD = 1;
        
        for (int i = 2; i <= Math.min(arrn, preLCM); i++) {
            while ((arrn % i == 0) && (preLCM % i == 0)) {
                arrn /= i;
                preLCM /= i;
                GCD *= i;
            }
        }

        return GCD * arrn * preLCM;
    }

    
}

// n과 n-1개의 것들의 최소공배수와 비교하여 최소공배수를 구한다.
// n이 0에 도달하면 arr[0]을 반납한다. 
// 리턴값은 최소공배수가 되어야 하므로 0인덱스수 말고는 (마지막수는 그자체가 최소공배수이므로 이론 성립)
// n-1번째까지의 최소공배수와 n번째의 arr의 수의 최소공배수를 찾아야 한다. (함수 이용)
// 계속 최소공배수를 리턴한다. 마지막에는 최종 최소공배수가 리턴된다.