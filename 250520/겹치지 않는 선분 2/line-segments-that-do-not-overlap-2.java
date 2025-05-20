import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        boolean[] x = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((x1[i]-x1[j]<0 && x2[i]-x2[j]>0) || (x1[i]-x1[j]>0 && x2[i]-x2[j]<0)) {
                    if (!x[i]) {
                        count++;
                        x[i] = true;
                    }

                    if (!x[j]) {
                        count++;
                        x[j] = true;
                    }
                }
            }
        }

        System.out.print(count);
    }
}

// 시작점 차이와 끝점 차이의 부호가 달라야 한다.
// 두 선분씩 골라서 서로가 겹치는지 찾아본다.
// 