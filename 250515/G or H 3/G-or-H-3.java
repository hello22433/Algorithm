import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            // 1번부터 n번까지 있음.
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            people[i] = new Person(pos, c);
        }
        int[] group = new int[101];
        for (int i = 0; i < n; i++) {
            Person p = people[i];
            if (p.c == 'G') {
                group[p.pos] = 1;
            } else {
                group[p.pos] = 2;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= 101-(k+1); i++) {
            int sum = 0;
            for (int j = i; j < i+k+1; j++) { // 차이가 1일때 뒤에 것도 세므로
                sum += group[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        // Please write your code here.
        // 1번부터 n번까지의 사람을 담는 배열을 만든다. int[] group
        // value = 0;
        // if (person[i].c == 'G') group[person[i].pos] = 1, else 2
        // group[person[i]] 
        System.out.print(maxSum);
    }
}

class Person {
    int pos;
    char c;

    Person () {

    }

    Person (int pos, char c) {
        this.pos = pos;
        this.c = c;
    }
}

// 