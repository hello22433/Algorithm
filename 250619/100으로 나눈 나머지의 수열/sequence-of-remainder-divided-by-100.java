import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        System.out.print(findNnum(n));
    }

    public static int findNnum(int n) {
        if (n==1) return 2;
        if (n==2) return 4;

        return findNnum(n-1) * findNnum(n-2) % 100;
    }
}

// n 번째 수는 n-1과 n-2를 곱하여 100으로 나눈 나머지이다.
// 