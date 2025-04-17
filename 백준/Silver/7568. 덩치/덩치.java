
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] weights = new int[N];
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }


        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) {continue;}
                if (weights[i] < weights[j] && heights[i] < heights[j]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}

// x kg, y cm, 두 개 모두 다 커야 덩치가 크다고 본다
// K명이 덩치가 더 큼 -> 본인은 K+1등
// 서로가 크다고 할 수 없을 때는 같은 등수로 보며, 다음 등수가 사라진다. (공동 등수)
// 몸무게로 내림차순 정렬
// 후에 키를 비교하면 된다.
// 앞의 키가 뒤의 키보다 작다면 동일 등수를 부여한다. count라고 한다.
// 만약 앞의 키가 뒤의 키보다 크다면 ++count 후에 등수를 부여한다.
//