package goorm;

import java.util.Scanner;

public class Inventory {
    public static int solution(int n, int m) {
        int answer = 0;
        int currentCount = n;

        while (currentCount != 0) {
            answer++;
            currentCount--;

            if (answer % m == 0) {
                currentCount++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int answer = solution(n, m);

        System.out.println(answer);
    }
}
