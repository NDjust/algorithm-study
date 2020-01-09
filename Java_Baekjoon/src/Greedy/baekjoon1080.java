package Greedy;

import java.util.Scanner;

public class baekjoon1080 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        char[][] aMatrix = new char[n][m];
        char[][] bMatrix = new char[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();

            for (int j = 0; j < s1.length(); j++) {
                aMatrix[i][j] = s1.charAt(j);
            }
        }


        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();

            for (int j = 0; j < s1.length(); j++) {
                bMatrix[i][j] = s1.charAt(j);
            }
        }

        for (int i = 0; i < n -2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (aMatrix[i][j] != bMatrix[i][j]) {
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3 ; l++) {
                            if (aMatrix[k][l] == '1') {
                                aMatrix[k][l] = '0';
                            } else if (aMatrix[k][l] == '0'){
                                aMatrix[k][l] = '1';
                            }
                        }
                    }
                    ans++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (aMatrix[i][j] != bMatrix[i][j]) {
                    ans = -1;
                }
            }
        }


        if (ans == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }
}
