

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = line.length()-1; j >= 0; j--) {
                char ch = line.charAt(j);
                map.put(ch, (int) (map.getOrDefault(ch, 0) + Math.pow(10, (line.length()-1-j))));
            }
        }

        List<Integer> weights = new ArrayList<>(map.values());
        weights.sort((a,b) -> b-a);
        int ans = 0;
        int number = 9;
        for (int weight : weights) {
            ans += weight * number;
            number--;
        }

        System.out.print(ans);

    }
}

// 각 단어마다 돌면서 각 문자마다 가중치를 더한다.
// 이를 맵에다가 저장한다.
// 이후 맵을 돌면서 모두 더한다.