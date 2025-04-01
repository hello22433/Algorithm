

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] bucket = new int[2];
            bucket[0] = Integer.parseInt(st.nextToken());
            bucket[1] = Integer.parseInt(st.nextToken());
            arr[i] = bucket;
        }

        Arrays.sort(arr, (a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });


        int end = -1;
        int result = 0;
        for (int i = 0; i < N; i++) {
            int arrStart = arr[i][0];
            int arrEnd = arr[i][1];
            if (end <= arrStart) {
                end = arrEnd;
                result++;
            }
        }
        System.out.print(result);
    }
}

// 가장 빨리 끝나는 회의를 넣어야 한다.
// 그렇기에 끝나는 시간을 기준으로 오름차순 배열을 한다.
// 탐색한다. 끝값을 저장하는 변수를 만든다. 초깃값은 -1으로 한다.
// 만약 끝값변수보다 배열값의 시작값이 더 크거나 같으면 끝값변수에 배열값의 끝값을 넣는다. 그리고 카운트+1
//
