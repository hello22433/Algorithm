import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String uCode = sc.next();
        char lColor = sc.next().charAt(0);
        int time = sc.nextInt();
        // Please write your code here.
        
        BoomClearInformation unit = new BoomClearInformation(uCode, lColor, time);

        System.out.printf("code : %s\ncolor : %c\nsecond : %d", unit.uCode, unit.lColor, unit.time);
    }
}

class BoomClearInformation {
    String uCode;
    char lColor;
    int time;

    BoomClearInformation(String uCode, char lColor, int time) {
        this.uCode = uCode;
        this.lColor = lColor;
        this.time = time;
    }
}