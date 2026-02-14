import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();

        String s = sc.nextLine().toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c  : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1) ;
        }

        int max = 0;
        Character result = '?';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue() ;
                result = entry.getKey();
            } else if (entry.getValue() == max) {
                result = '?';
            }
        }

        System.out.println(result);





    }
}