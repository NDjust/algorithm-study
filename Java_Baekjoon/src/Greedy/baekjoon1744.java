package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baekjoon1744 {
    public static void main(String[] args) {
        /* 틀림 아래 솔루션 참고해서 다시 풀어보고 해석.
        * */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            if (a <= 0) {
                minus.add(a);
            } else if (a > 0){
                plus.add(a);
            }
        }


        Collections.sort(plus);
        Collections.sort(minus);

        int ans = 0;

        for (int i = plus.size() - 1; i > 0; i-=2) {
            if (plus.get(i) != 1 && plus.get(i - 1) != 1) {
                ans += (plus.get(i) * plus.get(i - 1));
                continue;
            }

            if (plus.get(i - 1) == 1) {
                ans += plus.get(i);
                ans += plus.get(i - 1);
            }
        }

        if (plus.size() % 2 != 0) {
            ans += plus.get(0);
        }


        for (int i = minus.size() - 1; i > 0; i-=2) {
            ans += (minus.get(i) * minus.get(i - 1));
        }

        if (minus.size() % 2 != 0) {
            ans += minus.get(0);
        }

        System.out.println(ans);
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> plus = new ArrayList<Integer>();
        ArrayList<Integer> minus = new ArrayList<Integer>();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x == 1) {
                one += 1;
            } else if (x > 0) {
                plus.add(x);
            } else if (x < 0) {
                minus.add(x);
            } else {
                zero += 1;
            }
        }

        Collections.sort(plus);
        Collections.sort(minus);
        Collections.reverse(plus);

        if (plus.size() % 2 == 1) {
            plus.add(1);
        }

        if (minus.size() % 2 == 1) {
            minus.add(zero > 0 ? 0 : 1);
        }

        int ans = one;

        for (int i = 0; i < plus.size(); i += 2) {
            ans += (plus.get(i) * plus.get(i + 1));
        }

        for (int i = 0; i < minus.size(); i += 2) {
            ans += (minus.get(i) * minus.get(i + 1));
        }

        System.out.println(ans);
    }
}
