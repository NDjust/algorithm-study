package etc;

import java.util.*;


// ref - https://fbtmdwhd33.tistory.com/84
public class baekjoon11652 {

    static long card[];

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        card = new long[n];


        for (int i = 0; i < n; i++) {
            card[i] = sc.nextLong();
        }

        if (n == 1) {
            System.out.println(card[0]);
            return;
        }

        Arrays.sort(card);

        int cnt = 1;
        int aCnt = 0;
        long ans = 0;

        for (int i = 0; i < n-1; i++) {
            if (i == n-2) {
                if (card[i] == card[i+1]) {
                    cnt++;
                }

                if (aCnt < cnt) {
                    aCnt = cnt;
                    ans = card[i];
                    cnt = 1;
                } else if (aCnt == cnt) {
                    ans = Math.min(ans, card[i]);
                }
            } else if (card[i] == card[i+1]) {
                cnt++;
            } else {
                if (aCnt < cnt) {
                    aCnt = cnt;
                    ans = card[i];
                    cnt = 1;
                } else if (aCnt == cnt) {
                    ans = Math.min(ans, card[i]);
                    aCnt = cnt;
                    cnt = 1;
                } else {
                    cnt = 1;
                }
            }
        }
        System.out.println(ans);
    }
}