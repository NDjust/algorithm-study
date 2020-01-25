package Sorting;

import java.util.Scanner;

public class bakejoon11651 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] xy = new int[n][2];

        for (int i = 0; i <n ; i++) {
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }


        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (xy[i][1] > xy[j][1]) {
                    int[] tmp = xy[i];
                    xy[i] = xy[j];
                    xy[j] = tmp;
                } else if (xy[i][1] == xy[j][1]) {
                    if (xy[i][0] > xy[j][1]) {
                        int[] tmp = xy[i];
                        xy[i] = xy[j];
                        xy[j] = tmp;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d\n", xy[i][0], xy[i][1]);
        }
    }
}
