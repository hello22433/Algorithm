import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();

        String s = sc.nextLine();

        outer : for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < s.length(); j++) {
                if ((char) i == s.charAt(j)) {
                    System.out.print(j + " ");
                    continue outer;
                }
            }
            System.out.print(-1 + " ");

        }






    }
}