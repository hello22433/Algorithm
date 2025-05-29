import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aYN = sc.next();
        int a = sc.nextInt();
        String bYN = sc.next();
        int b = sc.nextInt();
        String cYN = sc.next();
        int c = sc.nextInt();

        Person[] arr= new Person[3];
        arr[0] = new Person(aYN, a);
        arr[1] = new Person(bYN, b);
        arr[2] = new Person(cYN, c);

        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].YN.equals("Y") && arr[i].t >= 37) {
                cnt++;
            } else if (arr[i].t >= 37) {
            } else if (arr[i].YN.equals("Y")) {
            } else {
            }
        }
        if (cnt >= 2) {
            System.out.print("E");
        } else {
            System.out.print("N");
        }

    }
}

class Person {
    String YN;
    int t;

    Person(String YN, int t) {
        this.YN = YN;
        this.t = t;
    }
}
