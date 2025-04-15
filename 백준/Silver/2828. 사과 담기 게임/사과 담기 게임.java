
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // N M j j만큼사과가떨어지는위치k
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int j = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int left = 1;
        int right = 1 + (M-1);
        int result = 0;
        for (int i = 0; i < j; i++) {
            int fallLocation = sc.nextInt();
            int preLeft = left;

            if (left<=fallLocation && fallLocation<=right) {
                continue;
            } else if (left > fallLocation) {
                right -= left - fallLocation;
                left -= left - fallLocation;
            } else if (right < fallLocation) {
                left += fallLocation - right;
                right += fallLocation - right;
            }

            left = Math.max(1, left);
            if (left == 1) {
                right = Math.min(N, 1 + (M-1));
            }
            right = Math.min(N, right);
            if (right == N) {
                left = Math.max(1, N - (M-1));
            }

            result += Math.abs(preLeft - left);
        }

        System.out.println(result);

        // 처음위치 1
        // 떨어지는 사과가 바구니의 끝에 걸쳐야 한다.
        // 사과가 오른쪽에 있으면 오른쪽끝에 왼쪽에 있으면 왼쪽끝에 걸쳐야 한다.
        // 초기값(인덱스+1 기준) : 오른쪽끝을 1+(m-1)으로 갱신한다. 왼쪽끝은 1이다.
        // 길이가 2이고 떨어지는 위치가 3이면 (초기값1) 1을 가야한다.
        // 오른쪽 끝이 2이기 때문이다.
        // 즉, '떨어지는 위치 - 오른쪽 위치' 만큼 가면 된다.
        // 만약 떨어지는 위치가 왼쪽끝보다 크거나같고 오른쪽위치보다 크거나 같으면 움직이지 않는다.
        // 왼쪽끝보다 작으면 '왼쪽위치 - 떨어지는위치' 만큼 오른쪽,왼쪽에서 뺀다.
        // 오른쪽끝보다 크면 '떨어지는위치 - 오른쪽끝위치' 만큼 오른쪽,왼쪽에서 뺀다.
        // 뺀 값만큼 이동 거리를 더한다.
    }
}
