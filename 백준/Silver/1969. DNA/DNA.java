
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        String[] DNAS = new String[N];
        for (int i = 0; i < N; i++) {
            DNAS[i] = sc.nextLine();
        }

        int distance = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int[] ACGT = new int[4];
            for (int j = 0; j < N; j++) {
                switch (DNAS[j].charAt(i)) {
                    case 'A':
                        ACGT[0]++;
                        break;
                    case 'C':
                        ACGT[1]++;
                        break;
                    case 'G':
                        ACGT[2]++;
                        break;
                    case 'T':
                        ACGT[3]++;
                        break;
                }
            }

            int weight = Integer.MIN_VALUE;
            String bucketStr = "";
            for (int k = 0; k < 4; k++) {
                if (weight < ACGT[k]) {
                    weight = ACGT[k];
                    switch (k) {
                        case 0:
                            bucketStr = "A";
                            break;
                        case 1:
                            bucketStr = "C";
                            break;
                        case 2:
                            bucketStr = "G";
                            break;
                        case 3:
                            bucketStr = "T";
                            break;
                    }
                }
            }
            distance += N - weight;
            sb.append(bucketStr);
        }

        System.out.println(sb.toString());
        System.out.println(distance);
        // 0~M을 돈다. DNAS를 돈다.
        // A일때 [0]에 1더하기. 1,2,3 순서대로!
        // 가중치가 같다면 무시한다. 즉 현재값보다 낮을 때만 인정 (사전순으로 작은걸 출력해야하기 떄문, 그래서 ACGT순 인덱스)
        // 가장 큰 가중치를 가진 문자를 sb에 더한다.
    }
}
