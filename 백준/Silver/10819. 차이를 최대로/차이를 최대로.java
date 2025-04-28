
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, new LinkedList<>());
        System.out.println(max);
    }

    private static void dfs(int count, LinkedList<Integer> list) {
        if (count == N) {
            max = Math.max(max, calculate(list));
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> copyList = new LinkedList<>(list);
            if (!visited[i]) {
                visited[i] = true;
                copyList.add(arr[i]);
                dfs(count + 1, copyList);
                visited[i] = false;
            }
        }
    }

    private static int calculate(LinkedList<Integer> list) {
        int first = list.get(0);
        int second = list.get(1);
        int bucket = Math.abs(first - second);

        for (int i = 2; i < list.size(); i++) {
            first = second;
            second = list.get(i);
            bucket += Math.abs(first - second);
        }

        return bucket;
    }
}


