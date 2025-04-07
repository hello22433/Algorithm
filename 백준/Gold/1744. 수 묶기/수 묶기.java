

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        long result = 0;
        int bucket = 0;
        int iStore = -1;
        Arrays.sort(arr);
        for (int i = N-1; i >= 0; i--) {
            if (arr[i] < 2) {
                iStore = i;
                result += bucket;
                bucket = 0;
                break;
            }

            if (bucket == 0) {
                bucket += arr[i];
            } else {
                bucket *= arr[i];
                result += bucket;
                bucket = 0;
            }
        }

        for (int i = 0; i <= iStore; i++) {
            if (arr[i] == 1) {
                result += arr[i];
            } else {
                if (bucket == 0) {
                    bucket += arr[i];
                } else {
                    bucket *= arr[i];
                    result += bucket;
                    bucket = 0;
                }
            }
        }

        result += bucket;
        System.out.print(result);
    }
}

// 큰수끼리 최대한 많이 곱해야 한다.
// 음수는 절대값이 가장 큰 값끼리 많이 곱해야 한다. 짝이 없으면 0과 곱하거나 냅두기.
// 1은 냅둔다.
// 내림차순으로 하여 곱해나간다.
// 만약 1, 0, 음수값이 나오면 곱하고 더하는 반복을 멈춘다.
// 1일 경우는 그냥 더한다.
// 0일 경우와 음수값인 경우는 반대에서부터 멈춘 지점까지 탐색하며 곱해 더해나간다.
// 음수값이 연속으로 나오면 곱해서 더하고 (0까지) 홀수로 남았다면 그냥 더한다.