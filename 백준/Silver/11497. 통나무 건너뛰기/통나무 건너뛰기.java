import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list);

            int result = 0;
            for (int j = 2; j < list.size(); j++) {
                result = Math.max(result, list.get(j) - list.get(j-2));
            }
            System.out.println(result);

            list.clear();
        }
    }
}

// 앞뒤가 연결되기때문에 단순히 오름/내림차순으로는 안된다.
// 지그재그 놓기 (산처럼 놓기)로 하면 맨 앞과 맨 뒤의 차가 적어질 수 있다.
//