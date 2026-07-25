import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> jq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
            // 나중에 요청시간이 같은 경우가 있을 수도 있으므로 한 번에 다 뺴는걸 고려해야한다.
        });
        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            jq.offer(new int[]{job[0], job[1], i});
        }
        
        PriorityQueue<int[]> wq = new PriorityQueue<>((a,b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });
        // for (int i = 0; i < jobs.length; i++) {
        //     int[] job = jobs[i];
        //     pq.offer(new int[]{job[0], job[1], i});
        // }
        
        int curTime = -1;
        
        // 하드디스크에 들어간 작업은 실제시작시간0과 소요시간1과 요청시간2이 있어야한다.(왜냐하면 현시간 - 시작시간 = 소요시간 이면 끝나는 시간이기 때문, 또한 현재시간 - 요청시간 으로 반환 시간을 구하는 값을 구해야하기 때문)
        Deque<int[]> hardDisk = new ArrayDeque<>(); 
        while (!jq.isEmpty() || !wq.isEmpty() || !hardDisk.isEmpty()) {
            curTime++;
            
            // jq에 있는 현시간이 요청시간인 모든 건들을 대기큐에 넣는다.
            while (!jq.isEmpty() && jq.peek()[0] == curTime) {
                wq.offer(jq.poll());
            }
            
            // 디스크컨트롤러 -> 하드디스크 작업x && 대기큐 not isEmpty -> 우선순위높은작업 하드디스크에 시킴
            // 마치는 시점 ^ 들어오는 시점 -> 바로 대기큐에 저장한 다음에 우선순위 높은걸 하드디스크에 시킴 (즉, 작업끝났는지체크 (-> 작업들어오는거 검사 ->) 작업시킴 (!! 체크하고 검사하고 시키고 시작하는 것에 있어서는 시간이 하나도 들지 않는다.) )
            // 작업 소요시간이 1초 이므로 작업이 시작됨과 동시에 끝나는 경우는 존재하지 않으므로 시키고 나서는 작업이 끝남을 체크하지 않아도 된다.
            // 작업이 끝나는 시점 : 현시점 - 시작시점 이 작업시간이 되는 시점
            // 반환시간 : 종료시간 - 요청시간
            // 반환시간의 평균 : 작업 반환시간 합 / 작업수
            if (!hardDisk.isEmpty() && curTime - hardDisk.peek()[1] == hardDisk.peek()[0]) {
                int[] pollerJob = hardDisk.poll();
                answer += curTime - pollerJob[2];
            } 
            if (hardDisk.isEmpty() && !wq.isEmpty()) {
                int[] pollerJob = wq.poll();
                hardDisk.offer(new int[]{curTime, pollerJob[1], pollerJob[0]});
            }
        }
        
        // 상태기반? 이벤트기반? -> 소요시간의 최대가 1000 * 500 = 500,000 이기에 상태기반으로 쓰면 쓰지않는 메모리가 많을 것이다. 왜냐하면 작업은 하나씩만 돌아가기 때문이다. 그러므로 이벤트 기반이 메모리를 덜잡아먹는다. 
        
        // 대기큐인 pq에 값을 넣을 것인데.. 한번에 다 넣으면 정렬은 되겠지만, 현재 시간에 적절한 요청된 작업들을 파악할 수가 없다. 그러므로 주어진 작업들을 요청시간 오름차순으로 정렬할 최소힙이 하나 더 필요하다. peek을 보면서 현재 시간에 맞으면 대기큐에 넣는 방식을 사용한다. 
        
        
        return answer / jobs.length;
    }
}

// 하나에 한 작업, 작업 마칠 떄까지
// 대기큐 - 작업번호, 요청시각, 소요시간 
// 우선순위연산 : 소요시간 짧음[1] -> 요청시간빠름[0] -> 작업번호작음[i]
// 디스크컨트롤러 -> 하드디스크 작업x && 대기큐 not isEmpty -> 우선순위높은작업 하드디스크에 시킴
// 마치는 시점 ^ 들어오는 시점 -> 바로 대기큐에 저장한 다음에 우선순위 높은걸 하드디스크에 시킴 (즉, 작업끝났는지체크 -> 작업들어오는거 검사 -> 작업시킴 (!! 체크하고 검사하고 시키고 시작하는 것에 있어서는 시간이 하나도 들지 않는다.) )
// 작업이 끝나는 시점 : 현시점 - 시작시점 이 작업시간이 되는 시점
// 반환시간 : 종료시간 - 요청시간
// 반환시간의 평균 : 작업 반환시간 합 / 작업수
// jobs : [작업이요청되는시점, 작업의 소요시간]
// 반환정답 : 반환시간의 평균의 정수부분
// 