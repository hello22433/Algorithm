import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push_front")) {
                int A = sc.nextInt();

                dq.addFirst(A);
            } else if (cmd.equals("push_back")) {
                int A = sc.nextInt();

                dq.addLast(A);
            } else if (cmd.equals("pop_front")) {
                System.out.println(dq.pollFirst());
                
            } else if (cmd.equals("pop_back")) {
                System.out.println(dq.pollLast());
            } else if (cmd.equals("size")) {
                System.out.println(dq.size());
            } else if (cmd.equals("empty")) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("front")) {
                System.out.println(dq.peekFirst());
            } else if (cmd.equals("back")) {
                System.out.println(dq.peekLast());
                
            }
        }
    }
}