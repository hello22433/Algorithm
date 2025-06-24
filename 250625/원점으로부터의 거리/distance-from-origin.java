import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i] = new Point(i+1, x, y, Math.abs(x)+Math.abs(y));
        }
        // Please write your code here.
        Arrays.sort(points);
        
        for (int i = 0; i < n; i++) 
            System.out.println(points[i].num);
        
    }
}

class Point implements Comparable<Point> {
    int num;
    int x;
    int y;
    int distanceFromZero;

    Point(int num, int x, int y, int distanceFromZero) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.distanceFromZero = distanceFromZero;
    }

    @Override
    public int compareTo(Point point) {
        if (this.distanceFromZero == point.distanceFromZero) {
            return this.num - point.num;
        }
        return this.distanceFromZero - point.distanceFromZero;
    }
}

// 문제 : 
// 2차 평면 위에 N개의 점
// 1번부터 N번까지 2차 평면에 랜덤으로 주어짐
// 원점에서 가까운 점부터 순서대로 출력
// 거리가 같은 점이 여러 개인 경우 번호가 작은 점부터 출력
// 거리 = 멘하턴 거리
// 

// 이해 :
// x더하기 y값이 멘하턴 거리가 된다(원점이 기준이기 때문)
// i+1(번호) 와 함께 멘하턴 거리와 클래스로 묶어 배열에 넣는다.
// 배열을 멘하턴 거리로 오름차순 배열한다.
// 거리가 같은 경우 번호 순으로 오름차순 배열한다.
// 출력한다.

// 구현 :
// 거리이기 때문에 절대값 처리가 들어가야 한다.