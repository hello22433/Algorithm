import java.util.Scanner;
public class Main {
    static int n1;
    static int n2;
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        a = new int[n1];
        b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        // Please write your code here.

        boolean check = false;
        for (int i = 0; i < n1 - (n2-1); i++) {
            if (isContinuousSubsequenceAIdx(i)) {
                check = true;
                break;
            }
        }
        
        if (check) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    public static boolean isContinuousSubsequenceAIdx(int aIdx) {
        for (int i = 0; i < n2; i++) {
            if (a[aIdx + i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}


// a를 시작점을 정해 돌면서 b개만큼 뽑는다. 
// 