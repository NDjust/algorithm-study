package etc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class baekjoon1850 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        BigInteger c = getGcd(a, b);
        while (true) {
            if (c.equals(BigInteger.ZERO)) {
                break;
            }
            bw.write("1");;
            c = c.subtract(BigInteger.valueOf(1));

        }
        bw.flush();
    }


    public static BigInteger getGcd(BigInteger a, BigInteger b) {
        while (b != BigInteger.valueOf(0)) {
            BigInteger r = a.remainder(b);
            a = b;
            b = r;
        }
        return a;
    }
}
