import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    // 0부터 100까지
                    int[] line = new int[101];
                    for (int l = 0; l < n; l++) {
                        if (l==i || l==j || l==k) continue;

                        for (int q = a[l]; q <= b[l]; q++) {
                            line[q] += 1;
                        }
                    }
                    boolean DuplicateCheck = false;
                    for (int l = 0; l < 101; l++) {
                        if (line[l] > 1) {
                            DuplicateCheck = true;
                            break;
                        }
                    }
                    if (!DuplicateCheck) {
                        cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}


// 3개를 제거한다. 