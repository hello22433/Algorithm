
import java.util.*;

public class Main {
    static int[] arr;
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < 9; i++) {
            List<Integer> sumList = new ArrayList<>();
            sumList.add(arr[i]);
            dfs(i, 1, 0, sumList);
        }

        Collections.sort(resultList);
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }

    }

    private static void dfs(int i, int count, int sum, List<Integer> list) {
        sum += arr[i];
        if (count == 7) {
            if (sum == 100) {
                resultList = new ArrayList<>(list);
                return;
            } else {
                return;
            }
        }

        for (int j = i+1; j < arr.length; j++) {
            List<Integer> sumList = new ArrayList<>(list);
            sumList.add(arr[j]);
            dfs(j, count+1, sum, sumList);
        }
    }
}

// 아홉난쟁이의 키가 주어진다.
// 합이 100이 되는 일곱난쟁이의 키를 오름차순으로 출력한다.
// 모든 경우의 수를 더해본다.
//