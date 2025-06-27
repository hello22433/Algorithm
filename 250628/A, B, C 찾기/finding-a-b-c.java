import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.print(arr[0] + " " + arr[1] + " " + (arr[6]-(arr[0]+arr[1])));
        // Please write your code here.
    }
}

// 문제
// A <= B <= C 만족하는 정수 A,B,C 구하여라
// A,B,C, A+B, B+C, C+A, A+B+C 랜덤하게 주어짐
// 요청사항
// A,B,C 구하여라

// 이해
// 최댓값 : A+B+C
// 최소값 : A
// 최대값에서 최소값을 빼면 B+C
// 두 세번째로 작은 값들이 B,C NO! 작은 값 두 개를 더한 값이 C보다 작을 수 있음!
// A+B , C+A 에서 A를 빼면 B, C