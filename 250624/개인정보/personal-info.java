import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        Person[] people = new Person[n];
        String[] names = new String[n];
        int[] heights = new int[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            heights[i] = sc.nextInt();
            weights[i] = sc.nextDouble();

            people[i] = new Person(names[i], heights[i], weights[i]);
        }

        Arrays.sort(people);
        System.out.println("name");
        for (int i = 0; i < n; i++) 
            System.out.printf("%s %d %.1f\n", people[i].name, people[i].height, people[i].weight);
        System.out.println();

        System.out.println("height");
        Arrays.sort(people, (a,b) -> {
            return b.height-a.height;
        });
        for (int i = 0; i < n; i++) 
            System.out.printf("%s %d %.1f\n", people[i].name, people[i].height, people[i].weight);
    }
}

class Person implements Comparable<Person> {
    String name;
    int height;
    double weight;
    
    Person(String name, int height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}