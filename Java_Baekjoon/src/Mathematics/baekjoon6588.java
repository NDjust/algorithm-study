package Mathematics;

import java.io.*;
import java.util.Scanner;

public class baekjoon6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] era = new boolean[1000000+1];
        era[0] = false;
        era[1] = false;

        for (int i = 2; i <= 1000000; i++) {
            era[i] = true;
        }

        for (int i = 2; i * i <= 1000000; i++) {
            for (int j = i*i; j <= 1000000; j+=i) {
                era[j] = false;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }


            int a = 0;
            int max = 0;

            for (int i = 3; i <= n; i++) {
                if (era[i] && era[n-i] && n-i > max) {
                    max = n - i;
                    a = i;
                    break;
                }
            }
            String s = String.format("%d = %d + %d\n", n, a, n-a);
            bw.write(s);
        }
        bw.flush();
    }
}
