import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = n-1; i >= 0; i--) {
            bottom[i] = sc.nextInt();
        }

        for (int a = 0; a < t; a++) {
            int topLast = top[n-1];
            int bottomFirst = bottom[0];

            for (int i = n-1; i >= 1; i--) {
                top[i] = top[i-1];
            }

            for (int i = 0; i < n-1; i++) {
                bottom[i] = bottom[i+1];
            }

            top[0] = bottomFirst;
            bottom[n-1] = topLast;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for (int i = n-1; i >= 0; i--) {
            System.out.print(bottom[i] + " ");
        }
    }
}

// 문제
// 1행은 오른쪾으로 밀고, 2행은 왼쪽으로 밀어야 한다.
// 다만 1행의 마지막 값은 2행의 마지막 값으로, 
// 2행의 첫번째 값은 1행의 첫번째 값으로 와야 한다.
//
// 미리 마지막 값들을 저장해놓는다.
// 첫째행을 밀고 둘째행을 민다.
// 그리고 첫째행의 첫번째에 저장하고, 둘째행의 마지막에 저장한다. 
// 이를 t번 반복한다.