import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int AMath = sc.nextInt();
        int AEng = sc.nextInt();
        int BMath = sc.nextInt();
        int BEng = sc.nextInt();

        if (AMath > BMath && AEng > BEng) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}