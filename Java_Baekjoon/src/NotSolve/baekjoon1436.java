package NotSolve;

import java.util.Scanner;

public class baekjoon1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = "666";

        int quotient = n / 10;
        int reminder = n % 10;


        for (int i = 0; i < quotient; i++) {
            if (reminder ==  0) {
                continue;
            }
            name = "6" + name;
        }

        int front = 0;

        if (reminder == 0) {
            front = 9;
        } else {
            front = quotient + reminder - 1;
        }

        if (front == 0) {
            System.out.println(name);
        } else {
            name = Integer.toString(front) + name;
            System.out.println(name);
        }
    }
}
