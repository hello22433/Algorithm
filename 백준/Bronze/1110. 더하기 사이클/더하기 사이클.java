import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int first = a;
//        int b = sc.nextInt();
//        int c = sc.nextInt();
        int cnt = 0;

        do {
            int sum = a / 10 + a % 10;
            a = (a % 10)*10 + (sum % 10);
            cnt++;
        } while (first != a);

        System.out.println(cnt);

    }

}