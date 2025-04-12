
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            q.add(sc.nextInt());
        }

        while (!q.isEmpty() && L >= q.peek()) {
            q.poll();
            L += 1;
        }

        System.out.println(L);
    }
}


// 과일개수N, 초기길이L
// 최소힙에 넣고 하나씩 뺀다. first >= poll
// 뺄때마다 1씩 first += 1
// first출력