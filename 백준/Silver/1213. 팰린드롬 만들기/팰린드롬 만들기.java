

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int inputLength = input.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < inputLength; i++) {
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }

        ArrayList<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (a,b) -> {
            return a.getKey().compareTo(b.getKey());
        });

        List<Integer> list = new ArrayList<>(map.values());
        Character[] mapList = new Character[inputLength];
        if (inputLength % 2 == 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 != 0) {
                    System.out.print("I'm Sorry Hansoo");
                    return;
                }
            }
            int iIdx = 0;
            for (Map.Entry<Character, Integer> entry : entryList) {
                int value = entry.getValue();
                Character key = entry.getKey();
                while(value > 0) {
                    mapList[iIdx] = key;
                    mapList[mapList.length-iIdx-1] = key;
                    iIdx++;
                    value -= 2;
                }
            }


        } else {
            int holsooCount = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 != 0) {
                    ++holsooCount;
                }
            }
            if (holsooCount != 1) {
                System.out.print("I'm Sorry Hansoo");
                return;
            }

            int iIdx = 0;
            char lastChar = 0;
            for (Map.Entry<Character, Integer> entry : entryList) {
                int value = entry.getValue();
                Character key = entry.getKey();
                while(value > 0) {
                    if (value == 1) {
                        lastChar = key;
                        break;
                    }
                    mapList[iIdx] = key;
                    mapList[mapList.length-iIdx-1] = key;
                    iIdx++;
                    value -= 2;

                }
            }
            mapList[iIdx] = lastChar;
        }

        StringBuilder sb = new StringBuilder();
        for (Character key : mapList) {
            sb.append(key);
        }
        System.out.println(sb.toString());
    }
}

// 양쪽을 대칭으로 만들어야 한다.
// 각 문자의 수를 카운트한다.

// 전체문장의 수가 짝수이고
// 각 문자가 모두 짝수이어야 함.

// 전체문장의 수가 홀수이고
// 하나의 홀수 + 짝수

// 만약 전체수가 짝수일 때, 하나라도 짝수가 아니면 cut!
// 만약 전체수가 홀수일 때, 하나라도 하나 빼고 짝수가 아니면 cut! 하나의 홀수가 없으면 cut!

// 맵을 키로 정렬
// 양쪽으로 하나씩 넣는다.
// 밸류를 보고 양쪾으로 넣는다.