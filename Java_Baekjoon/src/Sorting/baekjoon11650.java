package Sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class baekjoon11650 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] xy= new int[n][2];

        for(int i = 0; i < n; i++) {
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }

        Arrays.sort(xy, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d\n", xy[i][0], xy[i][1]);
        }



    }
}
