import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
        // Please write your code here.

        Product p1 = new Product("codetree", 50);
        Product p2 = new Product(id2, code2);

        System.out.printf("product %d is %s\nproduct %d is %s", p1.code, p1.name, p2.code, p2.name);
    }
}

class Product {
    String name;
    int code;

    Product() {
        this.name = "";
        this.code = 0;
    }

    Product(String name, int code) {
        this.name = name;
        this.code = code;
    }
}