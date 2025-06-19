import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print(findNnum(n));
    }

    public static int findNnum(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        
        return findNnum(n-1) + findNnum(n/3);
    }
}

// n번째 수는 n-1