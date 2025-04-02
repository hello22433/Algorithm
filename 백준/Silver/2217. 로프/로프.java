

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Integer[] Aarr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(Aarr, (a,b) -> {
            return b-a;
        });
        arr = Arrays.stream(Aarr).mapToInt(Integer::intValue).toArray();


        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = arr[i] * (i+1);
            maxSum = Math.max(maxSum, sum);
        }

        System.out.print(maxSum);
    }
}

// 가장 낮은 중량을 고를 수 있다.
// 하지만 임의로 포기할 수도 있다.
// 포기하는게 나을 것인지?
// 아니면 도입하는게 나을 것인지를 판단해야 한다.
// how? 만약 1과 2와 3과 15라면 15만을 택하겠지.
// why? 다 더해도 15에 미치지 못하기 때문.
// 7일때 : 14
// 8일때 : 16
// 만약 8 14 15였다면?
// 8로 3개를 고를지 14 14 두개를 고를지!
// 가장 큰 값부터 하나씩 가져 가야 한다.
// 큰 값부터 탐색하면서 탐색한 수만큼의 해당 값들의 합이
// 그 이전 값보다 작거나 같다면 그 전 값을 출력한다.
// 만약 8 14 14 15 였다면?
// 만약 1(101개) 100이라면?