import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int A = sc.nextInt();
                q.add(A);
            } else if (cmd.equals("pop")) {
                System.out.println(q.poll());
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("front")) {
                System.out.println(q.peek());
            }
        } 
    }
}