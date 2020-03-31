package Dynamic.step1;

import java.util.*;
/*
* 문제(https://www.acmicpc.net/problem/11722)
수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 감소하는 부분 수열의 길이를 출력한다.
*
* 예제 입력 1
6
10 30 10 20 20 10

* 예제 출력 1
3
* */

public class baekjoon11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());
        int a[] = new int[n];
        int d[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = n - 1; i > -1; i--) {
            d[i] = 1;
            for (int j = n - 1; j > i; j--) {
               if (a[i] > a[j] && d[i] < d[j] + 1 ){
                   d[i] = d[j] + 1;
                }
            }
        }
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            if (maxLength < d[i]) {
                maxLength = d[i];
            }
        }
        System.out.println(maxLength);
    }
}
