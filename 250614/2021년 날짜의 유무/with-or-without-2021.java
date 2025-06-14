import java.util.Scanner;
public class Main {
    static int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();

        if (isExistDay(m, d)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    public static boolean isExistDay(int m, int d) {
        if (m <= 12) {
            if (d <= daysOfMonth[m]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}



// 0 31 28 31 30 31 30 31 31 30 31 30 31
// M이 <=12 && M에 따라 daysOfMonth(M) >= D 이면 true