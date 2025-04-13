
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Integer[] crains = new Integer[N];
        for (int i = 0; i < N; i++) {
            crains[i] = scanner.nextInt();
        }
        Arrays.sort(crains, Collections.reverseOrder());

        int M = scanner.nextInt();
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            boxes.add(scanner.nextInt());
        }
        boxes.sort(Collections.reverseOrder());

        if (boxes.get(0) > crains[0]) {
            System.out.println(-1);
            return;
        }

        int count = 0;

        while (!boxes.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;
            
            while (craneIndex < N && boxIndex < boxes.size()) {
                if (crains[craneIndex] >= boxes.get(boxIndex)) {
                    boxes.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}


// 1분당 옮길 수 있는건 모두 옮길 것이다.
// 각 크레인이 옮길수 있는 최대값을 먼저 옮길것.
// 가장 무거운 걸 옮길 수 있는 크레인부터 가장 무거운 화물을 탐색하여 옮긴다.
// 만약 가장 무거운 크레인이 옮길 수 없으면 누구도 옮길 수 없으므로 끝낸다. -1출력.
// 크레인을 내림차순 배열에 넣고 탐색한다.
// 그 안에서 내림차순 짐을 하나씩 폴한다. (프라이올리티)
// 만약에 폴값이 크레인감당무게보다 작거나같으면 break;한다.

// 박스가 모두 소모될떄까지 실시한다. 각 실시 후에 count+1
// 크레인을 큐에 넣고 하나씩 뺀다.
// 박스를 큐에 넣고 하나씩 뺀다. 뺄때 초기값을 갱신한다. poll 후 peek값.
// 박스가 크레인보다 크면 박스를 다시 큐에다 넣는다. 작으면 넣지 않는다.
// 초기값이 peek값이면 멈춘다.