package KakaoCodeFestival;

import java.util.Scanner;

public class baekjoon15953 {
    private static final int[] award2017 = {500, 300, 200, 50, 30, 10};
    private static final int[] awardNum2017 = {1, 2, 4, 7, 11, 16, 22};
    private static final int[] award2018 = {512, 256, 128, 64, 32};
    private static final int[] awardNum2018 = {1, 2, 4, 8, 16, 32};

    public static int getAward(int a, int year) {
        int ans = 0;
        if (year == 2017) {
            for (int i = 1; i < awardNum2017.length; i++) {
                if (awardNum2017[i - 1] <= a && awardNum2017[i] > a) {
                    ans += award2017[i - 1] * 10000;
                }
            }
        } else {
            for (int i = 1; i < awardNum2018.length; i++) {
                if (awardNum2018[i - 1] <= a && awardNum2018[i] > a) {
                    ans += award2018[i - 1] * 10000;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            ans[i] = getAward(a, 2017) + getAward(b, 2018);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
