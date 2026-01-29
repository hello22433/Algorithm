import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<>();
        int[] times = {4,6,4,10};



        for (int i = 0; i < n; i++) {


            for (int j = 0; j < 4; j++) {
                String[] list = sc.nextLine().split(" ");
                for (int k = 0; k < 7; k++) {
                    String l = list[k];
                    if (l.equals("-")) {continue;}
                    map.put(l, map.getOrDefault(l, 0) + times[j]);
                }
            }
        }

        int minSumTime = Integer.MAX_VALUE;
        int maxSumTime = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minSumTime = Math.min(entry.getValue(), minSumTime);
            maxSumTime = Math.max(entry.getValue(), maxSumTime);
        }

        if (maxSumTime - minSumTime > 12) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }






    }
}