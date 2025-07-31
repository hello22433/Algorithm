import java.util.Scanner;
public class Main {

    static int[] memorization;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memorization = new int[n+1];
        // Please write your code here.

        System.out.print(fibonachi(n));
    }

    public static int fibonachi(int n) {

        if (n == 1 || n == 2) return 1;
        else if (memorization[n] != 0) return memorization[n];
        else memorization[n] = fibonachi(n-1) + fibonachi(n-2);

        return memorization[n];
    }
}


// import java.util.*;

// public class Main {
//     static int[] fibonachi;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         fibonachi = new int[n+1];
//         // Please write your code here.
//         if (n == 1 || n == 2) {
//             System.out.print(1);
//             return;
//         }
        
//         fibonachi[1] = 1;
//         fibonachi[2] = 1;

//         for (int i = 3; i <= n; i++) {
//             fibonachi[i] = fibonachi[i-2] + fibonachi[i-1];
//         }
        
//         System.out.print(fibonachi[n]);
//     }
// }