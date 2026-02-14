import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();

        String s = sc.nextLine().toUpperCase();

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';

            arr[idx]++;
        }

        int maxCnt = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > maxCnt) {
                result = (char) (i + 'A');
                maxCnt = arr[i];
            } else if (arr[i] == maxCnt) {
                result = '?';
            }
        }

        System.out.println(result);





    }
}