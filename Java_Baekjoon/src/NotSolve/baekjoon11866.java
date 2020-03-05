package NotSolve;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> circle = new ArrayList<Integer>();
        int[] ans = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            circle.add(i + 1);
        }

        sb.append("<");
        for (int i = 0; i < n; i++) {
            String a = Integer.toString(circle.get(((2 + (k * i)) % (n - i))));
            circle.remove(((2 + (k * i)) % (n - i)));
            System.out.println(((2 + (k * i)) % (n - i)));
            if (i == 6) {
                sb.append(a);
            } else {
                sb.append(a + ", ");
            }
        }
        sb.append(">");
        System.out.println(sb);

    }
}
