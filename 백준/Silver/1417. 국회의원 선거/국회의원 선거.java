
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            return b-a;
        });

        int first = scanner.nextInt();
        for (int i = 1; i < N; i++) {
            queue.add(scanner.nextInt());
        }
        if (queue.size() == 0) {
            System.out.println(0);
            return;
        }

        int count = 0;
        while (queue.peek() >= first) {
            int poller = queue.poll();
            int adder = poller - 1;
            queue.add(adder);
            first += 1;
            count += 1;
        }
        System.out.println(count);
    }
}


// 다른 모든 수에서 값을 흡수하여 1번을 제일 크게 만들어야 한다.
// 현재 가장 큰수에서 1씩 가져온다.
// 처음 수를 저장하고 큰수에서 1씩 빼서 큐에 넣을 때마다
// 처음 저장한 값에 1씩 더한다. 동시에 카운트를 한다.
// 큐에서 저장한 값이 나오면 카운트를 출력한다.
//