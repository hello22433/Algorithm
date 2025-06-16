import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        IntegerValue nn = new IntegerValue(n);
        IntegerValue mm = new IntegerValue(m);

        swap(nn, mm);

        System.out.print(nn.val + " " + mm.val);
    }

    public static void swap(IntegerValue nn, IntegerValue mm) {
        int temp = nn.val;
        nn.val = mm.val;
        mm.val = temp;
    }
}

class IntegerValue {
    int val;

    public IntegerValue(int val) {
        this.val = val;
    }
}