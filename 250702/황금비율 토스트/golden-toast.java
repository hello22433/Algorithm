import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> list = new LinkedList<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        
        ListIterator<Character> it = list.listIterator(list.size());
        for (int i = 0; i < m; i++) {
            char cmd = sc.next().charAt(0);

            if (cmd == 'L') {
                if (it.hasPrevious()) {
                    it.previous();
                }
            } else if (cmd == 'R') {
                if (it.hasNext()) {
                    it.next();
                }
            } else if (cmd == 'D') {
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            } else if (cmd == 'P') {
                char addCh = sc.next().charAt(0);
                it.add(addCh);
            }
        }

        it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        
        // Please write your code here.
    }
}

// 문제
// 