

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = sc.nextInt();
        }

        Set<Integer> socket = new HashSet<>();
        int count = 0;
        for (int i = 0; i < K; i++) {
            int nextInt = order[i];

            // 콘센트에 꽂혀있으면 다음으로 넘어감
            if (socket.contains(nextInt)) {
                continue;
            }
            // 콘센트가 비어있으면 그냥 꽂음
            if (socket.size() < N) {
                socket.add(nextInt);
                continue;
            }

            // 가장 먼 거리에 존재하는 기기와 인덱스
            int deviceToUnplug = -1;
            int deviceToUnplugIdx = -1;

            // 꽂혀있는 값들
            for (int divice : socket) {
                int nextUse = Integer.MAX_VALUE;
                // 앞으로 꽂아야 할 값
                for (int j = i + 1; j < K; j++) {
                    if (divice == order[j]) {
                        nextUse = j;
                        break;
                    }
                }

                // 아예 사용하지 않거나 거리가 먼 기기의 인덱스와 정보를 저장한다.
                if (nextUse > deviceToUnplugIdx) {
                    deviceToUnplugIdx = nextUse;
                    deviceToUnplug = divice;
                }
            }

            //
            socket.remove(deviceToUnplug);
            socket.add(nextInt);
            count++;

        }
        System.out.println(count);
    }
}

// 뒤에 쓰이면 안뽑는다. 더 가까이 있는걸 안뽑는게 좋으니 더 멀리 있는걸 뽑는다.
// 꽂혀있는 값들중에 앞으로 꽂아야 할 값이 얼마나 멀리 있는지 최대치 갱신
// 가장 멀리 있거나 꽂혀있지 않은 값을 마지막에 제거하고 현재값을 대입한다.
// 카운트를 올린다.