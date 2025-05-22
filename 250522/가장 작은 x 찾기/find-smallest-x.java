import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        // 만족하는 정수를 찾아볼 것이다.
        for (int i = 1; ; i++) {
            List<Integer> list = new ArrayList<>();
            int num = i;
            for (int j = 0; j <= 4; j++) {
                list.add(num);
                num *= 2;
            }

            boolean check = false;
            // 조건을 만족하는지 모든 조건을 돌려볼 것이다.
            for (int j = 0; j < n; j++) {
                check = false;
                // 모든 리스트에 대해서 조건을 만족하는 값이 있는지 찾아본다.
                for (int k = 0; k < list.size(); k++) {
                    if (a[j] <= list.get(k) && list.get(k) <= b[j]) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    break;
                }
            }
            
            if (check) {
                System.out.print(i);
                return;
            }
        }
    }
}

// 