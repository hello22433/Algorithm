import java.util.Scanner;
public class Main {

    static int n;
    static int[] x;
    static int[] y;

    static int XLineX1 = -1;
    static int XLineX2 = -1;
    static int XLineY = -1;

    static int YLineX = -1;
    static int YLineY1 = -1;
    static int YLineY2 = -1;

    public static boolean checkXLine(int i, int j, int k) {
        if (y[i] == y[j]) {
            XLineX1 = x[i];
            XLineX2 = x[j];
            XLineY = y[i];
        } else if (y[i] == y[k]) {
            XLineX1 = x[i];
            XLineX2 = x[k];
            XLineY = y[i];
        } else if (y[j] == y[k]) {
            XLineX1 = x[j];
            XLineX2 = x[k];
            XLineY = y[j];
        } else {
            return false;
        }
        return true;
    }
    
    public static boolean checkYLine(int i, int j, int k) {
        if (x[i] == x[j]) {
            YLineY1 = y[i];
            YLineY2 = y[j];
            YLineX = x[i];
        } else if (x[i] == x[k]) {
            YLineY1 = y[i];
            YLineY2 = y[k];
            YLineX = x[i];
        } else if (x[j] == x[k]) {
            YLineY1 = y[j];
            YLineY2 = y[k];
            YLineX = x[j];
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int maxExtent = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (checkXLine(i, j ,k) && checkYLine(i, j, k)) {
                        maxExtent = Math.max(maxExtent, Math.abs(YLineY2-YLineY1) * Math.abs(XLineX2-XLineX1)); 
                    }
                }
            }
        }

        System.out.print(maxExtent);
    }
}


// x축평행==y값이 같아야 함 , y축평행==x값이 같아야 함
// 최대 넓이 * 2
// 
// 점을 세 개 고른다
// x축평행==y값이 같아야 함 , y축평행==x값이 같아야 함
// 조건을 만족하면 넓이를 구하여 2를 곱한후 최대넓이를 갱신한다.