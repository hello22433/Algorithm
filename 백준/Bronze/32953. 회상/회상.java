import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int studentNum = sc.nextInt();
                map.put(studentNum, map.getOrDefault(studentNum, 0) + 1);
            }
        }


        int cnt = 0;
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() >= m) {
                cnt++;
            }
        }

        System.out.println(cnt);








    }
}