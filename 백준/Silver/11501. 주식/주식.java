

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int Days = sc.nextInt();
            sc.nextLine();
            String[] days = new String[Days];
            days = sc.nextLine().split(" ");

            int max = 0;
            long bucket = 0;
            long result = 0;
            for (int j = days.length-1; j >= 0; j--) {
                if (max < Integer.parseInt(days[j])) {
                    max = Integer.parseInt(days[j]);
                    result += bucket;
                    bucket = 0;
                } else {
                    bucket += max - Integer.parseInt(days[j]);
                }
            }
            result += bucket;
            System.out.println(result);
        }
    }
}

// 낮은 값에 산다.
// 비싼 값에 판다.
// 뒤에 지금 값curValue보다 비싼 값이 있으면 산다.
// 없으면 지금 가진 것을 모두 판다.ValueStore
// 반대로 돌려서 뒤에서부터 앞으로 간다.
// 뒤에서부터 처리하면 앞의 것을 싼 값이 나오는 순간 사면된다.
// 반대로 비싼 값이 나오면 팔면된다.
//

