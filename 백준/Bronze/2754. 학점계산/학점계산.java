
import java.io.*;
import java.nio.Buffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        switch (a) {
            case "A+":
                System.out.println("4.3");
                break;
            case "A0":
                System.out.println("4.0");
                break;
            case "A-":
                System.out.println("3.7");
                break;
            case "B+":
                System.out.println("3.3");
                break;
            case "B0":
                System.out.println("3.0");
                break;
            case "B-":
                System.out.println("2.7");
                break;
            case "C+":
                System.out.println("2.3");
                break;
            case "C0":
                System.out.println("2.0");
                break;
            case "C-":
                System.out.println("1.7");
                break;
            case "D+":
                System.out.println("1.3");
                break;
            case "D0":
                System.out.println("1.0");
                break;
            case "D-":
                System.out.println("0.7");
                break;
            default:
                System.out.println("0.0");
        }
        
    }
}

// 티셔츠, 연필 모두 최소를 맞춰야 한다. 연필은 7로 나눈 몫 + 나머지
// 티셔츠는 각각에 대해 나누고 몫 + 나머지가0이아니라면 +1