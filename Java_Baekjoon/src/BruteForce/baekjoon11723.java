package BruteForce;

import java.util.Scanner;

public class baekjoon11723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            String str = sc.next();
            switch (str) {
                case "add":
                    s = s | (1 << (sc.nextInt() - 1));
                    break;
                case "remove":
                    s = s & ~(1 << (sc.nextInt() - 1));
                    break;
                case "check":
                    if ((s & (1 << sc.nextInt() - 1)) == 0) {
                        sb.append("0\n");
                    } else {
                        sb.append("1\n");
                    }
                    break;
                case "toggle":
                    s = s ^ (1 << (sc.nextInt() - 1));
                    break;
                case "all":
                    s = (1 << 21) - 1;
                    break;
                default:
                    s = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}