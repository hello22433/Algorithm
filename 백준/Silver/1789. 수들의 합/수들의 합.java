
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        for (long i = 1; ; i++) {
            if (N < i) {
                System.out.println(i-1);
                break;
            }
            N -= i;
        }

    }
}