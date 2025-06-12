import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int N = 0;
        while (true) {

            if (A.equals(B)) {
                System.out.print(N);
                break;
            }

            if (N == A.length()-1){
                System.out.print(-1);
                break;
            }

            N++;
            A = A.substring(A.length()-1) + A.substring(0,A.length()-1);
        }
    }
}

