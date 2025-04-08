

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        String Amax = A.replace("5", "6");
        String Bmax = B.replace("5", "6");
        String Amin = A.replace("6", "5");
        String Bmin = B.replace("6", "5");

        int min = Integer.parseInt(Amin) + Integer.parseInt(Bmin);
        int max = Integer.parseInt(Amax) + Integer.parseInt(Bmax);
        System.out.print(min + " " + max);
    }
}

//