package Mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class baekjoon3009 {

    public static int checkIn(ArrayList<Integer> a, int b) {
        for (int i = 0; i < a.size(); i++) {
            if (b == a.get(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();

        x.add(sc.nextInt());
        y.add(sc.nextInt());

        for (int i = 1; i < 3; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int ca = checkIn(x, a);
            int cb = checkIn(y, b);

            if (ca != -1) {
                x.remove(ca);
            } else {
                x.add(a);
            }

            if (cb != -1) {
                y.remove(cb);
            } else {
                y.add(b);
            }
        }
        System.out.printf("%d %d", x.get(0), y.get(0));
    }
}
