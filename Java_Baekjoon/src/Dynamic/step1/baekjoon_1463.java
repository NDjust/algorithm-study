package Dynamic.step1;/*
* BaekJoon https://www.acmicpc.net/problem/1463
* */

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_1463 {
    public static int[] d;

    public static int recursive(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0){
            return d[n];
        }
        
        d[n] = recursive(n - 1) + 1;
        
        if (n % 2 == 0) {
            int temp = recursive(n / 2) + 1;
            if (d[n] > temp){
                d[n] = temp;
            }
        }
        if (n % 3 == 0) {
            int temp = recursive(n / 3) + 1;
            if(d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        d = new int[num + 1];
        System.out.println(recursive(num));
    }
}
