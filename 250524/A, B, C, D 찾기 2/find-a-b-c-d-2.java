import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list1.add(sc.nextInt());
        }
        Collections.sort(list1);
        // Please write your code here.

        for (int A = 1; A <= 40; A++) {
            for (int B = A; B <= 40; B++) {
                for (int C = B; C <= 40; C++) {
                    for (int D = C; D <= 40; D++) {
                        List<Integer> list2 = new ArrayList<>();
                        list2.addAll(Arrays.asList(A, B, C, D, A+B, B+C, C+D, D+A, A+C, B+D, A+B+C, A+B+D, A+C+D, B+C+D, A+B+C+D));
                        Collections.sort(list2);
                        if (list1.equals(list2)) {
                            System.out.print(A + " " + B + " " + C + " " + D);
                        }
                    }
                }
            }
        }


    }
}

// 