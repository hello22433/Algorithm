import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int t = sc.nextInt();

        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println(0);
        } else {

            System.out.print(s.split(" ").length);
        }






    }
}