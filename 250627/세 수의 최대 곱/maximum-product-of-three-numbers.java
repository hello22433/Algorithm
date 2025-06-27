import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(arr, Collections.reverseOrder());

        if (arr[0] < 0) {
            System.out.print(arr[0] * arr[1] * arr[2]);
        } else {
            System.out.print(Math.max(arr[0] * arr[1] * arr[2],
                                      arr[0] * arr[arr.length-1] * arr[arr.length-2]));
        }
    }
}


// 문제
// 정수 N과 N개의 수.

// 요구사항
// 3개의 수를 적절하게 골라 나올 수 있는 곱 중 '최대값'을 구해라

// 이해
// 음수끼리
// 양수끼리
// 음수가 나올 수도 있음. -> 절대값이 작아야 함
// 
// 양수가 나오는 경우와 음수가 나오는 경우를 나눠서 풀어야 한다.
// 내림차순으로 정렬한다.
// 가장 절대값이 큰 것끼리 곱했을 때 양수가 나오거나 음수가 나올 것이다. 양수가 나오면 그대로 답이고,
// 음수가 나오면? 양수가 나올 떄까지 찾아야지. 그 경우의 수가 많지는 않을 것이다. 
// 애초에 내림차순을 했는데 음수가 나온다는 것은 음수의 근처에 있다는 것이고
// 양수가 나오는 경우의 수 : 양수끼리 곱한 값이 가장 클 것인가? 아닐 수 있음 -> 가장 큰 양수와 마지막 두 개의 음수를 곱한 값 중 뭐가 클 것인가
// 음수가 나오는 경우의 수 : 음수가 하나(앞 두 개는 양수)-> 이 경우는, 맨 앞과 마지막 두 개의 음수를 곱해야 한다. 
//                     음수가 세 개(그럼 뒤에 모두가 음수) -> 이 경우는 이 세개를 모두 곱한게 답
// 
// 음수를 곱했을때의 절대값이 가장 큰것과 양수를 하나 곱해서 제일 큰 값을 만들 수도 있다. 
// 

// 구현
// 3개의 수를 적절하게 고른다 -> 곱을 구한다. -> 최대값 갱신한다. 