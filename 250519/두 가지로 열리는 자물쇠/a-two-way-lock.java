import java.util.Scanner;

public class Main {
    static int n;

    static int calDistance(int i, int a) {
        int differ = Math.abs(i - a);
        return Math.min(differ, Math.abs(n - differ));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        // Please write your code here.

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // 만약 N이면 0으로 취급
                    // 0이면 N으로 취급
                    // n이 10이고 i가 9이면, 2를 더해서 1이 된다. 
                    // 차가 2보다 클때, i가 n && a가 2이거나 i가 n-1 && a가 1이면 마이너스 값을 -1로 바꾼다.
                    // int iMinusA = Math.abs(i - a);
                    // int jMinusB = Math.abs(j - b);
                    // int kMinusC = Math.abs(k - c);
                    // int iMinusA2 = Math.abs(i - a2);
                    // int jMinusB2 = Math.abs(j - b2);
                    // int kMinusC2 = Math.abs(k - c2);
                    // if (iMinusA>2) if((i==n && (a==2 || a== 1)) || (i==n-1 && a==1) || (a==n && (i==2 || i== 1)) || (a==n-1 && i==1)) iMinusA = 1;
                    // if (jMinusB>2) if((j==n && (b==2 || b== 1)) || (j==n-1 && b==1) || (b==n && (j==2 || j== 1)) || (b==n-1 && j==1)) jMinusB = 1;
                    // if (kMinusC>2) if((k==n && (c==2 || c== 1)) || (k==n-1 && c==1) || (c==n && (k==2 || k== 1)) || (c==n-1 && k==1)) kMinusC = 1;
                    // if (iMinusA2>2) if((i==n && (a2==2 || a2== 1)) || (i==n-1 && a2==1) || (a2==n && (i==2 || i== 1)) || (a2==n-1 && i==1)) iMinusA2 = 1;
                    // if (jMinusB2>2) if((j==n && (b2==2 || b2== 1)) || (j==n-1 && b2==1) || (b2==n && (j==2 || j== 1)) || (b2==n-1 && j==1)) jMinusB2 = 1;
                    // if (kMinusC2>2) if((k==n && (c2==2 || c2== 1)) || (k==n-1 && c2==1) || (c2==n && (k==2 || k== 1)) || (c2==n-1 && k==1)) kMinusC2 = 1;

                    // if ((iMinusA<=2 && jMinusB<=2 && kMinusC<=2) || (iMinusA2<=2 && jMinusB2<=2 && kMinusC2<=2)) {
                    //     count++;
                    // }

                    if ((calDistance(i,a)<=2 && calDistance(j,b)<=2 && calDistance(k,c)<=2)
                        || (calDistance(i,a2)<=2 && calDistance(j,b2)<=2 && calDistance(k,c2)<=2)) 
                        count++;
                }
            }
        }
        System.out.print(count);
    }
}

// 모든 자리에 대해 첫 번째 조합과 거리가 2이내, 모든 자리에 대해 두번 째 조합과 거리가 2 이내
// 