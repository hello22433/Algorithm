import java.util.Scanner;
public class Main {
    static int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        if (isExistDay(y, m, d)) {
            String season = calSeason(m);
            System.out.print(season);
        } else {
            System.out.print(-1);
        }
    }

    public static boolean isExistDay(int y, int m, int d) {
        if (isYoonNyeon(y)) daysOfMonth[2] = 29;
        else daysOfMonth[2] = 28;

        if (m <= 12 && d <= daysOfMonth[m]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isYoonNyeon(int y) {
        if (y % 4 != 0) {
            return false;
        }
        if (y % 100 == 0 && y % 400 != 0) {
            return false;
        }
        return true;
    }

    public static String calSeason(int m) {
        if (m <= 2 || m == 12) {
            return "Winter";
        } else if (m <= 5) {
            return "Spring";
        } else if (m <= 8) {
            return "Summer";
        } else {
            return "Fall";
        } 
    }
}


