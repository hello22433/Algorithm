import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2];

        int mm = 2;
        int nCopy = n;
        while (arr[1] == 0) {
            if (nCopy % 5 == 0 && nCopy >= 5) {
                if (arr[0] == 0) {
                    arr[0] = nCopy;
                } else {
                    arr[1] = nCopy;
                }
            } else {

            }
            System.out.print(nCopy + " ");
            nCopy = n * mm++;
        }
    }
}
