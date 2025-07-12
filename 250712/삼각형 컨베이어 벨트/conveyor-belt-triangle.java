import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = n-1; i >= 0; i--) {
            d[i] = sc.nextInt();
        }


        for (int a = 0; a < t; a++) {
            int lLast = l[n-1];
            int rLast = r[n-1];
            int dFirst = d[0];

            for (int i = n-1; i >= 1; i--) {
                l[i] = l[i-1]; 
            }

            for (int i = n-1; i >= 1; i--) {
                r[i] = r[i-1]; 
            }

            for (int i = 0; i < n-1; i++) {
                d[i] = d[i+1]; 
            }

            r[0] = lLast;
            d[n-1] = rLast;
            l[0] = dFirst;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(l[i] +" ");
        }
            System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(r[i] +" ");
        }

            System.out.println();

        for (int i = n-1; i >= 0; i--) {
            System.out.print(d[i] +" ");
        }
       
    }
}

// 문제
// 

// 이해
// l은 오른쪾으로 한 칸, r도 오른쪽으로 한칸, d는 왼쪾으로 한칸
// l의 마지막은 r의 첫번째로
// r의 마지막은 d의 마지막으로
// d의 첫번째는 l의 처음으로