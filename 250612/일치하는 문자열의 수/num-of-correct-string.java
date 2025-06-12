import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String A = sc.next();

        int sameCnt = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();

            if (A.equals(str)) {
                sameCnt++;
            }
        }
        System.out.print(sameCnt);
    }
}

