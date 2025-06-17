import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int sum = makeSum(n);
        System.out.print(sum);
        
    }

    public static int makeSum(int n) {
        if (n == 1) return n;
        
        return makeSum(n-1) + n;
    }
}