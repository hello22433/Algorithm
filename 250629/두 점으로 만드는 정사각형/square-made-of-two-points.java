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

        System.out.print((int) Math.pow(Math.max((Math.max(Math.max(x1,x2), Math.max(a1,a2)) - Math.min(Math.min(x1,x2), Math.min(a1,a2)))
                         ,(Math.max(Math.max(y1,y2), Math.max(b1,b2)) - Math.min(Math.min(y1,y2), Math.min(b1,b2)))), 2));
    }
}

// 문제
// 좌표평면 위에 두 개의 점이 두 번 주어짐
// 그 두점으로 직사각형으로 만든다.
// 왼쪽하단, 오른쪽상단
// 가장 작은 x와 가장큰 x, 가장작은 y와 가장 큰 y
// 