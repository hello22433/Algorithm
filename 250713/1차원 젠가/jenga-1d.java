import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt()-1;
        int e1 = sc.nextInt()-1;
        int s2 = sc.nextInt()-1;
        int e2 = sc.nextInt()-1;

        int[] newBlocks = new int[n];
        int newBlocksIdx = 0;
        for (int i = 0; i < n; i++) {
            if (s1 > i || e1 < i) {
                newBlocks[newBlocksIdx++] = blocks[i];
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((s2 > i || e2 < i) && newBlocks[i] != 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
        for (int i = 0; i < n; i++) {
            if ((s2 > i || e2 < i) && newBlocks[i] != 0) {
                System.out.println(newBlocks[i]);
            }
        }
    }
}

// 문제
// 