import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int speed = 1;
        int distance = 0;
        int time = 0;

        while (distance < x) {
            distance += speed;
            time++;

            int nextMoveCurrentSpeed = speed * (speed+1) / 2;
            int nextMovePlusSpeed = (speed+1) * (speed+2) / 2;

            if (distance + nextMovePlusSpeed <= x) {
                speed++;
            } else if (distance + nextMoveCurrentSpeed <= x) {
                speed = speed;
            } else {
                speed--;
            }
        }

        System.out.print(time);

    }
}

// 언제부터 속도를 줄여야 하는가?
// 끝에 속도를 1로 맞춰야 하므로 
// 현재 속력을 설정하고 달린다.
// 
// 