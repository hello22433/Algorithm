

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > sum + 1) {
                break;
            }
            sum += arr[i];
        }

        System.out.println(sum+1);
        
    }
}

// 모든 부분집합을 구해놓을 수는 없다.
// 오름차순으로 하여 하나씩 탐색한다.
// sum은 0이 초깃값
// 추가되는 값이 sum+1보다 작아야 함.
// 왜냐하면 그 전값들은 1부터 더해오면서 그 전값들을 모두 부분집합으로 만들 수 있는 수들임
// 즉 sum까지의 수들은 모두 만들 수 있음
// 그러니 새로운 수가 SUM+1를 초과하면 Summ+1을 만들 수 없으니 빈공간이 생기게 됨.
// 이는 오름차순이기 때문에 벌어지는 일임

