import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        int val = a * b * c;

        int sum = makeSum(val);

        System.out.print(sum);
    }

    public static int makeSum(int val) {
        if (val < 10) return val;

        return val%10 + makeSum(val / 10);
    }
}


// 1의 자리수와 1의 그 앞자리수들을 각각 모두 합친 것과 더한다.
// 앞자리 수가 한자리수만 남았을때 그 수를 반환한다.
// 