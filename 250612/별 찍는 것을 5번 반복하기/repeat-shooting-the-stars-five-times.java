import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            printTenStarts();
        }
    }

    public static void printTenStarts() {
        for (int i = 0; i < 10; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

