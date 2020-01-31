package BruteForce;

import java.util.Scanner;

public class baekjoon9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int d[] = new int[11];

        d[1]=1;
        d[2]=2;
        d[3]=4;

        for(int i=4; i<11; i++) {
            d[i] = d[i-1]+d[i-2]+d[i-3];
        }

        for(int i=0; i<t; i++) {
            System.out.println(d[sc.nextInt()]);
        }
    }

    public static int go(int count, int sum, int goal) {
        if (count > 10) {
            return 0;
        }

        if(sum > goal) {
            return 0;
        }

        if (sum == goal) {
            return 1;
        }

        int now = 0;

        for (int i = 1; i < 3; i++) {
            now += go(count + 1, sum + i, goal);
        }

        return now;
    }
}
