import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                q.add(sc.nextInt());
            } else if (cmd.equals("pop")) {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                if (!q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (cmd.equals("front")) {
                if (!q.isEmpty()) {
                    System.out.println(q.peek());
                } else {
                    System.out.println(-1);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println(q.getLast());
                } else {
                    System.out.println(-1);
                }
            }
        }








    }
}