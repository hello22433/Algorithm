import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int p = sc.nextInt();
        char[] c = new char[M+1];
        int[] u = new int[M+1];
        for (int i = 1; i <= M; i++) {
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }
        // Please write your code here.

        if (u[p] == 0) {
            System.out.print("");
            return;
        }
        Set<Character> set = new HashSet<>();

        for (int i = p; i <= M; i++) {
            set.add(c[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (!set.contains((char) (i + 64))) {
                System.out.print((char) (i+64) + " ");
            }
        }
        
    }
}


// 65를 더하면 알파벳 대문자 출력
// p