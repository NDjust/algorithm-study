package etc;

import java.util.Scanner;
import java.util.Vector;

public class baekjoon1168 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < n; i++) {
            vector.add(i+1);
        }

        int now = k - 1;

        while (true) {
            sb.append(vector.remove(now));
            if (vector.isEmpty()) {
               break;
            }
            sb.append(", ");
            now += k - 1;
            now %= vector.size();
        }

        System.out.println("<" + sb + ">");
    }
}
