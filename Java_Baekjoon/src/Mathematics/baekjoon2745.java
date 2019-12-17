package Mathematics;

import java.util.Scanner;

public class baekjoon2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        String s = line[0];

        int b = Integer.valueOf(line[1]);
        long result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
//                result += Math.pow(b, (s.length() - i - 1)) * (c - '0');
                result = result * b + (c - '0');
            } else {
//                result += Math.pow(b, (s.length() - i - 1)) * (c - 'A' + 10);
                result = result * b + (c - 'A' + 10);
            }
        }

        System.out.println(result);

    }
}
