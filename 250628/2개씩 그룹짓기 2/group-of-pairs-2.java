import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minDiff = Math.min(arr[n+i] - arr[i], minDiff);
        }
        System.out.print(minDiff);
    }
}
// 2 5 7 9 10 15 
// 문제
// 2 * N 개의 정수가 주어짐
// 겹치지 않으면서 2개의 원소가 하나의 그룹을 이루도록 함
// N개의 그룹 만들기
// 적절하게 그룹 만들어, 

// 요청사항
// 각 그룹 내에 있는 2개의 수의 차이 중
// 최솟값이 최대가 되도록 하라 
// => 수의 차이의 최솟값   이 최대
// 

// 이해
// 최대한 균등하게 차이가 큰 것들끼리 묶어야 한다.
// 오름차순으로 해서 
// 맨 앞과 맨 뒤를 엮고 순서대로 행해나간다.
// 이 중에 최솟값이 