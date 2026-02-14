import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int total = 0;
        for (int i = 0; i < b; i++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            int sum = c*d;
            total += sum;
        }
        System.out.print(total == a ? "Yes" : "No");
    }

}