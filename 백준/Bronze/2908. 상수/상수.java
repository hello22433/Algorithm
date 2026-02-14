import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
//        int c = sc.nextInt();

        StringBuilder sa = new StringBuilder(String.valueOf(a));
        StringBuilder sb = new StringBuilder(String.valueOf(b));

        System.out.println(Math.max(Integer.parseInt(sa.reverse().toString()), Integer.parseInt(sb.reverse().toString())));
        


    }
}