import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] weight = new int[n];
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            int num = i+1;
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();

            students[i] = new Student(num, height[i], weight[i]);
        }
        // Please write your code here.
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
        if (student.height == this.height) {
            if (student.weight == this.weight) {
                return this.num - student.num;
            }
            return student.weight - this.weight;
        }
        return student.height - this.height;
    }
}


// 키에 따라 내림차순
// 키동일하면 몸무게 내림차순
// 키몸무게 동일하면 번호 오름차순

// 