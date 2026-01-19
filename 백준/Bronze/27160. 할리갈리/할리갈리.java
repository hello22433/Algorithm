import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] numAndCard = sc.nextLine().split(" ");
            String card = numAndCard[0];
            int num = Integer.parseInt(numAndCard[1]);

            map.put(card, map.getOrDefault(card, 0) + num);
        }
        
        for (int cnt : map.values()) {
            if (cnt == 5) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");

    }
}