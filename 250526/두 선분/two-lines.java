import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int[] line = new int[101];
        // Please write your code here.


        // 각각의 점이 포함되려면?
        // 시작점이 다른점의 시작점보다 작은경우 -> 끝점이 시작점보다 크거나 같아야 한다.
        // 시작점이 다른점의 시작점보다 큰경우 -> 다른점의 끝점이 시작점보다 크거나 같아야 한다.
        // 시작점이 다른점의 시작점과 같은경우 -> 이미 겹친다.
        
        // 기준의 선을 정한다.

        for (int i = x1; i <= x2; i++) {
            line[i]++;
        }
        for (int i = x3; i <= x4; i++) {
            line[i]++;
        }

        for (int i = 0; i < 101; i++) {
            if (line[i] == 2) {
                System.out.print("intersecting");
                return;
            }
        }
        System.out.print("nonintersecting");
    }
}

// 