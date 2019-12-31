package Greedy;

// Runtime Error.

import java.util.Scanner;

public class baekjoon1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] rooms = new int[2][n];

        for (int i = 0; i < n; i++) {
            rooms[0][i] = sc.nextInt();
            rooms[1][i] = sc.nextInt();
            sc.nextLine();
        }


        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rooms[1][i] == rooms[1][j]) {
                    if (rooms[0][i] > rooms[0][j]) {
                        int[] tmp = rooms[i];
                        rooms[i] = rooms[j];
                        rooms[j] = tmp;
                    }
                } else {
                    if (rooms[1][i] > rooms[1][j]) {
                        int[] tmp = rooms[i];
                        rooms[i] = rooms[j];
                        rooms[j] = tmp;
                    }
                }

            }
        }

        int ans = 0;
        int now = 0;

        for (int i = 0; i < n; i++) {
            if (now <= rooms[0][i]) {
                now = rooms[1][i];
                ans++;
            }
        }

        System.out.println(ans);
    }

}
