import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        // Please write your code here.

        Unit unit1 = new Unit();
        unit1.id = "codetree";
        unit1.level = 10;

        Unit unit2 = new Unit();
        unit2.id = id;
        unit2.level = level;
        
        System.out.printf("user %s lv %d\n", unit1.id, unit1.level);
        System.out.printf("user %s lv %d", unit2.id, unit2.level);
    }
    
}

class Unit {
    String id;
    int level;

    Unit() {
        this.id = "";
        this.level = 0;
    }

    Unit(String id, int level) {
        this.id = id;
        this.level = level;
    }
}