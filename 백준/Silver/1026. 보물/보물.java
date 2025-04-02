
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] a = sc.nextLine().split(" ");
        Integer[] integerA = Arrays.stream(a).map((x)->Integer.parseInt(x)).toArray(Integer[]::new);
        Arrays.sort(integerA, (o1, o2) -> o2 - o1);
        int[] newA = Arrays.stream(integerA).mapToInt(Integer::intValue).toArray();

        String[] b = sc.nextLine().split(" ");
        Integer[] integerB = Arrays.stream(b).map((x)->Integer.parseInt(x)).toArray(Integer[]::new);
        Arrays.sort(integerB, (o1, o2) -> o1 - o2);
        int[] newB = Arrays.stream(integerB).mapToInt(Integer::intValue).toArray();


        int result = 0;
        for (int i = 0; i < N; i++) {
            result += newA[i] * newB[i];
        }

        System.out.println(result);


    }
}

// 큰수들과 작은수들의 곱의 합
// B는 바꿀 수 없으니 A의 값들을 정렬해야 한다.
// 사실 값만 출력하면 되는 것이니 반대로 정렬해서 각각의 값들을 곱해서 더하면 된다.