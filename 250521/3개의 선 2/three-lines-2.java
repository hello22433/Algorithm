import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.

        if (n <= 3) {
            System.out.print(1);
            return;
        }
 
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int YLine1 = x[i];
                    int XLine1 = y[i];
                    int YLine2 = x[j];
                    int XLine2 = y[j];
                    int YLine3 = x[k];
                    int XLine3 = y[k];

                    int[] whatLine = {YLine1, XLine1, YLine2, XLine2, YLine3, XLine3};
                    
                    for (int a = 0; a < 2; a++) {
                        for (int b = 2; b < 4; b++) {
                            for (int c = 4; c < 6; c++) {
                                Set<Integer> xSet = new HashSet<>();
                                Set<Integer> ySet = new HashSet<>();

                                if (a % 2 == 0) {
                                    xSet.add(whatLine[a]);
                                } else {
                                    ySet.add(whatLine[a]);
                                }

                                if (b % 2 == 0) {
                                    xSet.add(whatLine[b]);
                                } else {
                                    ySet.add(whatLine[b]);
                                }

                                if (c % 2 == 0) {
                                    xSet.add(whatLine[c]);
                                } else {
                                    ySet.add(whatLine[c]);
                                }

                                if ((xSet.contains(x[i]) || ySet.contains(y[i])) && (xSet.contains(x[j]) || ySet.contains(y[j])) && (xSet.contains(x[k]) || ySet.contains(y[k]))) {
                                    System.out.print(1);
                                    return;
                                }
                            }
                        }
                    }
                    

                }
            }
        }


        System.out.print(0);
    }
}

// 점마다 x,y축을 나눠 선을 놓아본다.
//
// 점을 세 개 고른다
// 점마다 선을 놓는다. 
// 선마다 xy를 바꿔본다 (int XLine = y, int YLine = x)
// 다른 점들의 y값이 Xline과 일치하거나 x값이 YLine과 일치하면 count
// 모두 일치하면 정답이므로 출력하고 리턴.

// 모든 점들이 직선에 포함되는지 확인한다.
// 