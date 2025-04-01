
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(reader.readLine());

        for (int i =0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += sum + arr[i];
            sum += arr[i];
        }

        System.out.print(result);
    }
}

// 앞에 가장 작은 시간이 와야 한다. 왜냐하면 앞의 수가 누적되기 때문
// 배열을 만들어 오름차순으로 배열한다.
// 구간합의 배열의 값을 모두 더한다.
// 아니면! 배열을 순회하면서 누적합을 만든다.
// 결과값에 누적합과 현재 값을 더한다.
// 이후 누적합에 현재 값을 더한다.
