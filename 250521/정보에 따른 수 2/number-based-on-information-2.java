import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[] line = new char[1001];
        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int pos = sc.nextInt();

            line[pos] = c;
        }
        // 1부터 1000까지
        int cnt = 0 ;
        for (int i = a; i <= b; i++) {
            
            int minDistanceD1 = Integer.MAX_VALUE;
            int minDistanceD2 = Integer.MAX_VALUE;

            for (int j = i; j < 1001; j++) {
                if (line[j] == 'S') {
                    minDistanceD1 = Math.min(minDistanceD1, j-i);
                } else if (line[j] == 'N') {
                    minDistanceD2 = Math.min(minDistanceD2, j-i);
                }
            }

            for (int j = i; j >= 1; j--) {
                if (line[j] == 'S') {
                    minDistanceD1 = Math.min(minDistanceD1, i-j);
                } else if (line[j] == 'N') {
                    minDistanceD2 = Math.min(minDistanceD2, i-j);
                }
            }

            if (minDistanceD1 <= minDistanceD2) cnt++;
        }

        System.out.print(cnt);
    }
}


// d1 <= d2  ->  k는 특별한 위치
// 일직선 상에 점을 하나씩 찍는다. (a~b)
// 