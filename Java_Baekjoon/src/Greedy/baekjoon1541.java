package Greedy;

import java.util.ArrayList;
import java.util.Scanner;


public class baekjoon1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> sign = new ArrayList<>();
        boolean minus = false;
        int cur = 0;

        sign.add(1);

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-') {
                if (input.charAt(i) == '+') {
                    sign.add(1);
                } else {
                    sign.add(-1);
                }
                num.add(cur);
                cur = 0;
            } else {
                cur = cur * 10 + (input.charAt(i) - '0'); // 숫자 자리 수 맞추기.
            }
        }

        num.add(cur);

        int ans = 0;
        minus = false;

        for (int i = 0; i < num.size(); i++) {
            if (sign.get(i) == -1) { // -가 나오면 뒤에 있는 모든 숫자 괄호로 묶어서 -로 취급.
                minus = true;
            }

            if (minus) {
                ans -= num.get(i);
            } else {
                ans += num.get(i);
            }
        }

        System.out.println(ans);
    }
}
