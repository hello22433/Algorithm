import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            // Please write your code here.
            people[i] = new Person(name, height, weight);
        }
        Arrays.sort(people, (a,b) -> {
            if (a.height == b.height) {
                return b.weight - a.weight;
            }
            return a.height - b.height;
        });

        for (int i = 0; i < n; i++) 
            System.out.println(people[i].name + " " + people[i].height + " " + people[i].weight);
    }
}

class Person {
    String name;
    int height;
    int weight;

    Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}