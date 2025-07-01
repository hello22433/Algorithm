import java.util.Scanner;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            
            if (cmd.equals("push_front")) {
                int A = sc.nextInt();
                list.addFirst(A);
            } else if (cmd.equals("push_back")) {
                int A = sc.nextInt();
                list.addLast(A);
            } else if (cmd.equals("pop_front")) {
                System.out.println(list.pollFirst());
            } else if (cmd.equals("pop_back")) {
                System.out.println(list.pollLast());
            } else if (cmd.equals("size")) {
                System.out.println(list.size());
            } else if (cmd.equals("empty")) {
                System.out.println(list.isEmpty() ? 1 : 0);
            } else if (cmd.equals("front")) {
                System.out.println(list.peekFirst());
            } else if (cmd.equals("back")) {
                System.out.println(list.peekLast());
            }
        }
    }
}