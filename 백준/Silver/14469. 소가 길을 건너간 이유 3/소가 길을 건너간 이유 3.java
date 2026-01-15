import java.util.*;
import java.io.*;

class Man {
    int arrivedTime;
    int checkTakenTime;

    Man(int arrivedTime, int checkTakenTime) {
        this.arrivedTime = arrivedTime;
        this.checkTakenTime = checkTakenTime;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Man[] men = new Man[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int arrivedTime = Integer.parseInt(st.nextToken());
            int checkTakenTime = Integer.parseInt(st.nextToken());

            Man newMan = new Man(arrivedTime, checkTakenTime);
            men[i] = newMan;
        }

        Arrays.sort(men, (a,b) -> {
            return a.arrivedTime-b.arrivedTime;
        });

        int totalTakenTime = men[0].arrivedTime + men[0].checkTakenTime;

        for (int i = 1; i < n; i++) {
            // 도착한 시간이 걸린시간의 미만이면 걸린시간의 바로 1시간 뒤에 진행하면 된다. (추가 1시간))
            // 이상이면? 만약 12에 끝나고, 12에 도착했다면, 13에 시작해야 한다.
            // 만약 13에 도착했다면? 14에 도착했다면? 도착시간에서 걸린시간을 빼고 진행하면 된다. (같다면 1시간 후에 시작해야 함)

            // -> 즉 '도착시간 <= 걸린시간' -> 걸린시간 + 1에 시작
            // 아니라면? 걸린시간 - 도착시간  -> 걸린시간 + (걸린시간-도착시간)에 시작
            if (men[i].arrivedTime <= totalTakenTime) {
//                totalTakenTime += 1;
            } else {
                totalTakenTime += men[i].arrivedTime - totalTakenTime;
            }
            totalTakenTime += men[i].checkTakenTime;

        }
        System.out.print(totalTakenTime);
    }
}