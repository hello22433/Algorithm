import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        if (a+1 == b && b+1 == c) {
            System.out.print(0);
            return;
        }

        if (Math.abs(a-b) < Math.abs(b-c)) {
            System.out.print(Math.abs(c - b)/2 + 1);
        } else {
            System.out.print(Math.abs(b - a)/2 + 1);
        }
    }
}

// 문제
// 3명의 사람이 일직선 위에 서있음
// 양 끝쪽 한 명을 선택해 남은 두 사람 사이로 넣는다.

// 요구사항
// 세 사람이 서 있는 위치(순서)가 연속이 되도록 '최대 이동 횟수'를 구하라

// 이해
// 중간에 있는 사람과 중간과 가장 가까이 있는 사람이 
// 중간의 값보다 1크거나(왼쪽에 있을 경우) 1작게 들어가야 한다.(오른쪽에 있을 경우)
// 

// 해결
// 왼쪽과 오른쪽 중에 어디가 더 차이가 적은지 구한다
// 차이가 더 적은 쪽을 정하면, 차이가 더 큰쪽과 중간 값의 차의 1을 뺀다.
// 