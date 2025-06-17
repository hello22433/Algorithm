import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int[] arr = calculFun(a, b);
        System.out.print(arr[0] + " " + arr[1]);
    }

    public static int[] calculFun(int a, int b) {
        if (a > b) {
            a += 25;
            b *= 2;
        } else {
            b += 25;
            a *= 2;
        }
        return new int[]{a, b};
    }
}

// class IntegerValue {
//     private int val;

//     IntegerValue(int val) {
//         this.val = val;
//     }
// }