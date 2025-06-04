import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < n1-(n2-1); i++) {
            boolean check = true;
            for (int j = 0; j < n2; j++) {
                if (arr1[i+j] != arr2[j]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print("Yes");
                return;
            }
        }


        System.out.print("No");
    }
}
