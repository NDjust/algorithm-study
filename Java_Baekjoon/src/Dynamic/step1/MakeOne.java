/*
https://www.acmicpc.net/problem/1463
D[N] = N => 1 만드는데 필요한 연산의 최소값.
Dynamic은 D에 넣어서 적용!
1. N를 1로 나눠서 1로 만드는 최솟값.
- N -> N / 3 (1번)
- N/3 -> 1 (D[N/3]번)

2. N를 2로 나눠서 1로 만드는 최솟값.
- N -> N / 2 -> 1번
- N/3 -> 1 (D[N/2]번)

 3. N를 1로 나눠서 1로 만드는 최솟값.
- N -> N - 1 -> 1번
- N - 1 -> 1 (D[N - 1]번)

즉 위에 세가지 경우를 비교해 최솟값을 계속 변경.

시간 복잡도  O(N)
 */
package Dynamic.step1;

public class MakeOne {
    public static void main(String[] args) {
        System.out.println(TopDown(10));
    }

    public static int TopDown(int n) {
        int[] d = new int[n];
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];

        d[n] = TopDown(n - 1) + 1;

        if (n % 2 == 0) {
            int temp = TopDown(n / 2) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        if (n % 3 == 0) {
            int temp = TopDown(n / 3) + 1;
            if (d[n] > temp) d[n] = temp;
        }
        return d[n];
    }

    public static int BottomUp(int n) {
        int[] d = new int[n];
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
            }
        }
        return d[n];
    }
}
