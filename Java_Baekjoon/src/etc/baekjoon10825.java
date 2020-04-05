package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baekjoon10825 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            students.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).name);
        }
    }
}

class Student implements Comparable<Student> {
    public String name;
    public int korea;
    public int english;
    public int math;

    public Student(String name, int korea, int english, int math) {
        this.name = name;
        this.korea = korea;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {
        if (this.korea != student.korea) {
            return student.korea - this.korea;
        } else if (this.english != student.english) {
            return this.english - student.english;
        } else if (this.math != student.math) {
            return student.math - this.math;
        } else {
            return this.name.compareTo(student.name);
        }
    }
}