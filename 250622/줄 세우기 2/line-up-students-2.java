import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            int num = i+1;
            int height = sc.nextInt();
            int weight = sc.nextInt();

            students[i] = new Student(num, height, weight);
        }
        
        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d %d\n", students[i].height, students[i].weight, students[i].num);
        }
    }
}

class Student implements Comparable<Student> {
    int num;
    int height;
    int weight;

    Student(int num, int height, int weight) {
        this.num = num;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student student) {
        if (this.height == student.height) {
            return student.weight - this.weight;
        }
        return this.height - student.height;
    }

}

// 키에 따라 오름차순
// 키 동일할 때 몸무게 내림차순
// 키 몸무게 둘다 동일할 때는 주어지지 않음
// 