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
                        // 중복되는 부분 0으로 만든다.
                        for (int j = startIdx; j < i; j++) {
                            bombs[j] = 0;
                        }
                        existBooms = true;
                    }

                    // 배열 확인용
                    // for (int j = 0; j < n; j++) {
                    //     System.out.println(bombs[j]);
                    // }
                    //     System.out.println();
                
                    firstBombVal = bombs[i];
                    equalCnt = 1;
                    startIdx = i;
                    
                } else {
                    equalCnt++;
                }
            }

            // 마지막은 따로 처리
            if (equalCnt >= m) {
                // 중복되는 부분 0으로 만든다.
                for (int i = startIdx; i < n; i++) {
                    bombs[i] = 0;
                }
            }

            // 0으로 만든 부분들 동시에 다 터뜨리고 중력으로 내림
            int[] bucket = new int[n];
            int bucketIdx = 0;
            for (int i = 0; i < n; i++) {
                if (bombs[i] != 0)
                bucket[bucketIdx++] = bombs[i];
            }
            for (int i = 0; i < n; i++) {
                bombs[i] = bucket[i];
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