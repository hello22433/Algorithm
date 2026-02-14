import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();

        for (int i = 0; i < a; i++) {
            String s = sc.next();
            int seq = 0;
            int score = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    seq++;
                    score += seq;
                } else {
                    seq = 0;
                }
            }
            System.out.println(score);
        }




    }

}