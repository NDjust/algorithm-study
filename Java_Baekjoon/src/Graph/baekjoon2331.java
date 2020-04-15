package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baekjoon2331 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        int count = 0;

        // 수학적 귀납법으로 최대 배열 크기 생성
        int[] d = new int[1000000];
        boolean[] visited = new boolean[1000000];
        int i = 2;
        d[1] = a;
        visited[a] = true;
        int value = 0;

        while (true) {
            value = 0;
            String s = d[i - 1] + "";

            for (int j = 0; j < s.length(); j++) {
                value += Math.pow(s.charAt(j) - 48, p);
            }
            d[i++] = value;

            if (visited[value]) {
                break;
            }

            visited[value] = true;
        }
        int j = 1;

        while (d[j] != value) {
            count++;
            j++;
        }

        System.out.println(count);
    }
}
