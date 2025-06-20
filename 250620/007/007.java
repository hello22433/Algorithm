import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode = sc.next();
        char mPoint = sc.next().charAt(0);
        int time = sc.nextInt();

        ZeroZeroSeven unit = new ZeroZeroSeven(sCode, mPoint, time);

        System.out.printf("secret code : %s\nmeeting point : %c\ntime : %d", unit.sCode, unit.mPoint, unit.time);
    }
}

class ZeroZeroSeven {
    String sCode;
    char mPoint;
    int time;

    ZeroZeroSeven(String sCode, char mPoint, int time) {
        this.sCode = sCode;
        this.mPoint = mPoint;
        this.time = time;
    }
}