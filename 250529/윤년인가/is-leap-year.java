import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        if (s %4 == 0 && !(s%100 && s%400!=0)) {
            System.out.print("true");
        }
        else {
            System.out.print("false");
        }
    }
}
