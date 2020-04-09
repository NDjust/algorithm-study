package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2004 {

    public static long getCounts(long t, long d) {
        long ret = 0;
        long dt = d;

        while (t >= dt) {
            ret += (t / dt);
            dt *= d;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n, m;
        long five = 5;
        long two = 2;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long fiveCount = getCounts(n , five);
        long twoCount = getCounts(n , two);

        fiveCount -= getCounts(m, five);
        twoCount -= getCounts(m, two);

        fiveCount -= getCounts(n-m, five);
        twoCount -= getCounts(n-m, two);

        System.out.println(fiveCount > twoCount ? twoCount : fiveCount);
    }


}
