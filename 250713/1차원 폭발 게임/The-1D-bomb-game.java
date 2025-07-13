import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        // Please write your code here.

        boolean existBooms = true;

        outer : while (existBooms) {
            existBooms = false;

            int firstBombVal = bombs[0];
            int equalCnt = 1;
            int startIdx = 0;
            
            for (int i = 1; i < n; i++) {
                if (firstBombVal != bombs[i]) {

                    if (equalCnt >= m) {
                        // 터뜨리고 중력으로 내린다.
                        int[] bucket = new int[n];
                        int bucketIdx = 0;
                        for (int j = 0; j < n; j++) {
                            if ((j < startIdx || j > i-1) && bombs[j] != 0)
                            bucket[bucketIdx++] = bombs[j];
                        }
                        for (int j = 0; j < n; j++) {
                            bombs[j] = bucket[j];
                        }

                        existBooms = true;
                    }
                
                    firstBombVal = bombs[i];
                    equalCnt = 1;
                    startIdx = i;
                    
                } else {
                    equalCnt++;
                }

            }
        }


        int resultCnt = 0;
        for (int i = 0; i < n; i++) {
            if (bombs[i] != 0) resultCnt++;
        }
        System.out.println(resultCnt);
        for (int i = 0; i < n; i++) {
            if (bombs[i] != 0)
                System.out.println(bombs[i]);
        }
    }
}

// N개 폭탄 중, M개가 연속이상이면 터진다. (연결된 모든 게 같은 수가 터져야 한다.)
// 
// 터지는게 없을 때까지 반복한다.