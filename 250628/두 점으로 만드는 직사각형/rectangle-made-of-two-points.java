import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        System.out.print((Math.max(x2, a2) - Math.min(x1, a1)) * (Math.max(y2,b2) - Math.min(y1,b1)));
    }
}

// 문제
// 두 개의 점의 좌표가 '두 번' 주어짐
// 그 두 점으로 직사각형을 만듦
// 직사각형 왼쪽 하단, 직사각형 오른쪽 상단
// 가장 큰 y점, 가장 작은 y점
// 가큰 x점, 작 x점
// (끝x점 - 시작x점) * (끝Y점 - 시작y점)