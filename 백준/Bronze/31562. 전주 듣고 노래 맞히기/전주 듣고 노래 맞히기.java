import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();


        Map<String, Integer> map = new HashMap<>();
        Map<String, String> songMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");

            int len = Integer.parseInt(line[0]);
            String title = line[1];
            char[] song = new char[line.length-2];

            for (int j = 2; j < line.length; j++) {
                song[j-2] = line[j].charAt(0);
            }


            String str = new StringBuilder()
                    .append(song[0])
                    .append(song[1])
                    .append(song[2])
                    .toString();

            songMap.put(str, title);

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");

            String word = String.join("", line);



            if (map.containsKey(word) && map.get(word) > 1) {
                System.out.println("?");
            } else if (!map.containsKey(word)) {
                System.out.println("!");
            } else {
                System.out.println(songMap.get(word));
            }
        }





    }
}