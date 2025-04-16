
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] books = new int[N+1];
        for (int i = 0; i < N; i++) {
            books[i] = sc.nextInt();
        }
        books[N] = 0;
        Arrays.sort(books);

        int zeroIndex = -1;
        for (int i = 0; i < N+1; i++) {
            if (books[i] == 0) {
                zeroIndex = i;
            }
        }

        int result = 0;
        int first = Math.abs(books[0]);
        int last = Math.abs(books[books.length - 1]);
        if (first > last) {
            // 처음부터 돈다.
            // 밸류값만큼 distance에 더한다.
            // 돌아가야 하니까 distance를 한 번 더 더한다. (i==0 일때는 더하지 않는다.)
            // k-1만큼 i에 더한다.
            // 0의 인덱스까지 돌릴것이다.
            // 만약 i + (k-1)이 0의 인덱스보다 크거나 같으면 멈춘다.
            // 이제 반대로 돌린다.
            for (int i = 0; i < zeroIndex; i++) {
                int book = books[i];
                result += Math.abs(book);

                if (i==0) {
                    i += K-1;
                    continue;
                }
                i += K-1;

                result += Math.abs(book);
            }
            for (int i = books.length -1; i > zeroIndex; i--) {
                int book = books[i];
                result += book;
                i -= K-1;
                result += book;
            }
        } else {
            for (int i = books.length -1; i > zeroIndex; i--) {
                int book = books[i];
                result += book;
                if (i==books.length -1) {
                    i -= K-1;
                    continue;
                }
                i -= K-1;
                result += book;
            }
            for (int i = 0; i < zeroIndex; i++) {
                int book = books[i];
                result += Math.abs(book);
                i += K-1;
                result += Math.abs(book);
            }
        }
        System.out.println(result);

    }
}

// N M
// 가장 많은 책을 들고 인접한 위치로 접근하는 것이 필요하다.
// 11 11 6 6 29 29 39
// 20 12 60 39
// 가장 가까운 곳부터 가야 한다. 왜냐하면 가장 먼 곳에 간 후에는 돌아올 필요가 없기 때문이다.
// 가장 먼 곳을 가는 것이 가까운 것을 가는 것에 영향을 미친다.
// 즉 먼 곳을 먼저 가야 함.
// 만약 가장 먼 곳을 가는데 해당 부호 중간에 아무것도 없다면?
// 그래도 가야 한다. 왜냐하면 어차피 가야 할 길이기 때문에.
// 그럼 절대값이 가장 큰 곳 하나를 먼저 간다.
// 그 값의 원래 부호 값과 0 사이에 있는 값들을 절대값이 큰 것 먼저 k만큼 없앤다.(제일 큰 값 포함)
// -와 +는 0을 중심을 두고 있기에 서로 관계가 없다. 즉, 독립적으로 움직인다.

