
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<Integer> arr = new HashSet<>();
        for (int i = 0; i < M; i++) {
            arr.add(sc.nextInt());
        }
        min = Math.min(min, Math.abs(100-N));

        for (int i = 0; i <= 1000000; i++) {
            String iStr = Integer.toString(i);

            for (int j = 0; j < iStr.length(); j++) {
                if (arr.contains(Character.getNumericValue(iStr.charAt(j)))) {
                    break;
                }
                if (j == iStr.length() - 1) {
                    min = Math.min(min, Math.abs(i - N) + iStr.length());
                }
            }

        }

        System.out.println(min);

    }
}




// 100부터 시작!
// +-로 최솟값을 구할 수 있는지 확인
// N