import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCnt = 0;
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String a = sc.next();

            if (a.equals("0")) break;

            inputCnt++;
            list.add(a);
        }

        System.out.println(inputCnt);
        for (int i = 0; i < list.size(); i++) {
            if (i%2==0) System.out.println(list.get(i));
        }
    }
}

