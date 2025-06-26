import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] sortedArr = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(sortedArr);
        int first = sortedArr[0];
        int second = 101;
        boolean isFindOnlyOneSecond = false;
        outer : for (int i = 1; i < N; i++) {
            // 첫 번째와 동일하지 아니한 값이 세컨드 (오름차순 정렬 했으므로)
            if (first != sortedArr[i]) {
                second = sortedArr[i];

                // 세컨드개 두개 있는지 i다음 부터 찾을 것이다. 
                for (int j = i+1; j < N; j++) {
                    // 세컨드와 같은 값을 발견하면 false인 상태로 출력문이 있는 밖으로 넘어간다.
                    if (sortedArr[j] == second) {
                        break outer;
                    }
                }
                // 발견 못하면 isFindSecond=true
                isFindOnlyOneSecond = true;
                break;
            }
        }

        if (isFindOnlyOneSecond) {
            for (int i = 0; i < N; i++) {
                if (arr[i] == second) {
                    System.out.print(i+1);
                }
            }
        } else {
            System.out.print(-1);
        }
    }
}

// 문제
// N개의 수 중, 두 번째로 작은 수의 위치를 출력
// 인덱스는 1-based임

// 이해
// 같은 수가 있을 수 있음 -> 모든 수가 같을 수 있음 -> 2번째로 작은 수가 없을 수 있음 -> -1 출력
// 정렬한다.
// 1번째수(인덱스로 0)를 저장한다.
// 2번째부터 반복문을 도는데 1번째 수와 다르면 해당 수의 위치를 출력한다 (i+1)
// 아니라면 -1 출력
// 