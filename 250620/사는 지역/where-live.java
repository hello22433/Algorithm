import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();

            people[i] = new Person(names[i], addresses[i], regions[i]);
        }

        Arrays.sort(people, (a,b) -> {
            return a.name.compareTo(b.name);
        });

        System.out.printf("name %s\naddr %s\ncity %s", people[n-1].name, people[n-1].address, people[n-1].region);
    }
}

class Person {
    String name;
    String address;
    String region;

    Person(String name, String address, String region) {
        this.name = name;
        this.address = address;
        this.region = region;
    }
}